(defproject clojurewerkz/balagan "1.0.6-SNAPSHOT"
  :description "A tiny library for data structure transformation and querying"
  :url "http://github.com/clojurewerkz/balagan"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :jar-exclusions [#"\.cljc|\.swp|\.swo|\.DS_Store"]
  :source-paths ["src/cljc" "target/classes"]
  :profiles {:master {:dependencies [[org.clojure/clojure "1.8.0-master-SNAPSHOT"]]}
             :dev {:dependencies [[org.clojure/clojurescript "0.0-2138"]]
                   :plugins [[codox "0.8.10"]
                             [lein-cljsbuild "1.0.2"]
                             [com.cemerick/clojurescript.test "0.2.1"]]
                   :cljsbuild {:test-commands {"phantom" ["phantomjs" :runner "target/testable.js"]}
                               :builds [{:source-paths ["target/classes" "target/test-classes"]
                                         :compiler {:output-to "target/testable.js"
                                                    :libs [""]
                                                    :source-map "target/testable.js.map"
                                                    :optimizations :advanced}}]}
                   :codox {:sources ["src/cljc"]
                           :output-dir "doc/api"}}}
  :aliases  {"all" ["with-profile" "+dev:+master"]}
  :prep-tasks [["cljc" "once"] "javac" "compile"]
  :repositories {"sonatype" {:url "https://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots"
                                       :snapshots true
                                       :releases {:checksum :fail :update :always}}}
  :test-paths ["target/test-classes"]
  :auto-clean false)
