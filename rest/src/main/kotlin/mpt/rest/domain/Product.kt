package mpt.rest.domain

import java.io.Serializable
import javax.persistence.*

@Entity
class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        var name: String? = null,
        var description: String? = null,
        var price: Double? = null,
) : Serializable

