package org.usfirst.frc.team3863;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Wolf on 2/8/2016.
 */
public class InterceptorPS extends PrintStream {

    boolean errorStream = false;

    public InterceptorPS(OutputStream out) {
        this(out, false);
    }

    public InterceptorPS(OutputStream out, boolean errorStream) {
        super(out, true);
        this.errorStream = errorStream;
    }

    private void printlnobj(Object x) {
        // TODO write to dashboard...
        if (errorStream) {
            //Write to error

        } else {
            //write normal
        }
    }

    @Override
    public void println(Object x) {
        printlnobj(x);
    }

    @Override
    public void println(String x) {
        printlnobj(x);
    }

    @Override
    public void println(double x) {
        printlnobj(x);
    }

    @Override
    public void println(float x) {
        printlnobj(x);
    }

    @Override
    public void println(long x) {
        printlnobj(x);
    }

    @Override
    public void println(int x) {
        printlnobj(x);
    }

    @Override
    public void println(boolean x) {
        printlnobj(x);
    }

    @Override
    public void println() {
        printlnobj("\n\r");
    }

    @Override
    public void println(char x) {
        printlnobj(x);
    }

    @Override
    public void println(char[] x) {
        printlnobj(x);
    }
}
