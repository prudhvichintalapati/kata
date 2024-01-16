package org.example.kata

class FooBarQix {
    fun withIf() {
        for (i in 1..100) {
            val result = StringBuilder()

            if (i % 3 == 0) {
                result.append("Foo")
            }

            if (i % 5 == 0) {
                result.append("Bar")
            }

            val numberStr = i.toString()
            result.append(numberStr.replace("3", "Foo").replace("5", "Bar"))

            if (result.isEmpty()) {
                println(i)
            } else {
                println(result)
            }
        }
    }

    fun withoutIf() {
        val result = (1..100).map { number ->
            val mappings = mapOf(3 to "Foo", 5 to "Bar")

            val part1 = mappings.keys
                .filter { number % it == 0 }
                .joinToString("") { mappings[it].toString() }

            val part2 = number.toString().map { digit ->
                when (digit) {
                    '3' -> "Foo"
                    '5' -> "Bar"
                    else -> ""
                }
            }.joinToString("")

            if (part1.isEmpty() && part2.isEmpty()) number.toString() else part1 + part2
        }

        println(result.joinToString("\n"))
    }
}