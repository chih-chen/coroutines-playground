package cryptography

import utils.Utils.log

object CryptographyStatus {

    fun resolve(number: Int, data: String) = when (number) {
        0 -> log("Starting encrypting $data")
        1 -> log("Preparing encryption request of $data")
        2 -> log("Sending request for $data")
        3 -> log("Waiting for the response of $data")
        4 -> log("Done encrypting $data")
        else -> throw IndexOutOfBoundsException()
    }
}