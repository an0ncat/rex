package rex.base

import kotlin.math.pow

class Addition(
    private val lhs: Expression,
    private val rhs: Expression,
): BinaryOperator(lhs, rhs) {

    override fun evaluate(): Double {
        return lhs.evaluate() + rhs.evaluate()
    }

    override fun toString(): String {
        return "(${lhs} + ${rhs})"
    }
}

class Subtraction(
    private val lhs: Expression,
    private val rhs: Expression
): BinaryOperator(lhs, rhs) {

    override fun evaluate(): Double {
        return lhs.evaluate() - rhs.evaluate()
    }

    override fun toString(): String {
        return "(${lhs} - ${rhs})"
    }
}

class Multiplication(
    private val lhs: Expression,
    private val rhs: Expression
): BinaryOperator(lhs, rhs) {

    override fun evaluate(): Double {
        return lhs.evaluate() * rhs.evaluate()
    }

    override fun toString(): String {
        return "(${lhs} * ${rhs})"
    }
}

class Division(
    private val lhs: Expression,
    private val rhs: Expression
): BinaryOperator(lhs, rhs) {

    override fun evaluate(): Double {
        return lhs.evaluate() / rhs.evaluate()
    }

    override fun toString(): String {
        return "(${lhs} / ${rhs})"
    }
}

class Power(
    private val lhs: Expression,
    private val rhs: Expression
): BinaryOperator(lhs, rhs) {

    override fun evaluate(): Double {
        return lhs.evaluate().pow(rhs.evaluate())
    }

    override fun toString(): String {
        return "(${lhs}) ^ $rhs"
    }
}