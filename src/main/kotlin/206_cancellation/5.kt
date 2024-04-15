package f_206_cancellation.s_5

import kotlinx.coroutines.*

// 9장 취소 101p
suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            repeat(1_000) { i ->
                delay(200)
                println("Printing $i")
            }
        } catch (e: CancellationException) { // 잡이 취소 시 Cancelling 상태로 바뀌고 첫번째 중단점에서 예외 던짐.
            println(e)
            throw e
        }
    }
    delay(1100)
    job.cancelAndJoin()
    println("Cancelled successfully")
    delay(1000)
}
// Printing 0
// Printing 1
// Printing 2
// Printing 3
// Printing 4
// JobCancellationException...
// Cancelled successfully
//sampleEnd
