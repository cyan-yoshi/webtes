package main

import (
	"fmt"
)

func main() {
	//var variableName type
	//var vname1, vname2, vname3 int = 1, 2, 3
	var x = 3
	//a:=1
	//fmt.Println(a)
	//fmt.Println(vname1)
	//fmt.Println(vname2)
	//fmt.Println(vname3)

	fmt.Println("hello world")

	if x == 1 {
		println("x は 1")
	} else if x == 2 {
		println("x は 2")
	} else {
		println("x は 1 でも 2 でもない")
	}
	for i := 0; i <= 100; i++ {
		if i%2 == 1 {
			print(i)
			println("-奇数")
		} else if i%2 == 0 {
			print(i)
			println("-偶数")
		}
	}
}
