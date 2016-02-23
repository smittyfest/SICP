(ns sicp.ch01 (:use clojure.test))

(defn count-change
  {:doc "Returns the number of ways to count change for a given amount with a given set of coins"}
  [money, coins] 
  (cond 
    (or (empty? coins) (neg? money)) 0
    (zero? money) 1 
    :else (+ 
      (count-change money (rest coins))
      (count-change (- money (first coins)) coins)
    )
  )
)
(print (count-change 100 [1 5 10 25]))
;; unit-tests
