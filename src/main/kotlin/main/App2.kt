package main

import io.CryptographyService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
* Running suspend function on a fire and forget coroutine builder.
* What happens is that the execution of encrypt does not block the main thread.
* */

suspend fun main() = runBlocking {
    println("current thread: ${Thread.currentThread().name}")

    val cryptographyService = CryptographyService()

    val cpf = "123.456.789-10"

    val encryptedCpf = launch(Dispatchers.Default) { cryptographyService.encrypt(cpf) }
    println("Back to runBlocking")

    //At the moment this is printed out, it is still active
    println(encryptedCpf)
}