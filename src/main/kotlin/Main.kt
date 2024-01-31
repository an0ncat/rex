package rex

import rex.base.*

fun main() {
    val a = variable("a", 0.0)
    val b = variable("b", 0.0)
    val lhs = pow(add(a, b), 2.0)
    val rhs = add(add(pow(a, 2.0), multiply(multiply(a, b), 2.0)), pow(b, 2.0))
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