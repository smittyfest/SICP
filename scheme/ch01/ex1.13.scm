;;
;; Proof via Bill the Lizard
;;
From SICP section 1.2.2 Tree Recursion

Exercise 1.13 asks us to prove that Fib(n) is the closest integer to φn/√5, where

φ = (1 + √5)/2.

The exercise also gives us the following hint:
Let ψ = (1 - √5)/2. Use induction and the definition of Fibonacci numbers to prove that

Fib(n) = (φn - ψn) / √5

Some may recognize that this question is closely related to the closed form expression for Fibonacci numbers, also known as Binet's formula.

You may also recognize the quantity (1 + √5)/2, denoted by the Greek letter φ (phi), as the Golden ratio.

This mathematical constant has many interesting properties, a couple of which will be useful in our proof.
φ2 = φ + 1
1/φ + 1 = φ

The second constant introduced in the hint (1 - √5)/2, denoted by the Greek letter ψ (psi), shares the same properties.

ψ2 = ψ + 1
1/ψ + 1 = ψ


Before tackling the problem, let's take a look at the sequences in question to try and get a feel for what we're trying to prove. It's safe to assume that everyone is familiar with the Fibonacci sequence:

0, 1, 1, 2, 3, 5, 8, 13, 21, ...

Each number is the sum of the preceding two.

We can use the following procedures to quantify φn/√5 for several values of n.
(define phi
   (/ (+ 1 (sqrt 5)) 2))

(define (^ base exponent)
   (define (*^ exponent acc)
       (if (= exponent 0)
           acc
           (*^ (- exponent 1) (* acc base))))
   (*^ exponent 1))

(define (f n)
   (/ (^ phi n) (sqrt 5)))

The following output shows that this function does track closely with the Fibonacci sequence.
> (f 0)
0.4472135954999579
> (f 1)
0.7236067977499789
> (f 2)
1.1708203932499368
> (f 3)
1.8944271909999157
> (f 4)
3.0652475842498528
> (f 5)
4.959674775249769
> (f 6)
8.024922359499621
> (f 7)
12.984597134749391
> (f 8)
21.009519494249012

Each term is within 1/2 of the corresponding term of Fib(n), which is what we're asked to prove. This is only a small amount of empirical evidence, though, which is a far cry from proof. It does show that what we're asked to prove is at least reasonable, though. (It's always a good idea to show that an assertion is at least reasonable before you go about trying to prove it.)

The inductive proof

As the hint recommends, let's start by proving inductively that

Fib(n) = (φn - ψn) / √5

For the base cases we'll show that the left-hand side of the equation above is equal to the right-hand side for n = 0, n = 1, and n = 2.

On the Left-hand side we have:

Fib(0) = 0
Fib(1) = 1
Fib(2) = Fib(1) + Fib(0)
= 1 + 0
= 1

On the Right-hand side we have:

for n = 0
(φn - ψn) / √5 = (φ0 - ψ0) / √5
= (1 - 1) / √5
= 0 / √5
= 0

for n = 1
(φn - ψn) / √5 = (φ1 - ψ1) / √5
= ((1 + √5)/2) - ((1 - √5)/2) / √5
= (1/2 + √5/2) - (1/2 - √5/2) / √5
= (1/2 + √5/2 - 1/2 + √5/2) / √5
= (√5/2 + √5/2) / √5
= (2 * √5/2) / √5
= √5 / √5
= 1

for n = 2
(φn - ψn) / √5 = (φ2 - ψ2) / √5
= ((φ + 1) - (ψ + 1)) / √5
= (((1 + √5)/2 + 1) - ((1 - √5)/2 + 1)) / √5
= ((1 + √5)/2 + 1 - (1 - √5)/2 - 1) / √5
= ((1 + √5)/2 - (1 - √5)/2) / √5
= ((1 + √5) - (1 - √5)) / 2 / √5
= (1 + √5 - 1 + √5) / 2 / √5
= (√5 + √5) / 2 / √5
= (2 * √5) / 2 / √5
= √5 / √5
= 1

So far, so good. Now for the inductive step. If we assume that both of the following are true:

Fib(n) = (φn - ψn) / √5
Fib(n-1) = (φn-1 - ψn-1) / √5

does it follow that

Fib(n+1) = (φn+1 - ψn+1) / √5

is true also? Let's find out!

We'll start from the defining recurrence relation of the Fibonacci sequence and see if the two assumptions above can lead us to the correct conclusion. Remember that we also have the properties of φ and ψ that were introduced at the beginning at our disposal.

Fib(n+1) = Fib(n) + Fib(n-1)
= (φn - ψn) / √5 + (φn-1 - ψn-1) / √5
= ((φn - ψn) + (φn-1 - ψn-1)) / √5
= (φn - ψn + φn-1 - ψn-1) / √5
= (φn + φn-1 - ψn - ψn-1) / √5
= ((φn + φn-1) - (ψn + ψn-1)) / √5
= (φn+1 * (φ-1 + φ-2) - ψn+1 * (ψ-1 + ψ-2)) / √5
= (φn+1 * φ-1 * (1 + φ-1) - ψn+1 * ψ-1 * (1 + ψ-1)) / √5
= (φn+1 * 1/φ * (1 + 1/φ) - ψn+1 * 1/ψ * (1 + 1/ψ)) / √5
= (φn+1 * 1/φ * (φ) - ψn+1 * 1/ψ * (ψ)) / √5
= (φn+1 - ψn+1) / √5

In the 10th step of the transformation above I used the following properties of φ and ψ to do substitutions:

1/φ + 1 = φ
1/ψ + 1 = ψ

This concludes the inductive proof from the hint, but where does that leave us? How does that help us prove that Fib(n) is the closest integer to φn/√5?

One proof leads to another

Let's rearrange the equation just a bit before continuing on.

Fib(n) = (φn - ψn) / √5
Fib(n) = φn/√5 - ψn/√5
Fib(n) - φn/√5 = ψn/√5

I did this bit of manipulation because we're trying to prove something about the relationship between Fib(n) and φn/√5. Specifically, we're trying to prove that the difference between them is always less than 1/2. In its current form, all that we have left to prove is that

ψn/√5 ≤ 1/2
or
ψn ≤ √5/2

Since ψ is defined to be (1 - √5)/2, we can simply evaluate it to find that

ψ = -0.618304...

Since the n in Fib(n) is always going to be an integer and

n ≥ 0

will always be true, and
ψ < 1

we know that
ψn ≤ 1

for all non-negative integer values of n.

We can also simply evaluate √5/2.

√5/2 = 1.118...

Since
ψn ≤ 1
and
√5/2 > 1

it's pretty clear that

ψn ≤ √5/2

and therefore

Fib(n) is the closest integer to φn/√5.

QED
