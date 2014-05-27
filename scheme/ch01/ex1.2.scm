#lang scheme
(require (planet schematics/schemeunit:3:5))

(define (f) (/ (+ 5 (+ 4 (- 2 (- 3 (+ 6 (/ 4 5)))))) (* 3 (* (- 6 2)(- 2 7)))))

(check-equal? (f) (- (/ 37 150)) "Should equal -37/150")
