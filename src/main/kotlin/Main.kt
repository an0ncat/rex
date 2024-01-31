package rex

import rex.base.*

fun main() {
    val a = "a" by 0
    val b = "b" by 0
    val lhs = (a + b).pow(2)
    val rhs = a.pow(2) + 2*a*b + b.pow(2)
    println("--- Initial state of expression trees $lhs and $rhs ---")
    println("Evaluate lhs: $lhs = ${lhs.evaluate()}")
    println("Evaluate rhs: $rhs = ${rhs.evaluate()}")
    println("For $a = ${a.evaluate()}, $b = ${b.evaluate()}")
    lhs.addObserver { println("Evaluate lhs: $lhs = ${lhs.evaluate()}") }
    rhs.addObserver { println("Evaluate rhs: $rhs = ${rhs.evaluate()}") }
    println("----- Update value of $a to 2.0 -----")
    a.updateValue(2.0)
    println("For $a = ${a.evaluate()}, $b = ${b.evaluate()}")
    println("----- Update value of $b to 3.0 -----")
    b.updateValue(3.0)
    println("For $a = ${a.evaluate()}, $b = ${b.evaluate()}")
}