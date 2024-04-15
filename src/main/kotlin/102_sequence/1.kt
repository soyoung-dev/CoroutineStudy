package `102_1`

/*val `102`.sequence.getSeq = sequence {
    yield(1)
    yield(2)
    yield(3)
}*/

val seq = sequence {
    println("Generating first")
    yield(1)
    println("Generating second")
    yield(2)
    println("Generating third")
    yield(3)
    println("Done")
}

fun main() {
    for (num in seq) {
        println("The next number is $num")
    }
}