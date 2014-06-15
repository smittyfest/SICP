;;
;; Exercise 1.12
;;
;; The following pattern of numbers is called Pascal's triangle.
;;
;;     1
;;    1 1
;;   1 2 1
;;  1 3 3 1
;; 1 4 6 4 1 
;;
;; The numbers at the edge of the triangle are all 1, and each number 
;; inside the triangle is the sum of the two numbers above it. Write
;; a procedure that computes elements of Pascal's triangle by means
;; of a recursive procedure.
;;

;;
;; We will structure the procedure to take the "row" and "col" of the 
;; entry in Pascal's triangle that we wish to compute. The procedure will
;; return the numerical value associated with this entry.
;;
;; Clearly, if (= col 1), the associated value is 1.
;;
;; Similarly, if (= col row), the associated value is 1.
;;
;; If the entry is anything else, we recursively calculate its value by 
;; adding the two values above it.
;;
;; One shortcoming of this procedure is that it does not perform any 
;; error checking. Entering "negative" values, or values cooresponding 
;; to cells "outside" the triangle, will lead to unpredictable results.
;;
#lang scheme
(require (planet schematics/schemeunit:3:5))

(define (pascal row col)
  (cond ((= col 1) 1)
        ((= col row) 1)
	(else
	 (+ (pascal (- row 1) (- col 1))
	    (pascal (- row 1) col)))))

(check-equal? (pascal 1 1) 1)
(check-equal? (pascal 2 1) 1)
(check-equal? (pascal 2 2) 1)
(check-equal? (pascal 3 1) 1)
(check-equal? (pascal 3 2) 2)
(check-equal? (pascal 3 3) 1)
(check-equal? (pascal 4 1) 1)
(check-equal? (pascal 4 2) 3)
(check-equal? (pascal 4 3) 3)
(check-equal? (pascal 4 4) 1)
(check-equal? (pascal 5 1) 1)
(check-equal? (pascal 5 2) 4)
(check-equal? (pascal 5 3) 6)
(check-equal? (pascal 5 4) 4)
(check-equal? (pascal 5 5) 1)
