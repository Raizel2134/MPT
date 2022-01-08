package mpt.flux.service

import mpt.flux.domain.Product
import mpt.flux.domain.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class ProductService (
        val productRepo: ProductRepository
) {
    fun findAll(): Flux<Product> {
        return productRepo.findAll()
    }

    fun findById(id: Long): Mono<Product> {
        return productRepo.findById(id)
    }

    fun addOne(product: Product): Mono<Product> {
        return productRepo.save(product)
    }
}