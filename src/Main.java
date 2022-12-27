import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- WestminsterSkinConsultationManager ---\n");
        System.out.println("Commands");
        System.out.println("'A' - add a new doctor\n'B' - print the doctor list\n'C' - save and update the doctor list\n'D' -  delete a doctor");
        System.out.println("Enter a String: ");
        String input = null;
        boolean invalid = true;
        while(invalid){
            Scanner sc = new Scanner(System.in);
            if(sc.hasNext("[A-D]*")) {
                input = sc.next();
                invalid =false;
            }else {
                System.out.println("Please Enter a Valid Command: ");
            }
        }

        if(input == "A"){

        }

    }
}