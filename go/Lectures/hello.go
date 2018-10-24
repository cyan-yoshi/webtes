package main

import (
	"fmt"
)

func main() {
	//var variableName type
	var vname1, vname2, vname3 int = 1, 2, 3
	//a:=1
	//fmt.Println(a)
	fmt.Println(vname1)
	fmt.Println(vname2)
	fmt.Println(vname3)

	fmt.Println("hello world")

	var msg = "hello"
	msg += "world"
	println(msg)

	var a = 1
	a += 1

	switch a {
	case 1:
		fmt.Println("a is 1")
	default:
		fmt.Println(a)
		fmt.Println("default")
	}

	for i := 0; i <= 100; i += 10 {
		fmt.Println(i)
	}

	var i int

LOOP:
	for {
		switch {
		case i%2 == 1:
			fmt.Println(i)
			break LOOP
		}
		i++
	}
}
