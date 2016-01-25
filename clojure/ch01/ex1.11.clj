;;
;; Exercise 1.11
;;
;; A function f is defined by the rule that f(n) = n if n < 3, and
;; f(n) = f(n-1) + 2*f(n-2) + 3*f(n-3) if n >= 3. Write a procedure
;; that computes f by means of a recursive process. Write a procedure
;; that computes f by means of an iterative process.
;;
(ns sicp.ch01 (:use clojure.test))

(defn fib3
  {:doc ""}
  [n]
  (if (< n 3) n (+ (fib3 (- n 1)) (fib3 (- n 2)) (fib3 (- n 3)))))

(deftest test-fib3
  (is (=  0 (fib3 0)))
  (is (=  1 (fib3 1)))
  (is (=  2 (fib3 2)))
  (is (=  3 (fib3 3)))
  (is (=  6 (fib3 4)))
  (is (= 11 (fib3 5)))
  (is (= 20 (fib3 6)))
  (is (= 37 (fib3 7))))


(defn fib3b
  {:doc ""}
  [n]
  (defn f [i a b c]
    (cond (< n 3) n
          (= i n) (+ a b c)
          :else (f (+ i 1) b c (+ a b c))))
  (f 3 0 1 2))

(deftest test-fib3b
  (is (=  0 (fib3b 0)))
  (is (=  1 (fib3b 1)))
  (is (=  2 (fib3b 2)))
  (is (=  3 (fib3b 3)))
  (is (=  6 (fib3b 4)))
  (is (= 11 (fib3b 5)))
  (is (= 20 (fib3b 6)))
  (is (= 37 (fib3b 7))))

(run-tests)
