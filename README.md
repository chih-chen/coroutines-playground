Kotlin coroutine playground
---------------------------------------

This repository contains many experiments with Kotlin coroutine.

### Suspending functions
### Coroutine Context
The coroutine context is a **set of rules and configurations** that define how the coroutine will be executed.

One of the possible configurations is the **dispatcher** that is used to identify the thread where the coroutine will be executed.

Dispatchers implement `CoroutineContext`. 

We can provide the dispatcher in tow different ways: 
1. Explicitly set the dispatcher that will be used
2. Inferred by the coroutine scope. 

- It is fine to have suspend function running inside async builder
