(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/chartjs-plugin-zoom
       :version     +version+
       :description "A zoom and pan plugin for Chart.js"
       :url         "https://github.com/chartjs/chartjs-plugin-zoom"
       :scm         {:url "https://github.com/nohaapav/chartjs-plugin-zoom"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn cdn-ver [file]
  (str "https://github.com/chartjs/chartjs-plugin-zoom/releases/download/v"
       +lib-version+ "/" file))

(deftask package []
  (comp
    (download :url (cdn-ver "chartjs-plugin-zoom.js"))
    (download :url (cdn-ver "chartjs-plugin-zoom.min.js"))
    (sift :move
          {#"chartjs-plugin-zoom.js" "cljsjs/chartjs/development/chartjs-plugin-zoom.inc.js"
           #"chartjs-plugin-zoom.min.js" "cljsjs/chartjs/production/chartjs-plugin-zoom.min.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.chartjs-plugin-zoom")
    (pom)
    (jar)
    (validate-checksums)))
