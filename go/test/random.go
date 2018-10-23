package main

import (
	//"fmt"
	"math/rand"
	"time"
)

func main() {
	t := time.Now().UnixNano()
	rand.Seed(t)
	s := rand.Intn(10)
	println(s)
}
