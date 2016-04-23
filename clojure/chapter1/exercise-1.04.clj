;; ==============================================================================
;;
;; @@@@@@@@@@@@@@@@
;; @ Exercise 1.4 @
;; @@@@@@@@@@@@@@@@
;;
(ns sicp.ch01 (:use clojure.test))

;; this procedure should add the absolute value of b to a
(defn a-plus-abs-b
  [a b]
  ((if (> b 0) + -) a b))

(deftest test-a-plus-abs-b
  (is (= 9 (a-plus-abs-b 4,  5)))
  (is (= 9 (a-plus-abs-b 4, -5)))
  (is (= 4 (a-plus-abs-b 4,  0)))
  (is (= 4 (a-plus-abs-b 0,  4)))
  (is (= 4 (a-plus-abs-b 0, -4))))

(run-tests)
