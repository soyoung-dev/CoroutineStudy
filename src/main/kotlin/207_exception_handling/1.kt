package f_207_exception_handling.s_1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 10장 예외처리 113p
fun main(): Unit = runBlocking {
    launch {
        launch {
            delay(1000)
            throw Error("Some error")
        }

        launch {
            delay(2000)
            println("Will not be printed 111")
        }

        launch {
            delay(500) // 예외 발생보다 빠름
            println("Will be printed 222")
        }
    }

    launch {
        delay(2000)
        println("Will not be printed 333")
    }
}
// Will be printed
// Exception in thread "main" java.lang.Error: Some error...
//sampleEnd
