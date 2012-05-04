# http-kafka

I forward your http requests to some sort of kafka cluster.

## Usage

"lein uberjar" me, and then run "java -jar <uberjar-file> <options>...",
where options are one of

* --zk-url <zookeeper connection string>
* --port <port to listen on>
* --topic <kafka topic to produce for>

## License

Copyright © 2012 Identified.com

Distributed under the Eclipse Public License, the same as Clojure.
