package org.example;

import java.util.Scanner;
import java.util.logging.*;
class ShapeAndDim {
    static String s;
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    private static final String TRIANGLE = "TRIANGLE";
    private static final String RECTANGLE = "RECTANGLE";
    private static final String CIRCLE = "CIRCLE";
    private static final String OPTIONS = "Select the Below required option\n1.Perimeter\n2.Area\n3.Both";
    private static final String QUERY = "Oh! choose the correct option";
    String typeOfShape;
    double length;
    double breadth;
    double radius;
    double side1;
    double side2;
    double side3;
    double base;
    double height;
    static final float PI = 3.14f;

    ShapeAndDim(float a, float b) {
        length = a;
        breadth = b;
    }

    ShapeAndDim(float b1, float h1, float s1, float s2, float s3) {
        base = b1;
        height = h1;
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    ShapeAndDim(float r) {
        radius = r;
    }

    public double perimeter(String s) {
        if (((s.toUpperCase()).compareTo(TRIANGLE)) == 0) {
            return (side1 + side2 + side3);
        } else if (((s.toUpperCase()).compareTo(RECTANGLE)) == 0) {
            return (2 * (length + breadth));
        } else if (((s.toUpperCase()).compareTo(CIRCLE)) == 0) {
            return (2 * PI * radius);
        }
        return 0.0;
    }

    public double area(String s) {
        if (((s.toUpperCase()).compareTo(TRIANGLE)) == 0) {
            return (0.5 * base * height);
        } else if (((s.toUpperCase()).compareTo(RECTANGLE)) == 0) {
            return (length * breadth);
        } else if (((s.toUpperCase()).compareTo(CIRCLE)) == 0) {
            return (PI * radius * radius);
        }
        return 0.0;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            LOGGER.info("Please enter the shape for which you want to find Area and Perimeter");
            String op = sc.next();
            if (((op.toUpperCase()).compareTo(RECTANGLE)) == 0) {
                String s;
                LOGGER.info("Enter the length of the Rectangle");
                float l = sc.nextFloat();
                ShapeAndDim.LOGGER.info("Enter the breadth of the Rectangle");
                float b = sc.nextFloat();
                ShapeAndDim figure = new ShapeAndDim(l, b);
                double pm = figure.perimeter(RECTANGLE);
                s = "The perimeter of the Rectangle is-----" + pm;
                LOGGER.info(s);
                double ar = figure.area(RECTANGLE);
                s = "The Area of the Rectangle is-----" + ar;
                LOGGER.info(s);
            } else if (((op.toUpperCase()).compareTo(TRIANGLE)) == 0) {
                LOGGER.info("Enter the base of the Triangle");
                float b1 = sc.nextFloat();
                LOGGER.info("Enter the height of the Triangle");
                float h1 = sc.nextFloat();
                LOGGER.info("Enter the three sides of the Triangle");
                float s1 = sc.nextFloat();
                float s2 = sc.nextFloat();
                float s3 = sc.nextFloat();
                ShapeAndDim figure = new ShapeAndDim(b1, h1, s1, s2, s3);
                double pm1 = figure.perimeter(TRIANGLE);
                s = "The perimeter of the Triangle is-----" + pm1;
                LOGGER.info(s);
                double ar1 = figure.area(TRIANGLE);
                s = "The Area of the Rectangle is-----" + ar1;
                LOGGER.info(s);
            } else if (((op.toUpperCase()).compareTo(CIRCLE)) == 0) {
                LOGGER.info("Enter the radius of the Circle");
                float r = sc.nextFloat();
                ShapeAndDim figure = new ShapeAndDim(r);
                double pm2 = figure.perimeter(CIRCLE);
                s = "The perimeter of the circle is-----" + pm2;
                LOGGER.info(s);
                ShapeAndDim figure3 = new ShapeAndDim(r);
                double ar2 = figure3.area(CIRCLE);
                s = "The Area of the circle is-----" + ar2;
                LOGGER.info(s);
            } else {
                LOGGER.info(QUERY);
            }
        } catch (Exception e) {
            LOGGER.info("Something went wrong while giving input! "+e);
        }

    }
}