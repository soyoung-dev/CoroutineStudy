package f_207_exception_handling.s_5

import kotlinx.coroutines.*

// 10장 예외처리 118p
fun main(): Unit = runBlocking {
  val job = SupervisorJob() // 다수의 코루틴에서 다수의 job 을 컨텍스트로 사용
  launch(job) {
      delay(1000)
      throw Error("Some error")
  }
  launch(job) {
      delay(2000)
      println("Will be printed")
  }
  job.join()
}
// (1초 후)
// Exception...
// (1초 후)
// Will be printed
//sampleEnd
