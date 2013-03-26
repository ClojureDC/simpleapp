(ns service3.core
  (:require [ring.middleware.format-params :as params]
            [ring.middleware.format-response :as response]
            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [hiccup.core :as h]
            [hiccup.page :refer [html5]]))

(defn add [args]
  {:status 200
   :headers {}
   :body {:result (apply + args)}})

(defroutes app
  (GET "/" [] (html5 [:head [:title "Adder"]] [:body [:h1 "Adding App"]]))
  (POST "/plus" [args] (add args))
  (route/not-found (html5 [:head [:title "Adder"]] [:body [:h1 "Unknown location"]])))

(def handler
  (-> app
      (params/wrap-restful-params)
      (response/wrap-restful-response)))

