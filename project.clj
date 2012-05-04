(defproject http-kafka "0.1.0-SNAPSHOT"
  :description "Simple HTTP front-end for kafka for bits of code that aren't capable of speaking kafka."
  :url "http://www.identified.com/"
  :aot [http-kafka.core]
  :main http-kafka.core
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [ring "1.1.0"]
                 [clj-kafka "0.0.2-0.7-SNAPSHOT"]])
