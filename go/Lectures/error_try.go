package main

import (
	"fmt"
	"os"
)

type Stringer interface {
	String() string
}

func ToStringer(v interface{}) (Stringer, error) {
	if s, ok := v.(Stringer); ok {
		return s, nil
	}
	return nil, MyError("Cast Error")
}

type MyError string

func (e MyError) Error() string {
	return string(e)
}

type S string

func (s S) String() string {
	return string(s)
}

func main() {
	v := S(1)
	s, err := ToStringer(v)

	if err != nil {
		fmt.Println(os.Stderr, "ERROR: ", err)
	} else {
		fmt.Println(s.String())
	}
}
