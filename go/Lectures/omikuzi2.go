package main

import (
	"encoding/json"
	"fmt"
	"math/rand"
	"net/http"
	"time"
)

type Response struct {
	Result int `json:"result"`
}

func handler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-type", "application/json")
	enc := json.NewEncoder(w)
	n := rand.Intn(6) + 1
	resp := &Response{
		Result: n,
	}
	//fmt.Println(n)
	fmt.Println(r.FormValue("msg"))
	fmt.Println(r.FormValue("a"))
	fmt.Println(r.FormValue("b"))
	if err := enc.Encode(resp); err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
	}

}

func main() {
	rand.Seed(time.Now().UnixNano())
	http.HandleFunc("/", handler)
	http.ListenAndServe(":8080", nil)
}
