package main

func main() {
	var a, b, c bool
	if a && b || !c {
		println("true")
	} else {
		println("false")
	}

	p := struct {
		name string
		age  int
	}{name: "Gopher", age: 10}

	p.age++
	println(p.name)
	println(p.age)

	var ns = [5]int{10, 20, 30, 40, 50}
	println(ns[4])
	println(len(ns))
	println(ns[1:3][1])

	var slice []int
	slice = make([]int, 3, 10)
	println(slice[2])
	println(len(slice))

	var slice1 = []int{10, 20, 30, 40, 50}
	println(len(slice1))
	println(slice1[2])
	slice1 = append(slice, 60)
	println(len(slice1))
	println(slice1[3])

}
