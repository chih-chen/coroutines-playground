package cryptography

import kotlinx.coroutines.delay
import utils.Utils.log

class CryptographyService {

    suspend fun encrypt(data: String): String {
        log("encrypting $data")
        delay(5000)
        return "encrypted.$data"
    }

    fun decrypt(data: String): String {
        return data.removePrefix("encrypted.")
    }
}