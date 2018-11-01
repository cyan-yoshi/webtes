package main

import (
	"html/template"
	//"fmt"
	"math/rand"
	"net/http"
	"time"
)

//var str = "<html><body>{{.Name}}{{.Unsei}}</body></html>"
//str = "<html><body>{{.Name}}さんの運勢は<b>{{.Unsei}}</b>です。</body></html>"
var str = "<html><body>{{.}}</body></html>"

var tmpl = template.Must(template.New("sign").Parse(str))

type Data struct {
	Name  string
	Unsei string
}

func handler(w http.ResponseWriter, r *http.Request) {
	//fmt.Fprint(w, r.FormValue("p"), "さんの運勢は「大吉」です")
	var data Data
	data.Name = r.FormValue("p")

	n := rand.Intn(6) + 1

	switch n {
	case 1:
		data.Unsei = "凶"
	case 2:
		data.Unsei = "吉"
	case 3:
		data.Unsei = "吉"
	case 4:
		data.Unsei = "中吉"
	case 5:
		data.Unsei = "中吉"
	case 6:
		data.Unsei = "大吉"
	}
	tmpl.Execute(w, data)
	//if err := tmpl.Execute(w, data); err != nil {
	//	http.Error(w, err.Error(), http.StatusInternalServerError)
	//}
}

func main() {
	rand.Seed(time.Now().UnixNano())
	http.HandleFunc("/", handler)
	http.ListenAndServe(":8080", nil)
}
