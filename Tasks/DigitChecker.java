class SingleDigitExcep extends Exception {
    public SingleDigitExcep(String message) {
        super(message);
    }
}

public class DigitChecker {
    public static void main(String[] args) {
        try {
            check(10);  
        } catch (SingleDigitExcep e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }

    public static void checkNumber(int number) throws SingleDigitExcep {
        if (n > 9 || n < -9) {
            throw new SingleDigitExcep("The number "+ n +"has more than one digit");
        }
    }
}
