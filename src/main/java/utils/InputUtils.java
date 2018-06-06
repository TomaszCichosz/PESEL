package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    public static String getPESEL() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Type PESEL number to check");
            input = scanner.nextLine();
            input = input.trim();
            if (!isEmpty(input)) {
                if (containsDigitsOnly(input)) {
                    if (lengthChecker(input)) {
                        return input;
                    } else {
                        System.out.println("Incorrect length");
                    }
                } else {
                    System.out.println("PESEL number have to contain digits only");
                }
            } else {
                System.out.println("Empty input");
            }
        }
    }

    private static boolean isEmpty(String input) {
        return input.length() == 0;
    }

    private static boolean containsDigitsOnly(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean lengthChecker(String input) {
        return input.length() == 11;
    }

    public static int getInteger() {
        Scanner scanner = new Scanner(System.in);
        int integer;
        while (true) {
            try {
                integer = scanner.nextInt();
                return integer;
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Type integer value!");
            }
        }
    }

}
