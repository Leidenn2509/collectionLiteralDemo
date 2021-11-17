package araish

//import araish.MyList.Companion.buildSeq

fun <T : Number> Int.Companion.buildSeq(size: Int, conf: SeqCollectionLiteralBuilder<Int, T>.() -> Unit = {}): Int {
    return NumberCollectionLiteralBuilder<Int, T>().apply(conf).build()
}

fun <T: Number> Double.Companion.buildSeq(size: Int, conf: SeqCollectionLiteralBuilder<Double, T>.() -> Unit = {}): Double {
    return NumberCollectionLiteralBuilder<Double, T>().apply(conf).build()
}

fun <T> expectMyList(myList: MyList<T>) {
    println("myList = [${myList}]")
}

fun <T> fVariable(a: T) {}

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val b: Int = [1, 2]
            println("b = $b\n")

//            val myList: MyList<Int> = [1, 2, 3]
//            myList.forEachIndexed { index, i ->
//                println("myList[$index] = $i")
//            }
//            println()

//            fVariable([1, 2, 3])

//            expectMyList([1, 2, 3])
        }

    }
}
