package mypkg_test

import (
	"testing"
)

type Hex int

func (h Hex) String() string {
	return fmt.Sprintf("%x", int(h))
}
