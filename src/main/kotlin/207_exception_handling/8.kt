package f_207_exception_handling.s_8

import kotlinx.coroutines.*

// 10장 예외처리 121p
object MyNonPropagatingException : CancellationException() // 상위 코루틴으로 전파되지 않는 특수한 취소 예외 클래스

suspend fun main(): Unit = coroutineScope {
  launch { // 1
      launch { // 2
          delay(2000)
          println("Will not be printed")
      }
      throw MyNonPropagatingException // 3
  }
  launch { // 4
      delay(2000)
      println("Will be printed")
  }
}
// (2초 후)
// Will be printed
