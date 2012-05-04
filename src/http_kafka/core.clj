(ns http-kafka.core
  "The main thing.  Also the only thing."
  (:gen-class)
  (:use 
   clj-kafka.producer
   ring.adapter.jetty))

(defn make-handler [& {:keys [zk-url topic]
                       :or {zk-url "localhost:2181" topic "test-messages"}}]
  (fn [request]
    (let [start (System/currentTimeMillis)]
      (with-open [items (clojure.java.io/reader (:body request))
                  p (producer {"zk.connect" zk-url})]
        (send-messages 
         p topic
         (map (comp message (memfn getBytes)) (line-seq items)))))
    {:status 200
     :headers {"Content-Type" "text/plain"}
     :body "received"}))

(defn run [& {:keys [port] :or {port 9876}
              :as args}]
  (run-jetty
   (apply make-handler (mapcat identity args))
   {:port port}))

(defn parse-arg [x]
  (let [datum (read-string x)]
    (if (symbol? datum) (str datum) datum)))

(defn -main
  "I don't do a whole lot."
  [& args]
  (apply run (map #(if (.startsWith %1 "--")
                     (keyword (.substring %1 2))
                     (parse-arg %1))
                  args)))
