(defproject signal-numbers "1.0.0"
  :description "Lib converting number to english word"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/tools.cli "0.3.3"]]
  :main signal-numbers.core
  :plugins [[lein-bin "0.3.4"]]
  :profiles {:uberjar {:aot :all}}
  :bin { :name "signal-numbers" })
