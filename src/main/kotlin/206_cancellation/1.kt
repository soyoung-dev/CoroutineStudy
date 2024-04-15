package f_206_cancellation.s_1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.coroutineScope

// 9장 취소 98p
suspend fun main(): Unit = coroutineScope {
    val job = launch {
        repeat(1_000) { i ->
            delay(200)
            println("Printing $i")
        }
    }

    delay(1100) // 1.1초 동안 main 코루틴 일시 중단
    job.cancel()
    job.join() // 다음 작업 진행전에 취소과정 완료되는 걸 기다림
    println("Cancelled successfully")
}
// Printing 0
// Printing 1
// Printing 2
// Printing 3
// Printing 4
// Cancelled successfully
//sampleEnd
