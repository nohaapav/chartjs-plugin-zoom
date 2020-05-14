# cljsjs/chartjs-plugin-zoom

Clojure package for Zoom and pan plugin for Chart.js

https://github.com/chartjs/chartjs-plugin-zoom

## Setup

To use cljsjs package from local project repo do following:

1. In `project.clj` setup local repository
```
:repositories {"local" "file:repo"}
```

2. Build package
```
boot package install target
```

3. Deploy `.jar` archive to local project repo e.g.
```
mvn deploy:deploy-file -Dfile=chartjs-plugin-zoom-0.7.7-0.jar -DartifactId=chartjs-plugin-zoom -Dversion=0.7.7-0 -DgroupId=cljsjs -Dpackaging=jar -Durl=file:repo
```

4. Finally add dependency to your maven repository
```
lein deps
```

## Usage

[](dependency)
```clojure
[cljsjs/chartjs-plugin-zoom "0.7.7-0"]
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require ["cljsjs/chartjs-plugin-zoom"]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

