public class Main {

    public static void main(String[] args) {

        String pesel;
        int[] peselTab;
        boolean exit = false;

        while (!exit) {
            pesel = InputUtils.getPESEL();
            peselTab = PESEL.stringToInts(pesel);
            if (PESEL.peselChecker(peselTab)) {
                System.out.println("PESEL valid");
            } else {
                System.out.println("PESEL invalid");
            }
            System.out.println("Birthdate:");
            System.out.println(PESEL.birthdateChecker(pesel));
            System.out.print("Gender: ");
            if (PESEL.isFemale(pesel)) {
                System.out.println("female");
            } else {
                System.out.println("male");
            }
            System.out.println("Exit type \"0\"");
            if (InputUtils.getInteger() == 0) {
                exit = true;
            }
        }
    }
}
