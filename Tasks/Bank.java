import java.util.Scanner;

class Bank {
    protected double defaultCharge = 15.0;
    public double getDefaultCharge() {
        return defaultCharge;
    }
    public double calculateTransactionCharge(double amount) {
        return (defaultCharge/100) * amount;
    }
}

class ICICI extends Bank {
    private double additionalCharge = 3.0;
    @Override
    public double calculateTransactionCharge(double amount) {
        return ((defaultCharge + additionalCharge)/100) * amount;
    }

    public double getAdditionalCharge() {
        return additionalCharge;
    }
}

class HDFC extends Bank {
    private double discount = 2.0;
    @Override
    public double calculateTransactionCharge(double amount) {
        return ((defaultCharge - discount) / 100) * amount;
    }

    public double getDiscount() {
        return discount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the transaction amount: ");
        double amount = scanner.nextDouble();
      
        Bank bank = new Bank();
        System.out.println("Default transaction charge for " + amount + ": " + bank.calculateTransactionCharge(amount));

        ICICI iciciBank = new ICICI();
        System.out.println("ICICI transaction charge for " + amount + ": " + iciciBank.calculateTransactionCharge(amount));

        HDFC hdfcBank = new HDFC();
        System.out.println("HDFC transaction charge for " + amount + ": " + hdfcBank.calculateTransactionCharge(amount));
    }
}
