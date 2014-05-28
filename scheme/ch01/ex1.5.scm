#lang scheme
(require (planet schematics/schemeunit:3:5))

(define (p) (p))

(define (test x y) (if (= x 0) 0 y))

;;
;; On a standard Scheme interpreter, which uses applicative-order evaluation,
;; this will result in an infinite recursion, hanging the interpreter.
;; On the other hand, if the interpreter uses normal-order evaluation,
;; the procedure will return 0.
;;
(test 0 (p))
