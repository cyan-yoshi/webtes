package mypkg_test

import (
	"testing"
)

func TestHex_String(t *testing.T) {
	expect := "a"
	actual := mypkg.Hex(10).string()
	if actual != expect {
		t.Errirf(`expect="%s" actual="%s"`, expect, actual)
	}
}
