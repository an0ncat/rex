package rex.base

import java.text.DecimalFormat

private val decimalFormat = DecimalFormat("#.##")

fun interface ExpressionObserver {
    fun onChanged(expression: Expression)
}

interface Expression {
    fun evaluate(): Double
    fun addObserver(observer: ExpressionObserver)
    fun removeObserver(observer: ExpressionObserver)
}

class ConstantExpression(private val value: Double) : Expression {
    override fun evaluate(): Double {
        return value
    }

    override fun toString(): String {
        return decimalFormat.format(value)
    }

    override fun addObserver(observer: ExpressionObserver) {
        // I don't want anyone to observe me because I won't change!
    }

    override fun removeObserver(observer: ExpressionObserver) {
        // Since I don't take observers, I don't want to do anything to release observers!
    }
}

class VariableExpression(
    private val name: String,
    private var value: Double = 0.0,
): Expression {
    private val observers = mutableListOf<ExpressionObserver>()
    override fun evaluate(): Double {
        return value
    }

    override fun toString(): String {
        return name
    }

    override fun addObserver(observer: ExpressionObserver) {
        observers.add(observer)
    }

    override fun removeObserver(observer: ExpressionObserver) {
        observers.remove(observer)
    }

    fun updateValue(newValue: Double) {
        value = newValue
        observers.forEach { it.onChanged(this) }
    }
}

abstract class BinaryOperator(lhs: Expression, rhs: Expression): Expression, ExpressionObserver {
    private val observers = mutableListOf<ExpressionObserver>()
    private var value = 0.0

    init {
        lhs.addObserver(this)
        rhs.addObserver(this)
    }
    override fun onChanged(expression: Expression) {
        val newValue = evaluate()
        if (value != newValue) {
            value = newValue
            observers.forEach { it.onChanged(this) }
        }
    }

    override fun addObserver(observer: ExpressionObserver) {
        value = evaluate()
        observers.add(observer)
    }

    override fun removeObserver(observer: ExpressionObserver) {
        observers.remove(observer)
    }

    abstract override fun evaluate(): Double
}