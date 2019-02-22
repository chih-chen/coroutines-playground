package cryptography

import cryptography.CryptographyStatus.resolve
import kotlinx.coroutines.delay

class CryptographyService {

    /*
    * Notice that after delay suspension point, the "callback" is executed in another thread-worker
    * */
    suspend fun encrypt(data: String): String {
        repeat(5) {
            resolve(it, data)
            delay(1000)
        }
        return "encrypted.$data"
    }

    fun encryptWithError(data: String): String {
        println("Failing...")
        throw UnsupportedOperationException(data)
    }

    fun decrypt(data: String): String {
        return data.removePrefix("encrypted.")
    }
}