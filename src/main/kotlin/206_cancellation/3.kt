package f_206_cancellation.s_3

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// 9장 취소 99p
suspend fun main() = coroutineScope {
    val job = launch {
        repeat(1_000) { i ->
            delay(100)
            Thread.sleep(100) // 오래 걸리는 작업이라고 가정
            println("Printing $i")
        }
    }

    delay(1000)
    job.cancel()
    job.join() // 코루틴이 취소를 마칠때까지 중단되므로 경쟁 상태가 발생하지않음
    println("Cancelled successfully")
}
// Printing 0
// Printing 1
// Printing 2
// Printing 3
// Printing 4
// Cancelled successfully
//sampleEnd
