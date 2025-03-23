package store.pilsaapp.pilsa_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PilsaApiApplication

fun main(args: Array<String>) {
    runApplication<PilsaApiApplication>(*args)
}
