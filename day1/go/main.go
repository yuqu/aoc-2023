package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
	"unicode"
)

func puzzle1() {
	var total int
	file, err := os.Open("../input.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		var firstDigit, secondDigit rune
		text := scanner.Text()
		for _, char := range text {
			if unicode.IsDigit(char) {
				if firstDigit == 0 {
					firstDigit = char
					secondDigit = char
				} else {
					secondDigit = char
				}
			}
		}

		number, err := strconv.Atoi(string(firstDigit) + string(secondDigit))

		if err == nil {
			total += number
		}
	}
	fmt.Printf("total: %v\n", total)
}

func main() {
	puzzle1()
}
