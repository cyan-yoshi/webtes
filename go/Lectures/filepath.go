package main

import (
	"fmt"
	"path/filepath"
)

func main() {
	path := filepath.Join("dir", "main.go")
	fmt.Println(filepath.Ext(path))
	fmt.Println(filepath.Base(path))
	fmt.Println(filepath.Dir(path))

    err := filepath.Walk("/",func(path string,info os.FileInfo,err error)
    error {
    	if filepath.Ext(path) == ".go" {
    		fnt.Println(path)
    	}
    	return nil
    })
	if err != nil {
		return err
	}
}
