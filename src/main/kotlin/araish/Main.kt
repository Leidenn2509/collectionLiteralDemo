package araish

fun <T> List.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<List<T>, T>.() -> Unit = {}): List<T> {
    return TODO()
}


fun <T : Number> Int.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<Int, T>.() -> Unit = {}): Int {
    return NumberCollectionLiteralBuilder<Int, T>().apply(conf).build()
}

fun <T: Number> Double.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<Double, T>.() -> Unit = {}): Double {
    return NumberCollectionLiteralBuilder<Double, T>().apply(conf).build()
}

fun <K, V> Double.Companion.buildMap(size: Int, conf: MapCollectionLiteralBuilder<Double, K, V>.() -> Unit = {}): Double {
    return object : MapCollectionLiteralBuilder<Double, K, V> {
        var res = 0.0
        override fun add(key: K, value: V) {
            (key as? Double)?.let { res += it }
            (value as? Double)?.let { res += it }
        }

        override fun build(): Double {
            return res
        }
    }.apply(conf).build()
}

fun <T> expectMyList(myList: MyList<T>) {
    println("myList = [${myList}]")
}

fun <T> fVariable(a: List<T>) {
    a.forEach(::println)
}

fun <T: B> abc(e: T) {
    println("abc.e=$e")
}

operator fun B.Companion.get(a: Int, b: Int, c: Int): List<Int> {
    return listOf(a, b, c)
}

fun returnCL() = B [1]

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a: MyList<Int> = [1, 2]
            val b = a + [3, 4] // Does not work
            println(b)
//            return
//
            val c: Double = [1, 2]
            println("b = $c\n")
//
            val myList: MyList<Int> = [1, 2, 3]
            myList.forEachIndexed { index, i ->
                println("myList[$index] = $i")
            }
            println()
//
            val myList2: MyList<Int> = [1 : 1, 2 : 2, 3 : 3]
            myList2.forEachIndexed { index, i ->
                println("myList2[$index] = $i")
            }
            println()
//
            val doubleMap: Double = [1.0: 1.0, 2.0: 2.0]
            println("doubleMap = $doubleMap")
            println()

//            val d = [1, 2, 3]

//            expectMyList([1, 2, 3])

//            fVariable([1, 2, 3])

            abc([1, 2, 3])
            println()

            println("returnB=${returnCL()}")
            println()

            val cc: MyList<String> = []
            println("cc=$cc")
            println("cc.qualifiedName=${cc::class.qualifiedName}")

            val ccc = MyList<String> = [1, 2, 3]
        }

    }
}
