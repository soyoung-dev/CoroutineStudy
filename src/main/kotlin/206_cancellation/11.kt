package f_206_cancellation.s_11

import kotlinx.coroutines.*

// 9장 취소 106p
suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        repeat(1_000) { i ->
            // 코루틴 내부에 중단점이 없기 떄문에 취소할 수 없는 상황
            Thread.sleep(200) // 여기서 복잡한 연산이나
            // 파일을 읽는 등의 작업이 있다고 가정
            println("Printing $i")
        }
    }
    delay(1000)
    job.cancelAndJoin()
    println("Cancelled successfully")
    delay(1000)
}
// Printing 0
// Printing 1
// Printing 2
// ... (up to 1000)
//sampleEnd
