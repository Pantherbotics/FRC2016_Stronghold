package org.usfirst.frc.team3863;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Joshua Freedman on 2/8/2016.
 * Project: 2016Robot
 */
@SuppressWarnings("SameParameterValue")
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
        super.println(x);
        printlnobj(x);
    }

    @Override
    public void println(String x) {
        super.println(x);
        printlnobj(x);
    }

    @Override
    public void println(double x) {
        super.println(x);
        printlnobj(x);
    }

    @Override
    public void println(float x) {
        super.println(x);
        printlnobj(x);
    }

    @Override
    public void println(long x) {
        super.println(x);
        printlnobj(x);
    }

    @Override
    public void println(int x) {
        super.println(x);
        printlnobj(x);
    }

    @Override
    public void println(boolean x) {
        super.println(x);
        printlnobj(x);
    }

    @Override
    public void println() {
        super.println();
        printlnobj("\n\r");
    }

    @Override
    public void println(char x) {
        super.println(x);
        printlnobj(x);
    }

    @Override
    public void println(char[] x) {
        super.println(x);
        printlnobj(x);
    }
}
