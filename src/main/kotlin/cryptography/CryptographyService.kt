package cryptography

import kotlinx.coroutines.delay
import utils.Utils.log

class CryptographyService {

    /*
    * Notice that after delay suspension point, the "callback" is executed in another thread-worker
    * */
    suspend fun encrypt(data: String): String {
        log("Encrypting $data")
        delay(5000)
        log("Done encrypting $data")
        return "encrypted.$data"
    }

    suspend fun encryptWithError(data: String): String {
        log("Encrypting $data")
        delay(5000)
        throw UnsupportedOperationException()
    }

    fun decrypt(data: String): String {
        return data.removePrefix("encrypted.")
    }
}