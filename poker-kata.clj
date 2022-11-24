;; https://codingdojo.org/kata/PokerHands/
(ns poker
  (:require [clojure.string :as str]))

(def suits ["C" "H" "D" "S"])
(def values ["2" "3" "4" "5" "6" "7" "8" "9" "T" "J" "Q" "K" "A"])

;; we are expecting cards to be a map with a key for the suit and the value will be the value

;; created a custom function to get values so we can be sure we're dealing with vectors and not
;; some other kind of sequence

(defn make-cards-from-string
  "takes a string of cards and makes it into lists (2H -> )"
  [cards]
  (mapv #(hash-map
          (get (str/split % #"") 0)
          (get (str/split % #"") 1))
     cards))

(defn get-values
  "get values from a map of cards"
  [cards]
  (mapv val cards))

(defn get-suits
  [cards]
  (mapv suit cards))

(defn dups
  [seq]
  (for [[id freq] (frequencies seq)  ;; get the frequencies, destructure
        :when (> freq 1)]            ;; this is the filter condition
    id))

(defn pair?
   "2 of the 5 cards have the same value"
  [cards]
  (= 2 (dups (get-values cards))))

(defn two-pair?
  "two pairs of cards share the same value"
  ;;TODO: test what this function is returning when there are two pairs
  [cards]
  (vec (dups cards)))

(defn three-of-a-kind? 
  "checking if there are three cards with the same value"
  [cards]
  (= 3 (dups cards)))

(defn straight?
  "checking if all the values of the cards are consecutive (e.g. 2 3 4 5 6)"
  [cards]
  (let [vals (get-values cards)]
    (= 4 (- (last vals) (first vals)))))

(defn flush? [])
"A flush is a hand that contains five cards all of the same suitinnon-sequential rank"
(and ())
(defn full-house? [])

(defn four-of-a-kind? [])

(defn straight-flush? [])
