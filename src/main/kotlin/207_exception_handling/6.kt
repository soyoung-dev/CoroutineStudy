package f_207_exception_handling.s_6

import kotlinx.coroutines.*

// 10장 예외처리 118p
fun main(): Unit = runBlocking {
  supervisorScope {// supervisorScope 로 코루틴 빌더 래핑.
      // 하위 코루틴에서 발생하는 예외가 상위 코루틴으로 전파되지 않도록 하는 범위 생성.
      launch {
          delay(1000)
          throw Error("Some error")
      }

      launch {
          delay(2000)
          println("Will be printed")
      }
  }
  delay(1000)
  println("Done")
}
// Exception...
// Will be printed
// (1초 후)
// Done
//sampleEnd
