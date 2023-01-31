package org.example;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 class Student {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private String studentName;
    private char gradeLevel;
    private float gPA;

    Student(String name, char gr, float gp) {
        studentName = name;
        gradeLevel = gr;
        gPA = gp;
    }

    public void update(float gpa) {
        gPA = gpa;
        LOGGER.log(Level.INFO, "The updated Gpa is");
        LOGGER.log(Level.INFO, Double.toString(gPA), "The updated Gpa is");
    }

    public String nameAndgPA() {
        String res = "";
        res = String.format("%s has a %.1f GPA", studentName, gPA);
        return res;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            LOGGER.log(Level.INFO, "Please Enter the Student Name");
            String name = sc.next();
            LOGGER.log(Level.INFO, "Enter the Grade level");
            char gr = sc.next().charAt(0);
            LOGGER.log(Level.INFO, "Enter your GPA");
            float gp = sc.nextFloat();
            Student calculation = new Student(name, gr, gp);
            boolean choose = true;
            while (choose) {
                LOGGER.log(Level.INFO, "Do you need to update your GPA" + "\n" + "1.Yes" + "\n" + "2.No" + "\n" + "3.View Student Name and GPA" + "\n" + "4.Exit");
                int ch = sc.nextInt();
                if (ch == 1) {
                    LOGGER.log(Level.INFO, "Enter the GPA to be Upated");
                    float updated = sc.nextFloat();
                    calculation.update(updated);
                } else if (ch == 2) {
                    LOGGER.log(Level.INFO, "Its Okay");
                } else if (ch == 3) {
                    String result = calculation.nameAndgPA();
                    LOGGER.log(Level.INFO, result);
                    choose = false;
                }
            }
        }
        catch (Exception e) {
            LOGGER.info("Something went wrong while giving input! "+e);
        }
    }
}