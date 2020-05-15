package uy.edu.ude.external.io

class Console : Reader, Writer {
    override fun write(message: String) {
        print(message)
    }

    override fun readString(): String {
        return readLine() ?: ""
    }

    override fun readInt(): Int {
        return readLine()?.toInt() ?: 0
    }
}