package cryptography

import kotlinx.coroutines.delay
import utils.Utils.log

class CryptographyService {

    /*
    * Notice that after delay suspension point, the "callback" is executed in another thread-worker
    * */
    suspend fun encrypt(data: String): String {
        log("encrypting $data")
        delay(5000)
        log("done $data")
        return "encrypted.$data"
    }

    fun decrypt(data: String): String {
        return data.removePrefix("encrypted.")
    }
}