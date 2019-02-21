package main

import cryptography.CryptographyService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import utils.Utils.log

/*
* Async encryption strategy, but fails.
* Notice when the first fail, all others are still running, they are not cancelled = leak.
* */
suspend fun main() {

    usecase()

    println("Finish use case")

    delay(5000)
}

private suspend fun usecase() {
    val cryptographyService = CryptographyService()

    val input = mapOf(
        "name" to "Chih",
        "cpf" to "123.456.789-10",
        "account" to "123-4",
        "branch" to "765",
        "password" to "password123"
    )

    val start = System.currentTimeMillis()
    val encryptedInput = input.mapValues { (_, value) ->
        log("Starting...")
        CoroutineScope(Dispatchers.Default).async {
            cryptographyService.encryptWithError(value)
        }
    }
    val end = System.currentTimeMillis()
    log("${end - start} ms")

    log(encryptedInput.mapValues { it.value.await() }.toString())
}