;;
;; Exercise 1.8
;;
;; Newton's method for cube roots is based on the fact that if y is an approximation
;; to the cube root of x, then a better approximation is given by the value
;;
;; (x/y^2) + 2y
;; ============
;;      3
;;
;; Use this formula to implement a cube root procedure analogous to the square
;; root procedure.
#lang scheme
(require (planet schematics/schemeunit:3:5))

(define (cube x) (* x x x))

(define (abs x) (cond (neg? x) (- x) x))

(define (improve guess x) (/ (+ (/ x (* guess guess)) (* 2 guess)) 3))

(define (good-enough? guess x) (< (abs (- (/ (cube guess) x) 1.0)) 0.0001))

(define (cube-root-iter guess x) (if (good-enough? guess x) guess (cube-root-iter (improve guess x) x)))

(define (cube-root x) (cube-root-iter 1.0 x))
