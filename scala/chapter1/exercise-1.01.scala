Scala version 2.11.6
scala> 10
res0: Int = 10

scala> 5 + 3 + 4
res1: Int = 12

scala> 9 - 1
res2: Int = 8

scala> 6 / 2
res3: Int = 3

scala> (4 * 2) + (4 - 6)
res5: Int = 6

scala> val a = 3
a: Int = 3

scala> val b = a + 1
b: Int = 4

scala> a + b + (a * b)
res6: Int = 19

scala> a == b
res7: Boolean = false

scala> if ((b > a) && (b < (a * b))) b else a
res5: Int = 4

scala> if (a == 4) 6 else if (b == 4) (6 + 7 + a) else 25
res6: Int = 16
