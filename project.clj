(defproject clojurewerkz/balagan "1.0.7-SNAPSHOT"
  :description "A tiny library for data structure transformation and querying"
  :url "http://github.com/clojurewerkz/balagan"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.11.0"]]
  :jar-exclusions [#"\.cljc|\.swp|\.swo|\.DS_Store"]
  :source-paths ["src/cljc" "target/classes"]
  :profiles {:master {:dependencies [[org.clojure/clojure "1.11.0"]]}
             :dev {:dependencies [[org.clojure/clojurescript "1.11.4"]]
                   :plugins [[codox "0.8.10"]]
                   :codox {:sources ["src/cljc"]
                           :output-dir "doc/api"}}}
  :aliases  {"all" ["with-profile" "+dev:+master"]}
  :prep-tasks ["javac" "compile"]
  :repositories {"sonatype" {:url "https://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots"
                                       :snapshots true
                                       :releases {:checksum :fail :update :always}}}
  :test-paths ["test/cljc"]
  :auto-clean false)
