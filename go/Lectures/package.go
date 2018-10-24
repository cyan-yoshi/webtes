package main

var msg string = "hello"

func f() {
	println(msg)
}

func main() {
	f()
	msg = "hi, gophers"
	f()
}
