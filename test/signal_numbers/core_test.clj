(ns signal-numbers.core-test
  (:require [clojure.test :refer :all]
            [signal-numbers.core :refer :all]))

(deftest number-to-english-word-converter
  (testing "should convert numbers to english words"
    (are [number words] (= words (int->english-words number))
            0 "zero"
           11 "eleven"
         1000 "one thousand")))


(deftest string-to-number
  (testing "should return numbers from string if possible, nil otherwise"
    (are [maybe-number number] (= number (string->number maybe-number))
         "0"  0
         "11" 11
         "1a" nil)))
