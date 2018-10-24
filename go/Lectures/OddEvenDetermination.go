package main

func Determination(i int) bool {
	if i%2 == 0 {
		return true
	} else {
		return false
	}
}

func main() {
	for i := 1; i <= 100; i++ {
		print(i)
		if Determination(i) {
			println("-偶数")
		} else {
			println("-奇数")
		}
	}
}
