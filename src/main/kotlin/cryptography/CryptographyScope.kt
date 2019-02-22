package cryptography

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object CryptographyScope : CoroutineScope {
    override val coroutineContext: CoroutineContext =
        Dispatchers.IO + CoroutineName("CryptographyScope")
}