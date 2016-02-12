package org.usfirst.frc.team3863.kotlin

import java.io.OutputStream
import java.io.PrintStream

/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class InterceptorPS constructor(out: OutputStream, val errorStream: Boolean = false) : PrintStream(out, true) {

    private fun printlnobj(x: Any?) {
        // TODO write to dashboard...
        if (errorStream) {
            //Write to error

        } else {
            //write normal

        }
    }

    override fun println(x: Any?) {
        super.println(x)
        printlnobj(x)
    }

    override fun println(x: String) {
        super.println(x)
        printlnobj(x)
    }

    override fun println(x: Double) {
        super.println(x)
        printlnobj(x)
    }

    override fun println(x: Float) {
        super.println(x)
        printlnobj(x)
    }

    override fun println(x: Long) {
        super.println(x)
        printlnobj(x)
    }

    override fun println(x: Int) {
        super.println(x)
        printlnobj(x)
    }

    override fun println(x: Boolean) {
        super.println(x)
        printlnobj(x)
    }

    override fun println() {
        super.println()
        printlnobj("\n\r")
    }

    override fun println(x: Char) {
        super.println(x)
        printlnobj(x)
    }

    override fun println(x: CharArray) {
        super.println(x)
        printlnobj(x)
    }
}
