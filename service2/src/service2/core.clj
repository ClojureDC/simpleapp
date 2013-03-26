(ns service2.core
  (:require [ring.middleware.format-params :as params]
            [ring.middleware.format-response :as response]))

(defn add [params]
  (let [args (get params "args")]
    {:status 200
     :headers {}
     :body {:result (apply + args)}}))

(defn app
  "Handle a Ring request"
  [{:keys [uri params] :as request}]
  (if (= uri "/plus")
    (add params)
    {:status 404
     :headers {}
     :body (str "Unknown location: " uri)}))

(def handler
  (-> app
      (params/wrap-restful-params)
      (response/wrap-restful-response)))

