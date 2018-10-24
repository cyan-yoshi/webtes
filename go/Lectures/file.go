package main

import (
	"os"
)

func main() {
	//読み込み用にファイルを開く
	sf, err := os.Open(src)
	if err != nil {
		return err
	}
	defer sf.Close()

	//書き込み用にファイルを開く
	df, err := os.Create(dst)
	if err != nil {
		return err
	}
	defer df.Close()
}
