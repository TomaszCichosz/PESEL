package pesel;

public class PESELUtils {

    public static int[] stringToInts(String pesel) {
        String[] peselTab = pesel.split("");
        int[] peselIntTab = new int[11];
        for (int i = 0; i < 11; i++) {
            peselIntTab[i] = Integer.parseInt(peselTab[i]);
        }
        return peselIntTab;
    }

    public static boolean peselChecker(int[] peselTab) {
        int[] weightTab = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};
        int checkSum = 0;
        for (int i = 0; i < 11; i++) {
            checkSum += weightTab[i] * peselTab[i];
        }
        return checkSum % 10 == 0;
    }

    public static int birthCenturyChecker(String pesel) {
        if (pesel.charAt(2) == '2' || pesel.charAt(2) == '3') {
            return 20;
        } else if (pesel.charAt(2) == '8' || pesel.charAt(2) == '9') {
            return 18;
        } else return 19;
    }

    public static String birthdateChecker(String pesel) {
        int century = birthCenturyChecker(pesel);
        String birthdate = Integer.toString(century);
        birthdate = birthdate.concat(pesel.substring(0, 2));
        birthdate = birthdate.concat(".");
        if (century == 19) {
            birthdate = birthdate.concat(pesel.substring(2, 4));
        } else if (century == 20) {
            birthdate = birthdate.concat(Integer.toString(Integer.parseInt(pesel.substring(2, 4)) - 20));
        } else if (century == 18) {
            birthdate = birthdate.concat(Integer.toString(Integer.parseInt(pesel.substring(2, 4)) - 80));
        }
        birthdate = birthdate.concat(".");
        birthdate = birthdate.concat(pesel.substring(4, 6));
        return birthdate;
    }

    public static boolean isFemale(String pesel) {
        return Character.getNumericValue(pesel.charAt(9)) % 2 == 0;
    }
}
