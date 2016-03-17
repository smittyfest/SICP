(ns sicp.ch01 (:use clojure.test))

(defn square [n] (* n n))
(defn sum-of-squares [a b] (+ (square a) (square b)))

(defn f 
  {:doc "Take three arguments, and return the sum of the squares of the two largest"}
  [a b c]
  (def smallest (min a b c))
    (cond
      (= a smallest) (sum-of-squares b c)
      (= b smallest) (sum-of-squares a c)
      (= c smallest) (sum-of-squares a b)
      :else -1))

;; alternative implementation
(defn ff
  [a b c]
  (if (> a b)
    (+ (* a a) (if (> b c) (* b b) (* c c)))
    (+ (* b b) (if (> a c) (* a a) (* c c)))))

(deftest test-f
  (is (= 2 (f 1 1 1)))
  (is (= 5 (f 2 1 1)))
  (is (= 5 (f 1 2 1)))
  (is (= 5 (f 1 1 2)))
  (is (= 13 (f 1 2 3)))
  (is (= 13 (f 1 3 2)))
  (is (= 13 (f 3 1 2)))
  (is (= 25 (f 4 2 3))))

(deftest test-ff
  (is (= 2 (ff 1 1 1)))
  (is (= 5 (ff 2 1 1)))
  (is (= 5 (ff 1 2 1)))
  (is (= 5 (ff 1 1 2)))
  (is (= 13 (ff 1 2 3)))
  (is (= 13 (ff 1 3 2)))
  (is (= 13 (ff 3 1 2)))
  (is (= 25 (ff 4 2 3))))

(run-tests)  
