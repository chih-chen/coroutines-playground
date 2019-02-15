package main

import cryptography.CryptographyService
import utils.TimeUtils.measureInMillis

//save account use case
fun main() {

    val cryptographyService = CryptographyService()

    val input = mapOf(
        "name" to "Chih",
        "cpf" to "123.456.789-10",
        "account" to "123-4",
        "branch" to "765",
        "password" to "password123"
    )

    measureInMillis {
        val encryptedInput = input.mapKeys { (_, value) ->
            cryptographyService.encrypt(value)
        }
        println(encryptedInput)
    }
}