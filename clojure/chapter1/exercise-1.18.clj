;;
;; Exercise 1.18
;;
;; Using the results of exercises 1.16 and 1.17, devise a procedure that generates
;; an iterative process for multiplying two integers in terms of adding, doubling,
;; and halving and uses a logarithmic number of steps.
;;
(ns sicp.ch01 (:use clojure.test))

(defn dv
  [a b]
  (Math/floor (/ a b)))
  
(defn mult
  [a b]
  (defn mult2
    [a b cnt accu]
    (cond
      (zero? a) accu
      (= (rem a 2) 1) (mult2 (dv a 2) b (+ accu (* (Math/pow 2 cnt) b)) (+ cnt 1))
      :else (mult2 (dv a 2) b accu (+ cnt 1)))
    (mult2 a b 0 0)))

(deftest test-mult
  (is (=  0 (mult 2 0)))
  (is (=  2 (mult 2 1)))
  (is (=  4 (mult 2 2)))
  (is (=  6 (mult 2 3)))
  (is (=  8 (mult 2 4)))
  (is (= 10 (mult 2 5)))
  (is (= 12 (mult 2 6)))
  (is (= 14 (mult 2 7))))
  (is (= 1560 (mult 120 13)))

(run-tests)
