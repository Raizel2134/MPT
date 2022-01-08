package mpt.flux.controller

import mpt.flux.domain.Product
import mpt.flux.service.ProductService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/product")
class ProductController(
        val productService: ProductService
) {
    @GetMapping
    fun findAll(): Flux<Product> = productService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Mono<Product> = productService.findById(id)

    @PostMapping
    fun add(@RequestBody product: Product): Mono<Product> = productService.addOne(product)
}