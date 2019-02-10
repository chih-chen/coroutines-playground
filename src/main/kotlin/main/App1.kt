package main

import io.CryptographyService
import kotlinx.coroutines.runBlocking

/*
* Running suspend function, but on the same thread.
* What happens is that the execution of encrypt blocks the thread.
* */

suspend fun main() = runBlocking {
    println("current thread: ${Thread.currentThread().name}")

    val cryptographyService = CryptographyService()

    val cpf = "123.456.789-10"

    val encryptedCpf = cryptographyService.encrypt(cpf)
    println("Back to runBlocking")

    println(encryptedCpf)
}