package f_207_exception_handling.s_7

import kotlinx.coroutines.*

// 10장 예외처리 120p
class MyException : Throwable()

suspend fun main() = supervisorScope {// 이 범위 안에서 발생하는 하위 코루틴의 예외는 상위 코루틴으로 전파되지 않음.
  val str1 = async<String> {// 비동기로 값을 반환하는 코루틴 생성 함수
      delay(1000)
      //"Text1"
      throw MyException()
  }

  val str2 = async {
      delay(2000)
      "Text2"
  }

  try {
      println(str1.await())
  } catch (e: MyException) {
      println(e)
  }

  println(str2.await())
}
// MyException
// Text2
//sampleEnd
