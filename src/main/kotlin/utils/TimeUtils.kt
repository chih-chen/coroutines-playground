package utils

object TimeUtils {

    fun measureInMillis(block: () -> Unit) {
        val start = System.currentTimeMillis()
        block()
        val end = System.currentTimeMillis()
        println("Time elapsed: ${end - start} ms")
    }
}