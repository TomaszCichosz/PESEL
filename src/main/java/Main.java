import pesel.PESELUtils;
import utils.InputUtils;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pesel;
        int decision;
        int[] peselTab;
        boolean exit = false;

        while (!exit) {
            pesel = InputUtils.getPESEL();
            peselTab = PESELUtils.stringToInts(pesel);
            if (PESELUtils.peselChecker(peselTab)) {
                System.out.println("PESEL valid");
            } else {
                System.out.println("PESEL invalid");
            }
            System.out.println("Birthdate:");
            System.out.println(PESELUtils.birthdateChecker(pesel));
            System.out.print("Gender: ");
            if (PESELUtils.isFemale(pesel)) {
                System.out.println("female");
            } else {
                System.out.println("male");
            }
            System.out.println("To exit type \"0\"");
            decision = scanner.nextInt();
            if (decision == 0) {
                exit = true;
            }
        }
    }
}
