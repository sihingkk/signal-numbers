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
