package mpt.camunda.process

import com.fasterxml.jackson.databind.ObjectMapper
import mpt.rest.domain.Orders
import org.camunda.bpm.engine.delegate.BpmnError
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import java.lang.Exception
import kotlin.streams.toList
import mpt.rest.domain.Product as rProduct
import mpt.rest.domain.Product as fProduct

@Component
class OrderProcess : JavaDelegate {
    var restTemplate = RestTemplate()
    val objectMapper = ObjectMapper()
    val messageConverter = MappingJackson2HttpMessageConverter()

    @Autowired
    lateinit var clientBuilder: WebClient.Builder

    override fun execute(delegateExecution: DelegateExecution) {
        val temp = mutableListOf<rProduct>()

        messageConverter.setPrettyPrint(false)
        messageConverter.objectMapper = objectMapper
        restTemplate.messageConverters.removeIf { m: HttpMessageConverter<*> -> m.javaClass.name == MappingJackson2HttpMessageConverter::class.java.name }
        restTemplate.messageConverters.add(messageConverter)

        val idProduct = delegateExecution.getVariable("idProduct") as Long? ?: throw BpmnError("isProductError")

        try {
            val response = clientBuilder.build().get().uri("http://127.0.0.1:8083/product/$idProduct")
                .retrieve().bodyToFlux(fProduct::class.java)

            response.toStream().toList().forEach {
                temp.add(
                    rProduct(
                        id = it.id,
                        name = it.name,
                        description = it.description,
                        price = it.price,
                    )
                )
            }

            restTemplate.postForLocation(
                "http://127.0.0.1:8082/orderses", Orders(
                    products = temp
                )
            )
        } catch (e: Exception){
            println(e.message)
            throw BpmnError("isOrderError")
        }
    }
}