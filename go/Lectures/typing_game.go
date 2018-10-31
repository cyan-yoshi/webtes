package main

import (
	"bufio"
	"fmt"
	"io"
	"math/rand"
	"os"
	"time"
)

/*
* input の return が <-chan string な理由

呼び出し元の main go ルーチンはメッセージを受信したいから input のリターンが受信用となっている

input の中の新しく作られた go ルーチンはチャネルに送信している (chn <- s.Text())
= main go ルーチンにデータを送信している

*/

func input(r io.Reader) <-chan string {
	chn := make(chan string)
	fmt.Println("Start Input")
	go func() {
		fmt.Println("Start Go Func")
		s := bufio.NewScanner(r)
		for s.Scan() {
			fmt.Println("Now For sentence")
			chn <- s.Text()
		}
		fmt.Println("End Go Func")
		close(chn)
	}()
	fmt.Println("End Input")
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
	//fmt.Println("Time Limit is 90 seconds")
	ch := input(os.Stdin)
	limit := time.After(10 * time.Second)
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
