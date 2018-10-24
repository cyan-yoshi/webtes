package main

func main() {
	type Game struct {
		Name  string
		Point []int
	}

	var game Game

	game.Name = "太郎"
	game.Point = append(game.Point, 20, 10, 40, 30)
	println(game.Name)
	for i := 0; i < len(game.Point); i++ {
		print(i + 1)
		print("回目: ")
		println(game.Point[i])
	}

}
