;; ==============================================================================
;;
;; @@@@@@@@@@@@@@@@
;; @ Exercise 1.1 @
;; @@@@@@@@@@@@@@@@
;;
Clojure 1.7.0
user=> 10
10
user=> (+ 5 3 4)
12
user=> (- 9 1)
8
user=> (/ 6 2)
3
user=> (+ (* 2 4) (- 4 6))
6
user=> (def a 3)
#'user/a
user=> (def b (+ a 1))
#'user/b
user=> (+ a b (* a b))
19
user=> (= a b)
false
user=> (if (and (> b a) (< b (* a b))) b a)
4
user=> (cond (= a 4) 6 (= b 4) (+ 6 7 a) :else 25)
16
user=> (+ 2 (if (> b a) b a))
6
user=> (* (cond (> a b) a (< a b) b :else -1) (+ a 1))
16
user=> Bye for now!
