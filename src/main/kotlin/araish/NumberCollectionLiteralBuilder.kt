package araish

open class NumberCollectionLiteralBuilder<N: Number, T: Number> : ListCollectionLiteralBuilder<N, T> {
    private var buf = 0.0

    override fun add(element: T) {
        buf += element.toDouble()
    }

    @Suppress("UNCHECKED_CAST")
    override fun build(): N {
        return buf as N
    }
}