package araish

open class NumberCollectionLiteralBuilder<N: Number, T: Number> : SeqCollectionLiteralBuilder<N, T> {
    private val buf = mutableListOf<T>()

    override fun add(element: T) {
        buf.add(element)
    }

    @Suppress("UNCHECKED_CAST")
    override fun build(): N {
        return buf.fold(0.0) { acc, e ->
            acc + e.toDouble()
        } as N
    }
}