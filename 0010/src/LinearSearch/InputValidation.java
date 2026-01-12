package LinearSearch;

import java.util.Scanner;

public class InputValidation {

    private final static Scanner sc = new Scanner(System.in);


    /**
     * provide an integer number within the range
     * @param msg
     * @param min
     * @param max are the range accept
     * @return a valid integer
     */
    public static int inputInteger(String msg, int min, int max) {
     
        while (true) {
            System.out.println(msg);
            String input = inputString("");
               //handle invalid number input from user
                try {
                    int res = Integer.parseInt(input);
                    
                    if (res <= min || res >= max) {
                        System.out.println("Invalid, please enter within the range");
                    } else {
                        return res;
                    }
                }            
                catch (NumberFormatException nfe) {
                    System.out.println("Invalid, please enter is an integer number");
                }
            }
    }
    
    public static String inputString(String msg){
          while (true) {
            System.out.println(msg);
            String input = sc.nextLine().trim();
            
            if (input.isEmpty()) {
                System.out.println("Invalid, input cannot empty");
            } else {
                return input;
            }
            
        }
    }
    
}
