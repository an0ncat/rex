package rex.base

fun add(self: Expression, other: Expression): Expression = Addition(self, other)

fun add(self: Expression, other: Double): Expression = Addition(self, ConstantExpression(other))

fun subtract(self: Expression, other: Expression): Expression = Subtraction(self, other)

fun subtract(self: Expression, other: Double): Expression = Subtraction(self, ConstantExpression(other))

fun multiply(self: Expression, other: Expression): Expression = Multiplication(self, other)

fun multiply(self: Expression, other: Double): Expression = Multiplication(self, ConstantExpression(other))

fun divide(self: Expression, other: Expression): Expression = Division(self, other)

fun divide(self: Expression, other: Double): Expression = Division(self, ConstantExpression(other))

fun variable(name: String, value: Double = 0.0) = VariableExpression(name, value)

operator fun Expression.plus(other: Expression): Expression = Addition(this, other)

operator fun Expression.plus(other: Number): Expression = Addition(this, ConstantExpression(other.toDouble()))

operator fun Number.plus(other: Expression): Expression = Addition(ConstantExpression(toDouble()), other)

operator fun Expression.minus(other: Expression): Expression = Subtraction(this, other)

operator fun Expression.minus(other: Number): Expression = Subtraction(this, ConstantExpression(other.toDouble()))

operator fun Number.minus(other: Expression): Expression = Subtraction(ConstantExpression(toDouble()), other)

operator fun Expression.times(other: Expression): Expression = Multiplication(this, other)

operator fun Expression.times(other: Number): Expression = Multiplication(this, ConstantExpression(other.toDouble()))

operator fun Number.times(other: Expression): Expression = Multiplication(ConstantExpression(toDouble()), other)

operator fun Expression.div(other: Expression): Expression = Division(this, other)

operator fun Expression.div(other: Number): Expression = Division(this, ConstantExpression(other.toDouble()))

operator fun Number.div(other: Expression): Expression = Division(ConstantExpression(toDouble()), other)

fun Expression.pow(other: Expression): Expression = Power(this, other)

fun Expression.pow(other: Number): Expression = Power(this, ConstantExpression(other.toDouble()))

fun Number.pow(other: Expression): Expression = Power(ConstantExpression(toDouble()), other)

infix fun String.by(value: Number) = VariableExpression(this, value.toDouble())