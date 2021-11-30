package araish

interface A

open class B : A {
    companion object {
        fun <T> buildList(size: Int, conf: ListCollectionLiteralBuilder<B, T>.() -> Unit = {}): B {
            println("B.buildSeq")
            return B()
        }
    }
}

open class C : A {
    companion object {
        fun <T> buildList(size: Int, conf: ListCollectionLiteralBuilder<C, T>.() -> Unit = {}): C {
            println("C.buildSeq")
            return C()
        }
    }
}