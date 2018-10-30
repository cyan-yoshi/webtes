package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
)

func input(r io.Reader) <-chan string {
	chanel := make(chan string)
	go func() {
		s := bufio.NewScanner(r)
		fmt.Println(s)
		for s.Scan() {
			chanel <- s.Text()
			<-chanel
		}
		close(chanel)
	}()
	return chanel
}

func main() {
	ch := input(os.Stdin)
	for {
		fmt.Print(">")
		fmt.Println(<-ch)
	}
}
