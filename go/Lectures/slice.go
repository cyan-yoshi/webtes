package main

func main() {
	n1 := 19
	n2 := 86
	n3 := 1
	n4 := 12
	sum := n1 + n2 + n3 + n4
	print("sum: ")
	println(sum)

	var slice = []int{19, 86, 1, 12}
	var result int
	for i := 0; i < 4; i++ {
		result += slice[i]
	}
	print("result: ")
	println(result)
}
