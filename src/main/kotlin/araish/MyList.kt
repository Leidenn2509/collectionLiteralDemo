package araish

class MyList<T> : Iterable<T> {
    private val content = mutableListOf<T>()

    val size: Int
        get() = content.size

    fun add(element: T) {
        content.add(element)
    }

    companion object {
        fun <T> buildList(size: Int, conf: ListCollectionLiteralBuilder<MyList<T>, T>.() -> Unit = {}): MyList<T> {
            return object : ListCollectionLiteralBuilder<MyList<T>, T> {
                private val buf = MyList<T>()

                override fun add(element: T) {
                    buf.add(element)
                }

                override fun build(): MyList<T> {
                    return buf
                }

            }.apply(conf).build()
        }

        fun <T> buildMap(size: Int, conf: MapCollectionLiteralBuilder<MyList<T>, T, T>.() -> Unit = {}): MyList<T> {
            return object : MapCollectionLiteralBuilder<MyList<T>, T, T> {
                private val buf = MyList<T>()

                override fun add(element: T, value: T) {
                    buf.add(element)
                    buf.add(value)
                }

                override fun build(): MyList<T> {
                    return buf
                }

            }.apply(conf).build()
        }

    }

    override fun iterator(): Iterator<T> {
        return content.iterator()
    }

    override fun toString(): String {
        return "MyList(content=$content, size=$size)"
    }
}