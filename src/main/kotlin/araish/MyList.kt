package araish

class MyList<T> : Iterable<T> {
    private val content = mutableListOf<T>()

    val size: Int
        get() = content.size

    fun add(element: T) {
        content.add(element)
    }

    fun get(index: Int): T = content.get(index)

    companion object {
        fun <T> buildSeq(size: Int, conf: SeqCollectionLiteralBuilder<MyList<T>, T>.() -> Unit = {}): MyList<T> {
            return object : SeqCollectionLiteralBuilder<MyList<T>, T> {
                private val buf = MyList<T>()

                override fun add(element: T) {
                    buf.add(element)
                }

                override fun build(): MyList<T> {
                    return buf
                }

            }.apply(conf).build()
        }

        fun <T> build(size: Int, conf: MyList<T>.() -> Unit = {}): MyList<T> {
            return MyList<T>().apply(conf)
        }
    }

    override fun iterator(): Iterator<T> {
        return content.iterator()
    }
}