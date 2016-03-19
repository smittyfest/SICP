;;
;; Exercise-1.19
;;
;; There is a clever algorithm for computing the Fibonacci numbers in a logarithmic
;; number of steps. Recall the transformation of the state variables 'a' and 'b' in
;; the fib-iter process of section 1.2.2: (a <- a+b) and (b <- a). Call this transformation 'T',
;; and observe that applying 'T' over and over again 'n' times, starting with 1 and 0, produces
;; the pair Fib(n+1) and Fib(n).
