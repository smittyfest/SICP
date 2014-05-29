#lang scheme
(require (planet schematics/schemeunit:3:5))

(define (new-if predicate then-clause else-clause)
  (cond (predicate then-clause) (else else-clause)))

(new-if (= 2 3) 0 5)
(new-if (= 1 1) 0 5)

(define (square x) (* x x))
(define (abs x) (cond ((< x 0) (- x)) (else x)))
(define (average x y) (/ (+ x y) 2))
(define (improve guess x) (average guess (/ x guess)))
(define (good-enough? guess x) (< (abs (- (square guess) x)) 0.001))
(define (sqrt-iter guess x) (new-if (good-enough? guess x) guess (sqrt-iter (improve guess x) x)))
(define (sqrt x) (sqrt-iter 1.0 x))

;;
;; the if-expression is a special form in which the predicate is evaluated first,
;; followed by either the consequent (if the predicate evaluated to true) or the
;; alternative (if the predicate evaluated to false). The Scheme interpreter uses
;; applicative-order evaluation, so that both arguments to a procedure will always
;; be evaluated. This leads to infinite recursion since the else-clause is always evaluated.
;;
(sqrt 9)

