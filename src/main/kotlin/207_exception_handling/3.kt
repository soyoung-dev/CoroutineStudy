package f_207_exception_handling.s_3

import kotlinx.coroutines.*

// 10장 예외처리 116p
fun main(): Unit = runBlocking {
  val scope = CoroutineScope(SupervisorJob()) // 자식에게 발생한 예외를 무시함
    // 다수의 코루틴을 시작하는 스코프
  scope.launch {
      delay(1000)
      throw Error("Some error")
  }

  scope.launch {
      delay(2000)
      println("Will be printed")
  }

  delay(3000)
}
// Exception...
// Will be printed
//sampleEnd
