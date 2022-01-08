package mpt.client.config

import mpt.client.ProductClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import soap.server.Product
import soap.server.ProductRequest
import soap.server.ProductResponse


@Configuration
open class ProductConfiguration {
    @Bean
    open fun marshaller(): Jaxb2Marshaller {
        val marshaller = Jaxb2Marshaller()
        marshaller.setClassesToBeBound(ProductResponse::class.java, Product::class.java, ProductRequest::class.java)
        return marshaller
    }

    @Bean
    open fun productClient(marshaller: Jaxb2Marshaller): ProductClient {
        val client = ProductClient()
        client.defaultUri = "http://localhost:3040/ws"
        client.marshaller = marshaller
        client.unmarshaller = marshaller
        return client
    }
}