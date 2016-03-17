(ns sicp.ch01 (:use clojure.test))

(defn p [] (p))

(defn overflow-test
  [x y]
  (if (zero? x) 0
    y))

;; On a standard Scheme interpreter, which uses applicative-order evaluation,
;; this will result in an infinite recursion, hanging the interpreter.
;; On the other hand, if the interpreter uses normal-order evaluation,
;; the procedure will return 0.
;;
(overflow-test 0 (p))
