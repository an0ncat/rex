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

fun pow(self: Expression, other: Expression): Expression = Power(self, other)

fun pow(self: Expression, other: Double): Expression = Power(self, ConstantExpression(other))