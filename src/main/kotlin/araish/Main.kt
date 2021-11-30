package araish

import araish.MyList.Companion.buildList
import araish.MyList.Companion.buildMap
import araish.C.Companion.buildList
import araish.B.Companion.buildList

fun <T : Number> Int.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<Int, T>.() -> Unit = {}): Int {
    return NumberCollectionLiteralBuilder<Int, T>().apply(conf).build()
}

fun <T: Number> Double.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<Double, T>.() -> Unit = {}): Double {
    return NumberCollectionLiteralBuilder<Double, T>().apply(conf).build()
}

fun <T> expectMyList(myList: MyList<T>) {
    println("myList = [${myList}]")
}

fun <T> fVariable(a: T) {}

fun <T: B> abc(e: T) {}

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val b: Double = [1, 2]
            println("b = $b\n")

            val myList: MyList<Int> = [1, 2, 3]
            myList.forEachIndexed { index, i ->
                println("myList[$index] = $i")
            }
            println()

            val myList2: MyList<Int> = [1 : 1, 2 : 2, 3 : 3]
            myList2.forEachIndexed { index, i ->
                println("myList2[$index] = $i")
            }
            println()

//            val a = [1, 2, 3]

//            expectMyList([1, 2, 3])

//            fVariable([1, 2, 3])

//            abc([1, 2, 3])
        }

    }
}
