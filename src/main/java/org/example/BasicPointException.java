package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
class BasicPoint implements Cloneable {
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    private double x;
    private double y;

    BasicPoint(double xcord, double ycord) {
        x = xcord;
        y = ycord;
    }

    public boolean eql(double x2, double y2) {
        boolean check = false;
        if (x == x2 && y == y2) {
            check = true;
        }
        return check;
    }

    public BasicPoint copy() throws CloneNotSupportedException {
        return (BasicPoint) this.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        try {
            Scanner sc = new Scanner(System.in);
            String dumy = "";
            LOGGER.log(Level.INFO, "Enter the X-coordinate");
            double x1 = sc.nextDouble();
            LOGGER.log(Level.INFO, "Enter the Y-coordinate");
            double y1 = sc.nextDouble();
            BasicPoint p = new BasicPoint(x1, y1);
            BasicPoint p1 = p.copy();
            LOGGER.info("Enter the New X coordinate");
            p1.x = sc.nextDouble();
            LOGGER.info("Enter the New Y coordinate");
            p1.y = sc.nextDouble();
            boolean confm = p.eql(p1.x, p1.y);
            if (confm) {
                LOGGER.info("TRUE! Both are same");
            } else {
                LOGGER.info("False! Both are Not Same");
            }
            dumy = "Original points are " + p.x + "and " + p.y;
            LOGGER.info(dumy);
            dumy = "Cloned points are " + p1.x + "and " + p1.y;
            LOGGER.info(dumy);
        } catch (Exception e) {
            LOGGER.info("Something went wrong while giving input! " + e);
        }
    }
}