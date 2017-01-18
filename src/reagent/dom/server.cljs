(ns reagent.dom.server
  (:require [reagent.impl.util :as util]
            [reagent.impl.template :as tmpl]
            [reagent.ratom :as ratom]
            [reagent.interop :refer-macros [$ $!]]))

(defonce ^:private imported nil)

(defn module []
  util/react)


(defn render-to-string
  "Turns a component into an HTML string."
  [component]
  (ratom/flush!)
  (binding [util/*non-reactive* true]
    ($ (module) renderToString (tmpl/as-element component))))

(defn render-to-static-markup
  "Turns a component into an HTML string, without data-react-id attributes, etc."
  [component]
  (ratom/flush!)
  (binding [util/*non-reactive* true]
    ($ (module) renderToStaticMarkup (tmpl/as-element component))))
