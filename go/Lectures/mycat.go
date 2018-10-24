package main

import (
	"bufio"
	"flag"
	"fmt"
	"os"
)

var n = flag.Bool("n", false, "Option")

func main() {
	flag.Parse()
	filename := flag.Args()
	var count = 1

	for i := 0; i < len(filename); i++ {
		sf, err := os.Open(filename[i])
		if err != nil {
		}
		scanner := bufio.NewScanner(sf)
		if !*n {
			for scanner.Scan() {
				line := scanner.Text()
				fmt.Println(line)
			}
		} else {
			for scanner.Scan() {
				line := scanner.Text()
				fmt.Print(count)
				fmt.Print(": ")
				fmt.Println(line)
				count++
			}
		}
		sf.Close()
	}

}
