package main

import cryptography.CryptographyService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import utils.Utils.log

/*
* Async encryption strategy, but fails.
* Note how join() does not rethrow the exception. Also, it returns Unit.
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

    coroutineScope {
        val encryptedName = async(context = Dispatchers.IO) {
            try {
                cryptographyService.encrypt(input.getValue("name"))
            } finally {
                println("cancelled")
            }
        }
        val encryptedCpf = async(context = Dispatchers.IO) {
            cryptographyService.encryptWithError(input.getValue("cpf"))
        }

        log(encryptedName.await())
        log(encryptedCpf.await())
    }
}

