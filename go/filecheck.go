package main

import (
	"fmt"
	"io/ioutil"
)

func main() {
	files, _ := ioutil.ReadDir("./Raspberry/")
	fmt.Println(len(files))
	for _, f := range files {
		fmt.Println(f.Name())
	}

	files2, _ := ioutil.ReadDir("./Raspberry2/")
	fmt.Println(len(files2))
	for _, f := range files2 {
		fmt.Println(f.Name())
	}

	if len(files2) > 0 {
		fmt.Println("true")
	} else {
		fmt.Println("false")
	}
}
