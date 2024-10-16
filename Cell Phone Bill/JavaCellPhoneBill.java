import java.util.Scanner;

public class JavaCellPhoneBill {

    private static final double OVER_LIMIT_CHARGE = 15.0;

    private static final int PLAN_A = 0;
    private static final int PLAN_B = 1;
    private static final int PLAN_C = 2;
    private static final int PLAN_D = 3;

    private static final int LIMIT = 0;
    private static final int PRICE = 1;
    private static final double[][] OPTION = {
            {0.0, 50.00}, // Plan-A
            {2.0, 60.00}, // Plan-B
            {4.0, 70.00}, // Plan-C
            {10.0, 90.00}, // Plan-D
    };

    private static final int ACCT = 0;
    private static final int NAME = 1;
    private static final int PLAN = 2;
    private static final int USED = 3;
    private static final int BILL = 4;
    private static String[][] Accounts = {
        {"323998-9", "Dan McElroy",    "Plan-A", "0.0", "0.00"},
        {"264442-8", "Manuel Estrada", "Plan-C", "0.0", "0.00"},
        {"355591-3", "Charles Aitken", "Plan-B", "0.0", "0.00"},
        {"100355-4", "Linh Nguyen",    "Plan-D", "0.0", "0.00"},
        {"256052-9", "Alice Browne",   "Plan-D", "0.0", "0.00"},
        {"726619-8", "Dave Ha",        "Plan-A", "0.0", "0.00"},
        {"145767-3", "Rachel Bush",    "Plan-B", "0.0", "0.00"},
        {"767372-3", "Jose Gonzales",  "Plan-A", "0.0", "0.00"},
        {"531923-3", "Oscar Meyer",    "Plan-D", "0.0", "0.00"},
        {"463834-6", "Jibran Akhter",  "Plan-C", "0.0", "0.00"},
        {"123456-7", "John Doe",       "Plan-A", "0.0", "0.00"},
        {"987654-3", "Jane Smith",     "Plan-B", "0.0", "0.00"}
};

    public static void main(String[] args) {
        boolean error;
        inputGBused();
        error = billEachCustomer();
        if (!error)
            printBilling();
    }

    private static void inputGBused() {
        Scanner stdin = new Scanner(System.in);

        System.out.printf("There are %d customers\n\n", Accounts.length);

        System.out.println("Enter GB for:");
        int numberOfCustomers = Accounts.length;
        for (int customer = 0; customer < numberOfCustomers; customer++) {
            System.out.printf("%15.15s %s %s: ",
                    Accounts[customer][NAME],
                    Accounts[customer][ACCT],
                    Accounts[customer][PLAN]);
            Accounts[customer][USED] = stdin.nextLine();
        }
    }

    private static boolean billEachCustomer() {
        double GBused;
        double bill;
        boolean errorFlag = false;

        int numberOfCustomers = Accounts.length;
        try {
            for (int customer = 0; customer < numberOfCustomers; customer++) {

                GBused = Double.valueOf(Accounts[customer][USED]);

                if (Accounts[customer][PLAN].equals("Plan-A")) {
                    bill = computeBill(GBused, OPTION[PLAN_A][LIMIT], OPTION[PLAN_A][PRICE]);
                } else if (Accounts[customer][PLAN].equals("Plan-B")) {
                    bill = computeBill(GBused, OPTION[PLAN_B][LIMIT], OPTION[PLAN_B][PRICE]);
                } else if (Accounts[customer][PLAN].equals("Plan-C")) {
                    bill = computeBill(GBused, OPTION[PLAN_C][LIMIT], OPTION[PLAN_C][PRICE]);
                } else if (Accounts[customer][PLAN].equals("Plan-D")) {
                    bill = computeBill(GBused, OPTION[PLAN_D][LIMIT], OPTION[PLAN_D][PRICE]);
                } else {
                    bill = 0.00; // bill = 0.00 if a non-existing plan is selected
                }

                Accounts[customer][BILL] = String.valueOf(bill);
            }
        } catch (NumberFormatException e) {
            System.out.println("Values for GB used must be numeric");
            errorFlag = true;
        }
        return errorFlag;
    }

    private static double computeBill(double used, double limit, double rate) {
        double overLimit;
        double bill;

        if (used <= limit) {
            overLimit = 0.0;
        } else {
            overLimit = Math.ceil(used - limit);
        }

        bill = rate + overLimit * OVER_LIMIT_CHARGE;
        return bill;
    }

    private static void printBilling() {
        double totalBill = 0.0;

        System.out.printf("\n\n============= Customer Billing =================\n");

        int numberOfCustomers = Accounts.length;
        for (int customer = 0; customer < numberOfCustomers; customer++) {
            double customerBill = Double.valueOf(Accounts[customer][BILL]);
            totalBill += customerBill;

            System.out.printf("%s %s %s\n",
                    Accounts[customer][NAME],
                    Accounts[customer][ACCT],
                    Accounts[customer][PLAN]);
            System.out.printf("  %.1f GB used, bill=%.2f\n\n",
                    Double.valueOf(Accounts[customer][USED]),
                    customerBill);
        }

        System.out.printf("Total amount billed for all customers: %.2f\n", totalBill);
    }
}