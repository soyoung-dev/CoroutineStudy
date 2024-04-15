package f_206_cancellation.s_6

import kotlinx.coroutines.*
import kotlin.random.Random

// 9장 취소 102p
suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(Random.nextLong(2000))
            println("Done")
        } finally { // 코루틴 취소 후에도 자원 정리
            print("Will always be printed")
        }
    }
    delay(1000)
    job.cancelAndJoin()
}
// Will always be printed
// (또는)
// Done
// Will always be printed
//sampleEnd
