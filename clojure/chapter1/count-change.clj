(ns sicp.ch01 (:use clojure.test))

(defn count-change
  {:doc "Compute the number of ways to make change for amount a from n types of coins"}
  [amount coins] 
  (cond 
    (zero? amount) 1
    (or (empty? coins) (neg? amount)) 0
    :else (+ 
      (count-change amount (rest coins))
      (count-change (- amount (first coins)) coins))))

;; unit-tests
(print (count-change 100 [1 5 10 25]))
(run-tests)  
