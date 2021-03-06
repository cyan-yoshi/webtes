package main

func add(x, y int) int {
	return x + y
}

func swap1(x, y int) (int, int) {
	return y, x
}

func swap2(x, y int) (x2, y2 int) {
	y2, x2 = x, y
	return
}

func main() {
	println(add(3, 56))

	var x = 3
	var y = 1
	x, y = swap1(x, y)
	println(x)

	var x1 = 123
	var y1 = 431
	x1, y1 = swap2(x1, y1)
	println(y1)
}
