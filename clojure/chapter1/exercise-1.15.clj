;;
;; Exercise 1.15
;;
(ns sicp.ch01 (:use clojure.test))

(defn cube
  [x]
  (* x x x))

(def num-iterations (atom 0))

(defn p
  [x]
