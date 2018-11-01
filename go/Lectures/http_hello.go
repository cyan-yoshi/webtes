package main

import (
	"fmt"
	"math/rand"
	"net/http"
	"time"
)

func handler(w http.ResponseWriter, r *http.Request) {
	t := time.Now().UnixNano()
	rand.Seed(t)
	time := time.Now().UnixNano()
	rand.Seed(time)
	num := rand.Intn(6) + 1

	fmt.Fprint(w, "今日の運勢は ")
	switch num {
	case 1:
		fmt.Fprint(w, "凶")
	case 2:
		fmt.Fprint(w, "吉")
	case 3:
		fmt.Fprint(w, "吉")
	case 4:
		fmt.Fprint(w, "中吉")
	case 5:
		fmt.Fprint(w, "中吉")
	case 6:
		fmt.Fprint(w, "大吉")
	}
}

func main() {
	http.HandleFunc("/", handler)
	http.ListenAndServe(":8080", nil)
}
