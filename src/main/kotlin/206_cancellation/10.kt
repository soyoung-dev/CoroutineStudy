package f_206_cancellation.s_10

import kotlinx.coroutines.*
import kotlin.random.Random

// 9장 취소 105p
suspend fun main(): Unit = coroutineScope {
    val job = launch {
        delay(Random.nextLong(2400))
        println("Finished")
    }
    delay(800)
    job.invokeOnCompletion { exception: Throwable? ->
        println("Will always be printed")
        println("The exception was: $exception")
    }
    delay(800)
    job.cancelAndJoin()
}
// Will always be printed
// The exception was:
// kotlinx.coroutines.JobCancellationException
// (또는)
// Finished
// Will always be printed
// The exception was null
//sampleEnd
