package araish

class MyList<out T>(list: List<T>) : List<T> {
    private var content: MutableList<T> = list.toMutableList()

    override val size: Int
        get() = content.size

    operator fun plus(other: MyList<@UnsafeVariance T>): MyList<T> {
        return MyList(content + other.toList())
    }

    companion object {
        fun <T> buildList(size: Int, conf: ListCollectionLiteralBuilder<MyList<T>, T>.() -> Unit = {}): MyList<T> {
            return object : ListCollectionLiteralBuilder<MyList<T>, T> {
                private val buf = mutableListOf<T>()

                override fun add(element: T) {
                    buf.add(element)
                }

                override fun build(): MyList<T> {
                    return MyList(buf)
                }

            }.apply(conf).build()
        }

        fun <T> buildMap(size: Int, conf: MapCollectionLiteralBuilder<MyList<T>, T, T>.() -> Unit = {}): MyList<T> {
            return object : MapCollectionLiteralBuilder<MyList<T>, T, T> {
                private val buf = mutableListOf<T>()

                override fun add(key: T, value: T) {
                    buf.add(key)
                    buf.add(value)
                }

                override fun build(): MyList<T> {
                    return MyList(buf)
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

    override fun contains(element: @UnsafeVariance T): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<@UnsafeVariance T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): T {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: @UnsafeVariance T): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: @UnsafeVariance T): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<T> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<T> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<T> {
        TODO("Not yet implemented")
    }

    init {
        content = list.toMutableList()
    }
}