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

	time := time.Now().UnixNano()
	rand.Seed(time)
	num := rand.Intn(6) + 1
	print("num: ")
	println(num)

	switch num {
	case 1:
		println("凶")
	case 2:
		println("吉")
	case 3:
		println("吉")
	case 4:
		println("中吉")
	case 5:
		println("中吉")
	case 6:
		println("大吉")
	}

}
