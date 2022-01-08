package mpt.flux.domain

import org.springframework.data.annotation.Id
import java.io.Serializable

class Product(
        @Id
        var id: Long? = null,
        var name: String? = null,
        var description: String? = null,
        var price: Double? = null
) : Serializable

