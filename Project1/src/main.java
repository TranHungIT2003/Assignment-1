import java.util.Scanner;
import modules.ProgramManager;

/**
 * @author <Tran Duy Hung - s3928533>
 */

public class main {
    public static void main(String[] args) throws Exception {
        ProgramManager p = new ProgramManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n\n1. Add Claim");
            System.out.println("2. Update claim");
            System.out.println("3. Delete claim");
            System.out.println("4. Display all claims");
            System.out.println("5. Display all customers");
            System.out.println("6. Display all insurance cards");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    p.addClaim();
                    break;
                case 2:
                    p.updateClaim();
                    break;
                case 3:
                    p.deleteClaim();
                    break;
                case 4:
                    p.displayAllClaims();
                    break;
                case 5:
                    p.displayListCustomers();
                    break;
                case 6:
                    p.displayListInsuranceCards();
                    break;
                case 0:
                    System.out.println("End program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection, please select again.");
            }
        }
    }

}
