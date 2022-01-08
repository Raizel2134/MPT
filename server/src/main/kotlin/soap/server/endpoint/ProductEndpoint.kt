package soap.server.endpoint

import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import product.Product
import product.ProductRequest
import product.ProductResponse

const val NAMESPACE_URI = "http://product"

@Endpoint
class ProductEndpoint {
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ProductRequest")
    @ResponsePayload
    fun getProduct(@RequestPayload request: ProductRequest): ProductResponse {
        val response = ProductResponse()
        response.product.addAll(
                listOf(Product().apply {
                    id = 1L
                    name = "First"
                    description = "First product"
                    price = 1000.00
                }, Product().apply {
                    id = 2L
                    name = "Two"
                    description = "Two product"
                    price = 1000.00
                })
        )
        return response
    }
}