package araish

import araish.MyList.Companion.buildList
import araish.MyList.Companion.buildMap
import araish.C.Companion.buildList
import araish.B.Companion.buildList



fun <T> List.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<List<T>, T>.() -> Unit = {}): List<T> {
    return TODO()
}


fun <T : Number> Int.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<Int, T>.() -> Unit = {}): Int {
    return NumberCollectionLiteralBuilder<Int, T>().apply(conf).build()
}

fun <T: Number> Double.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<Double, T>.() -> Unit = {}): Double {
    println("Double.buildList<T>()")
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
    println("<top>.expectMyList")
    println("myList = [${myList}]\n")
}

//fun <T> fVariable(a: List<T>) {
//    println("<top>.fVariable")
//    a.forEach(::println)
//    println()
//}

fun <T: B> abc(e: T) {
    println("<top>.abc")
    println("abc.e=$e\n")
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
            val b = a + [3, 4]
            println("a=$a\nb=$b\n")
//
            val c: Double = [1, 2] // buildList<Int>
            println("c=$c\n")
            val cc = Double [1.0, 2.0] // buildList
            println("cc=$cc\n")
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
            println("doubleMap = $doubleMap\n")

//            val d = [1, 2, 3] // error no companion object in List

            expectMyList([1, 2, 3])

            abc([1, 2, 3])

            println("returnB=${returnCL()}\n")

//            val empty: MyList<String> = [] // error: buildList shadowed by buildList<T>
//            println("empty=$empty")
//            println("empty.qualifiedName=${empty::class.qualifiedName}\n")

            val typed = MyList<Short> [1, 2, 3]
            typed.forEachIndexed { i, a ->
                println("MyList<Short>[$i]=$a with type ${a::class.javaPrimitiveType}")
            }
            println()

//            val wrongArgumentType = MyList<String> [1, 2, 3]

        }

    }
}
