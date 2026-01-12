package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputValidation {

    private final static Scanner sc = new Scanner(System.in);

    public static String getString(String msg, String regex) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            //check string user entered empty ==>tell user
            if (input.isEmpty()) {
                System.out.println("Invalid, input could not empty!");
            }//check input matches with format yet==> tell user
            else if (!regex.isEmpty()) {
                if (!input.matches(regex)) {
                    System.out.println("Invalid, input have wrong format!");
                } else {
                    return input;
                }
            } else {
                return input;
            }
        }
    }

    public static int getInteger(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int input = Integer.parseInt(getString("", ""));
                //check input invalid with range of data
                if (input < min || input > max) {
                    System.out.println("Invalid, input could be in the range");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid, input could be integer number.");
            }
        }
    }

    public static double getDouble(String msg, double min, double max) {
        //That loop run until user enter valid data
        while (true) {
            System.out.print(msg);
            try {
                double input = Double.parseDouble(getString("", "^[0-9]+[\\.][5]$"));
                //check input invalid with range of data
                if (input < min || input > max) {
                    System.out.println("Invalid, input could be in the range");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid, input could be double number.");
            }
        }
    }

    public static String getDate(String msg) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        while (true) {
            try {
                String input = getString(msg, "^[0-9]{1,2}[\\-][0-9]{1,2}[\\-][0-9]{4}$");
                dateFormat.parse(input);
                return input;
            } catch (Exception e) {
                System.out.println("Invalid, input could be valid date");
            }
        }

    }

//    //test
    public static void main(String[] args) {
//        String t1= getString("check String", "");
//        int t2= getInteger("check integer", 0, 5);
//        double t3=  getDouble("check double: ", 0.0, 5.0);
//String date = getDate("Input date: ");
    }
}
