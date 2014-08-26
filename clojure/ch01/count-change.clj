(ns sicp.ch01 (:use clojure.test))

(defn count-change [money, coins] 
  (cond (or (empty? coins) (neg? money)) 0
  (zero? money) 1 
    :else (+ 
      (count-change money (rest coins))
      (count-change (- money (first coins)) coins)
    )
  )
)
(print (count-change 100 [1 5 10 25]))
(run-tests)  
