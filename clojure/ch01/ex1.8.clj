;;
;; Exercise 1.8
;;
;; Newton's method for cube roots is based on the fact that if y is an approximation
;; to the cube root of x, then a better approximation is given by the value
;;
;; (x/y^2) + 2y
;; ============
;;      3
;;
;; Use this formula to implement a cube root procedure analogous to the square root
;; procedure.
;;
(ns sicp.ch01 (:use clojure.test))

(defn cube [x] (* x x x))

(defn abs [x] (cond (neg? x) (- x) :else x))

(defn improve [guess x] (/ (+ (/ x (* guess guess)) (* 2 guess)) 3))

(defn good-enough? [guess x] (< (abs (- (/ (cube guess) x) 1.0)) 0.0001))

(defn cube-root-iter [guess x] (if (good-enough? guess x) guess (cube-root-iter (improve guess x) x)))

(defn cube-root [x] (cube-root-iter 1.0 x))
