import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager mgr = new WestminsterSkinConsultationManager();
        System.out.println("--- WestminsterSkinConsultationManager ---");
        ArrayList docArray = new ArrayList<>();
        docArray = mgr.getDocArray();
        String input = null;
        boolean run = true;
        while(run){
            System.out.println("\nCommands");
            System.out.println("'A' - add a new doctor\n'B' - print the doctor list\n'D' -  delete a doctor\n'E' - Exit");
            System.out.println("\nEnter a Command: ");
            Scanner sc = new Scanner(System.in);
            if(sc.hasNext("[A-D]*")) {
                input = sc.next();

                if(input.equals("A")){
                    mgr.updateDoclist(docArray);

                }else if(input.equals("B")){
                    mgr.printDoclist(docArray);
                }
                else if(input.equals("D")){
                    mgr.delDoc(docArray);
                }
                else if(input.equals("E")){
                    run = false;
                }
            }else {
                System.out.println("Please Enter a Valid Command: ");
            }
        }



    }
}