package araish

//object CLUtils {
//    fun Double.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<Double, Double>.() -> Unit = {}): Double {
//        println("Double.buildList()")
//        return NumberCollectionLiteralBuilder<Double, Double>().apply(conf).build()
//    }

    fun MyList.Companion.buildList(size: Int, conf: ListCollectionLiteralBuilder<MyList<String>, String>.() -> Unit = {}): MyList<String> {
        println("MyList<String>.buildList()")
        return MyList.fromList(listOf("Const", "List", "Of", "Strings"))
    }
//}

