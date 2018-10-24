package main

import (
	"io"
)

func main() {

	//var m map[string]int
	var m = make(map[string]int)
	m = map[string]int{"x": 10, "y": 20}
	print("m[x]: ")
	println(m["x"])

	m["z"] = 30
	print("m[z]: ")
	println(m["z"])
	if n, ok := m["z"]; ok {
		print("(for 文の中)m[z]: ")
		println(n)
	}

	delete(m, "z")
	print("delete 後のm[z]: ")
	println(m["z"])

	if n, ok := m["z"]; ok {
		print("(for 文の中)m[z]: ")
		println(n)
	}

	type Int int
	type MyWriter io.Writer
	type Person struct {
		Name string
	}

}
