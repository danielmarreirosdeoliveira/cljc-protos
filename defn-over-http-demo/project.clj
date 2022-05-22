(defproject fullstack "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.7.1"

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.773"]
                 [compojure/compojure "1.6.2"]
                 [ring/ring-json "0.5.1"]
                 [reagent "0.10.0" :exclusions [cljsjs/react cljsjs/react-dom cljsjs/react-dom-server]]
                 [reagent-utils "0.3.3"]
                 [clj-http "3.12.1"]
                 [secretary "1.2.3"]
                 [venantius/accountant "0.2.5"]
                 [buddy/buddy-auth "2.2.0"]
                 [ring/ring-jetty-adapter "1.8.2"]
                 [derekchiang/ring-proxy "1.0.1"]
                 [net.eighttrigrams/defn-over-http "0.1.8"]]

  :plugins [[lein-ring "0.12.5"]]

  :ring {:handler fullstack.api/app
         :nrepl {:start? true
                 :port   7000}}

  :source-paths ["src/clj" "src/cljs"]
  
  :aliases {"fig"       ["trampoline" "run" "-m" "figwheel.main"]
            "fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]}

  :profiles {:dev {:dependencies   [[com.bhauman/figwheel-main "0.2.12"]
                                    [com.bhauman/rebel-readline-cljs "0.1.4"]]
                   
                   :resource-paths ["target"]
                   :clean-targets  ^{:protect false} ["target" "resources/public/cljs-out"]}})