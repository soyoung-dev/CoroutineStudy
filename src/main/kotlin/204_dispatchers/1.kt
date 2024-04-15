package f_204_dispatchers.s_1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

// 12장 메인 디스패처 146p
suspend fun main() = coroutineScope {
    repeat(1000) {
        launch { // 또는 launch(Dispatchers.Default) {
            // 바쁘게 만들기 위해 실행합니다.
            List(1_000_000) { Random.nextLong() }.maxOrNull()

            val threadName = Thread.currentThread().name
            println("Running on thread: $threadName")
        }
    }
}
//sampleEnd
