package mpt.flux.domain

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ProductRepository : ReactiveCrudRepository<Product, Long>