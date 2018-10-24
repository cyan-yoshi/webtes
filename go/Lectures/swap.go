package main

func swap(x, y int) (int, int) {
	return y, x
}

func swap2(x, y *int) (*int, *int) {
	var swap1 = *x
	*x = *y
	*y = swap1
	return y, x
}

func main() {
	n, m := swap(10, 20)
	println(n, m)

	n2, m2 := 30, 40
	swap2(&n2, &m2)
	println(n2, m2)
}
