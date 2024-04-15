package f_206_cancellation.s_7

import kotlinx.coroutines.*
import kotlin.random.Random

// 9장 취소 103p
suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(2000)
            println("Job is done")
        } finally {
            println("Finally")
            launch { // 코루틴이 이미 취소되었으므로 무시됨
                println("Will not be printed")
            }
            delay(1000) // 여기서 예외 발생 - finally 블록은 취소 후에도 실행되기 때문에 delay 권장되지 않음.
            println("Will not be printed")
        }
    }
    delay(1000)
    job.cancelAndJoin()
    println("Cancel done")
}
// (1 sec)
// Finally
// Cancel done
