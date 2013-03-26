(ns service1.core)

(defn handler
  "Handle a Ring request"
  [request]
  (pr "Received request: " request)
  (println)
  {:status 200
   :headers {}
   :body "<html><head><title>Response</title></head><body><p>Hello</p></body></html>"})
