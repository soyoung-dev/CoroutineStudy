package f_207_exception_handling.s_9

import kotlinx.coroutines.*

// 10장 예외처리 122p
fun main(): Unit = runBlocking {// 비동기로 실행. 함수가 종료될 때까지 기다림.
  val handler =
      CoroutineExceptionHandler { ctx, exception -> // 코루틴 실행 중 발생하는 예외를 처리하는 핸들러.
          println("Caught $exception")
      }
  val scope = CoroutineScope(SupervisorJob() + handler)
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
// Caught java.lang.Error: Some error
// Will be printed
//sampleEnd
