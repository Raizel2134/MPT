package mpt.rest.domain

import java.io.Serializable
import javax.persistence.*

@Entity
class Orders(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0L,
        @OneToMany(cascade = [CascadeType.MERGE])
        var products: List<Product>
) : Serializable