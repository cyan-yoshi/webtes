package main

import (
	"fmt"
)

func main() {

	for i := 1; i <= 100; i++ {
		switch {
		case i%2 == 1:
			fmt.Print(i)
			fmt.Println("-奇数")
		case i%2 == 0:
			fmt.Print(i)
			fmt.Println("-偶数")
		}
	}
}
