#lang scheme
(require (planet schematics/schemeunit:3:5))

(define (a-plus-abs-b a b)
  ((if (> b 0) + -) a b))

;; should add the absolute value of b to a
(check-equal? (a-plus-abs-b 4  5) 9)
(check-equal? (a-plus-abs-b 4 -5) 9)
(check-equal? (a-plus-abs-b 4  0) 4)
(check-equal? (a-plus-abs-b 0  4) 4)
(check-equal? (a-plus-abs-b 0 -4) 4)
