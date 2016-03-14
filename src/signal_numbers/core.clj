(ns signal-numbers.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.string :as string])
  (:gen-class))

(def int->english-words (partial clojure.pprint/cl-format nil "~r"))

(defn string->number [str]
  (if-let [maybe-number (re-find #"\d+" str)]
    (Integer. maybe-number)))

(defn exit [status msg]
  (println msg)
  (System/exit status))

(defn usage [options-summary]
  (->> ["This is my program written for interview purpouses."
        ""
        "Usage: signal-number [options] number"
        ""
        "Options:"
        options-summary]
       (string/join \newline)))

(def cli-options [["-h" "--help" "Print this help" :default false]])

(defn error-msg [errors]
  (str "The following errors occurred while parsing your command:\n\n"
       (string/join \newline errors)))

(defn -main [& args]
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (cond
      (:help options) (exit 0 (usage summary))
      (not= (count arguments) 1) (exit 1 (usage summary))
      errors (exit 1 (error-msg errors)))

    (println (-> (first arguments)
                 string->number
                 int->english-words))))
