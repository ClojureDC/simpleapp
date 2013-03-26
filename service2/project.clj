(defproject service2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [ring-middleware-format "0.3.0"]]
  :plugins [[lein-ring "0.8.3"]]
  :ring {:handler service2.core/handler})
