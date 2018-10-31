package main

import (
	"bufio"
	"fmt"
	"io"
	"math/rand"
	"os"
	"time"
)

func input(r io.Reader) <-chan string {
	chn := make(chan string)
	go func() {
		s := bufio.NewScanner(r)
		for s.Scan() {
			chn <- s.Text()
		}
		close(chn)
	}()
	return chn
}

func createliteral(n int) string {
	var Letters = []rune("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
	t := time.Now().UnixNano()
	rand.Seed(t)
	tmp := make([]rune, n)

	for i := range tmp {
		tmp[i] = Letters[rand.Intn(len(Letters))]
	}
	return string(tmp)

}

func main() {
	fmt.Println("Let's Start Typing Game")
	fmt.Println("Time Limit is 90 seconds")
	ch := input(os.Stdin)
	limit := time.After(90 * time.Second)
	truecount := 0
	falsecount := 0
	for {
		literal := createliteral(5)
		fmt.Println(literal)
		fmt.Print("> ")
		select {
		case result := <-ch:
			if literal == result {
				truecount++
			} else {
				falsecount++
			}
		//case <-time.After(5 * time.Second):
		case <-limit:
			fmt.Println("      Time Out!")
			fmt.Println("")
			fmt.Print("Result(true/total): ")
			fmt.Print(truecount)
			fmt.Print("/")
			fmt.Println(falsecount + truecount)
			return
		}

	}
}
