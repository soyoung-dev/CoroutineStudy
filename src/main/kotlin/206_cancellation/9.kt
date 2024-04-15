package f_206_cancellation.s_9

import kotlinx.coroutines.*

// 9장 취소 104p
suspend fun main(): Unit = coroutineScope {
    val job = launch {
        delay(1000) // 코루틴 1초동안 일시 중단
    }
    job.invokeOnCompletion { exception: Throwable? -> // 코루틴 실행이 완료되거나 취소될 때 호출되는 완료 핸들러. 정상 완료 또는 취소시에는 null
        println("Finished")
    }
    delay(400) // main 코루틴을 400밀리초 동안 일시 중단
    job.cancelAndJoin()
}
// Finished
//sampleEnd
