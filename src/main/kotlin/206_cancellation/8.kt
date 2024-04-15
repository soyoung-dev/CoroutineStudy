package f_206_cancellation.s_8

import kotlinx.coroutines.*
import kotlin.random.Random

// 9장 취소 103p
suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(200)
            println("Coroutine finished")
        } finally { // 항상 실행
            println("Finally")
            withContext(NonCancellable) { // 새로운 코루틴 블록 실행. 상위 코루틴이 취소되어도 이 블록은 취소 안됨.
                delay(1000L)
                println("Cleanup done")
            }
        }
    }
    delay(100) // main 코루틴 일시 중단
    job.cancelAndJoin()
    println("Done")
}
// Finally
// Cleanup done
// Done
//sampleEnd
