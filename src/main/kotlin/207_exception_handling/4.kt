package f_207_exception_handling.s_4

import kotlinx.coroutines.*

// 10장 예외처리 117p
fun main(): Unit = runBlocking {
    // 이렇게 하지 마세요. 자식 코루틴이 하나가 있고
    // 부모 코루틴이 없는 잡은 일반 잡과 동일하게 작동합니다.
    launch(SupervisorJob()) { // 1
        launch {
            delay(1000)
            throw Error("Some error")
        }

        launch {
            delay(2000)
            println("Will not be printed")
        }
    }

    delay(3000)
}
// Exception...
//sampleEnd
