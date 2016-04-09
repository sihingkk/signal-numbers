(ns signal-numbers.numbers-test
  (:require [clojure.test :refer :all]
            [signal-numbers.numbers :refer :all]))

(deftest number-to-english-word-converter
  (testing "should convert numbers to english words from 0 to 1000"
    (are [number words] (= words (int->english-words number))
            0 "zero"
           11 "eleven"
           20 "twenty"
           21 "twenty-one"
           32 "thirty-two"
          100 "one hundred"
          111 "one hundred eleven"
          143 "one hundred forty-three"
         1000 "one thousand"
         1001 nil)))
