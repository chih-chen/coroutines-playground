package cryptography

class CryptographyService {

    fun encrypt(data: String): String {
        return "encrypted.$data"
    }

    fun decrypt(data: String): String {
        return data.removePrefix("encrypted.")
    }
}