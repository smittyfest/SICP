(ns sicp.ch01 (:use clojure.test))

(defn fast-expt
  [b n]
  (defn fast-iter
    [b counter accu]
    (cond
      (= counter 0) accu
      (even? counter) (fast-iter (square b) (/ counter 2) accu)
      :else (fast-iter b (- counter 1) (* accu b))))
    (fast-iter b n 1))

;; unit-tests
