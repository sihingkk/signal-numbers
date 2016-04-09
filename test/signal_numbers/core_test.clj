(ns signal-numbers.core-test
  (:require [clojure.test :refer :all]
            [signal-numbers.core :refer :all]))

(deftest string-to-number
  (testing "should return numbers from string if possible, nil otherwise"
    (are [maybe-number number] (= number (string->number maybe-number))
         "0"  0
         "11" 11
         "1a" 1
         "a"  nil)))

(deftest in-range-test
  (testing "an int should be in range between 0 and 1000"
    (are [number is-in-range] (= is-in-range (valid-range number))
         -1 false
         0 true
         nil false
         1 true
         123 true
         999 true
         1000 true
         1001 false)))
