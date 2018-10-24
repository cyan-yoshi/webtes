package main

import (
	"fmt"
)

type Hex int
type T int

func (h Hex) String() string {
	return fmt.Sprintf("%x", int(h))
}

func (t *T) f() {
	println("hi")
}

func main() {
	var hex Hex = 100
	fmt.Println(hex.String())

	var v T
	(&v).f()
	v.f()
}
