package araish

//import araish.MyList.Companion.buildSeq

fun <T> Int.Companion.buildSeq(size: Int, conf: SeqCollectionLiteralBuilder<Int, T>.() -> Unit = {}): Int {
    return object : SeqCollectionLiteralBuilder<Int, T> {
        private val buf = mutableListOf<T>()

        override fun add(element: T) {
            buf.add(element)
        }

        override fun build(): Int {
            return buf.fold(0) { acc, e ->
                acc + e as Int
            }
        }
    }.apply(conf).build()
}

fun <T> Double.Companion.buildSeq(size: Int, conf: SeqCollectionLiteralBuilder<Double, T>.() -> Unit = {}): Double {
    return object : SeqCollectionLiteralBuilder<Double, T> {
        private val buf = mutableListOf<T>()

        override fun add(element: T) {
            buf.add(element)
        }

        override fun build(): Double {
            return buf.fold(0.0) { acc, e ->
                acc + e as Double
            }
        }
    }.apply(conf).build()
}

fun <T> fVariable(a: T) {}

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val b: Int = [1, 2]
            println("b = $b")

//            val myList: MyList<Int> = [1, 2, 3]
//            myList.forEachIndexed { index, i ->
//                println("myList[$index] = $i")
//            }

//            fVariable([1, 2, 3])
        }
    }
}
