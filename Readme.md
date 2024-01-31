# rex - Reactive expression trees

This is a fun project in Kotlin to create math expression trees. The expression tree is observable, if any variable changes
the tree is re-evaluated and updated results will be published to the observers.

Here I am building the famous mathematical equation:
```
(a+b)^2 = a^2 + 2*a*b + b^2
```
Now the LHS expression tree becomes:
```kotlin
val lhs = (a + b).pow(2)
```
and RHS becomes:
```kotlin
val rhs = a.pow(2) + 2*a*b + b.pow(2)
```
Every expression node implements the `toString()` method, so you can directly print the expression.
If you print the expressions, you will see:
```kotlin
println("$lhs")
// ((a + b)) ^ 2
println("$rhs")
// (((a) ^ 2 + ((2 * a) * b)) + (b) ^ 2)
```
If you want to get the result, you can use the `evaluate()` function:
```kotlin
println("Evaluate lhs: $lhs = ${lhs.evaluate()}")
// Evaluate lhs: ((a + b)) ^ 2 = 0.0
```
You can register observers for the expression, so that you can immediately get the result when any of the expression
node changes.:

```kotlin
lhs.addObserver { println("Evaluate lhs: $lhs = ${lhs.evaluate()}") }
```
Now we update the values of variable `a` and `b`, the expression will be re-revaluated and notify
the observers with new value.

Have a look on [Main.kt](src/main/kotlin/Main.kt) and run it, you can see the output like this:
```
--- Initial state of expression trees ((a + b)) ^ 2 and (((a) ^ 2 + ((2 * a) * b)) + (b) ^ 2) ---
Evaluate lhs: ((a + b)) ^ 2 = 0.0
Evaluate rhs: (((a) ^ 2 + ((2 * a) * b)) + (b) ^ 2) = 0.0
For a = 0.0, b = 0.0
----- Update value of a to 2.0 -----
Evaluate lhs: ((a + b)) ^ 2 = 4.0
Evaluate rhs: (((a) ^ 2 + ((2 * a) * b)) + (b) ^ 2) = 4.0
For a = 2.0, b = 0.0
----- Update value of b to 3.0 -----
Evaluate lhs: ((a + b)) ^ 2 = 25.0
Evaluate rhs: (((a) ^ 2 + ((2 * a) * b)) + (b) ^ 2) = 25.0
For a = 2.0, b = 3.0
```