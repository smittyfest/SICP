;;
;; Exercise-1.19
;;
;; There is a clever algorithm for computing the Fibonacci numbers in a logarithmic
;; number of steps. Recall the transformation of the state variables 'a' and 'b' in
;; the fib-iter process of section 1.2.2: (a <- a+b) and (b <- a). Call this transformation 'T',
;; and observe that applying 'T' over and over again 'n' times, starting with 1 and 0, produces
;; the pair Fib(n+1) and Fib(n).
;; In other words, the Fibonacci numbers are produced by applying T^n, the nth power of the
;; transformation T, starting with the pair (1,0). Now consider T to be the special case of p = 0 and
;; q = 1 in a family of transformations Tpq, where Tpq transforms the pair (a, b)
