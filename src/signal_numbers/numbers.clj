(ns signal-numbers.numbers)

(def base-values->words {0 "zero" 1 "one" 2 "two" 3 "three" 4 "four"
                         5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine"
                         10 "ten" 11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen"
                         15 "fifteen" 16 "sixteen" 17 "seventeen" 18 "eighteen" 19 "nineteen"
                         20 "twenty" 30 "thirty" 40 "forty" 50 "fifty"
                         60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety"})


(defn int->english-words [number]
  (condp > number
   20  (base-values->words number)
   100 (let [units (mod number 10)
             tens (- number units)]
         (str (base-values->words tens)
              (if (not= 0 units)
                (str "-" (base-values->words units)))))
   1000 (let [tens-with-units (mod number 100)
              hundreds  (quot number 100)]
          (str (base-values->words hundreds)
               " hundred"
               (if (not= 0 tens-with-units)
                 (str " " (int->english-words tens-with-units)))))
   1001 "one thousand"
   nil))
