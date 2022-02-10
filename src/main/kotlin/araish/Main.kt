package araish

import araish.MyList.Companion.buildList
import araish.MyList.Companion.buildMap
import araish.C.Companion.buildList
import araish.B.Companion.buildList
import araish.over
import araish.NullableBuilder.Companion.buildList



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

fun <T> over(a: MyList<T>) {
    println("<top>.over(a: MyList<T> = [${a.map { it!!::class.simpleName }}])\n")
}

fun number(a: MyList<Number>) {
    println("<top>.number(a = [${a}])\n")
}


fun anyVsMyList(a: Any) {
    println("<top>.anyVsMyList(a: Any = [${a}])\n")
}
fun anyVsMyList(a: MyList<Int>) {
    println("<top>.anyVsMyList(a: MyList<Int> = [${a}])\n")
}


fun <T> twoArg(a: T, b: MyList<T>) {
    println("<top>.twoArg(a = [${a}], b = [${b.map { it to it!!::class.simpleName }}])\n")
}

fun <T: B> abc(e: T) {
    println("<top>.abc")
    println("abc.e=$e\n")
}

operator fun B.Companion.get(a: Int, b: Int, c: Int): List<Int> {
    return listOf(a, b, c)
}

fun returnCL() = B [1]

class NullableBuilder {
    companion object {
        fun <T> buildList(size: Int, conf: ListCollectionLiteralBuilder<NullableBuilder?, T>.() -> Unit = {}): NullableBuilder? {
            return null
        }
    }
}

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

            over([1.0])

            over([])

            number([1, 1.0])

            anyVsMyList([])

            twoArg(1.0, [1, "2"]) // T = it(kotlin/Comparable<*> & java/io/Serializable)

//            val notNull: NullableBuilder = [1, 0] // error no builder for NullableBuilder
            val nullable: NullableBuilder? = [1, 0]
            println("nullable=$nullable\n")
        }

    }
}
