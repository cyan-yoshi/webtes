package main

import (
	"fmt"
)

func f() (int, error) {
	return 0, fmt.Errorf("my error")
}

func main() {
	if n, err := f(); err != nil {
		fmt.Println("Error", err)
	} else {
		fmt.Println(n)
	}
}
