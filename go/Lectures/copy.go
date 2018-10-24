package main

func f(xp *int) {
	*xp = 100
}

func main() {
	p := struct {
		age  int
		name string
	}{age: 10, name: "Gopher"}

	p2 := p
	p2.age = 20

	print("p: ")
	println(p.age, p.name)
	print("p2: ")
	println(p2.age, p2.name)

	var x int
	f(&x)
	println(x)

	ns := []int{10, 20, 30}
	ns2 := ns
	ns[1] = 200
	println(ns[0], ns[1], ns[2])
	println(ns2[0], ns2[1], ns2[2])
}
