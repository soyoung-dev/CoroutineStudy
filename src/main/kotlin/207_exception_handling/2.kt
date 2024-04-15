package f_207_exception_handling.s_2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 10장 예외처리 115p
fun main(): Unit = runBlocking {
    // try-catch 구문으로 래핑하지 마세요. 무시됩니다.
    // 코루틴 간의 상호작용은 job 을 통해서 이루어짐.
    try {
        launch {
            delay(1000)
            throw Error("Some error")
        }
    } catch (e: Throwable) { // 여기선 아무 도움이 되지 않습니다.
        println("Will not be printed~~~~")
    }

    launch {
        delay(2000)
        println("Will not be printed")
    }
}
// Exception in thread "main" java.lang.Error: Some error...
//sampleEnd
