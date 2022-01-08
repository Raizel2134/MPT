package mpt.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration

@SpringBootApplication
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration::class)
class RestApplication

fun main(args: Array<String>) {
    runApplication<RestApplication>(*args)
}
