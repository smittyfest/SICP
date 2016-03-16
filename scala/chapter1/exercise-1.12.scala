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
package sicp

def pascal(col: Int, row: Int): Int = {
  if (col < 0 || row < 0) 0
  else if (col == 0 || col == row) 1
  else pascal(col-1,row-1) + pascal(col,row-1)
}
