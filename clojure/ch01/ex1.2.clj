(ns sicp.ch01 (:use clojure.test))

(defn f [] (/ (+ 5 (+ 4 (- 2 (- 3 (+ 6 (/ 4 5)))))) (* 3 (* (- 6 2)(- 2 7)))))

(deftest test-f
  (is (= (- (/ 37 150)) (f))))

(run-tests)
