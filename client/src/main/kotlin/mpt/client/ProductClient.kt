package mpt.client

import org.springframework.ws.client.core.support.WebServiceGatewaySupport
import org.springframework.ws.soap.client.core.SoapActionCallback
import soap.server.Product
import soap.server.ProductRequest
import soap.server.ProductResponse

class ProductClient : WebServiceGatewaySupport() {
    fun getProducts(name: String): ProductResponse {
        val request = ProductRequest()
        request.name = name
        return webServiceTemplate.marshalSendAndReceive(
                "http://localhost:3040/ws/product",
                request
        ) as ProductResponse
    }
}