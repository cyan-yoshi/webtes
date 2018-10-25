package main

import (
	"fmt"
)

type Stringer interface {
	String() string
}

var s Stringer = Hex(100)

type Hex int

func (h Hex) String() string {
	return fmt.Sprintf("%x", int(h))
}

func main() {
	fmt.Println(s.String())
}
