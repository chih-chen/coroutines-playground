package main

import cryptography.CryptographyService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import utils.Utils.log

/*
* Async encryption strategy, but fails.
* Notice when the first fail, all others are still running, they are not cancelled = leak.
* */
fun main() = runBlocking {
    val cryptographyService = CryptographyService()

    usecase(cryptographyService)

    println("Finish use case")
}

private suspend fun usecase(cryptographyService: CryptographyService) {

    val input = mapOf(
        "name" to "Chih",
        "cpf" to "123.456.789-10",
        "account" to "123-4",
        "branch" to "765",
        "password" to "password123"
    )

    val start = System.currentTimeMillis()
    val encryptedInput = input.mapValues { (key, value) ->
        CoroutineScope(Dispatchers.IO).async {
            when (key) {
                "name" -> cryptographyService.encryptWithError(value)
                else -> cryptographyService.encrypt(value)
            }
        }
    }
    val end = System.currentTimeMillis()
    log("${end - start} ms")

    log(encryptedInput.mapValues { it.value.await() }.toString())
}