package main

import (
	"fmt"
	"strconv"
)

func fooBarQix() {
	for i := 1; i <= 100; i++ {
		result := applyRules(i)
		fmt.Println(result)
	}
}

func applyRules(number int) string {
	mappings := map[int]string{3: "Foo", 5: "Bar"}

	var result string

	for key, value := range mappings {
		if number%key == 0 {
			result += value
		}
	}

	for _, digit := range strconv.Itoa(number) {
		switch digit {
		case '3':
			result += "Foo"
		case '5':
			result += "Bar"
		}
	}

	if result == "" {
		return strconv.Itoa(number)
	}

	return result
}
