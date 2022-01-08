package mpt.client.controller

import mpt.client.ProductClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class ProductController {
    @Autowired
    lateinit var product: ProductClient

    @RequestMapping("/getProduct")
    fun getProduct(model: Model): String {
        val resp = product.getProducts("")
        model.addAttribute("products", resp)
        return "product"
    }
}
