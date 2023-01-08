import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    String filename = "doclist.txt";
    String line;
    Scanner input = new Scanner(System.in);
    ArrayList<String> docArray = new ArrayList<>(10);
    private String name;
    private String surname;
    private String dob;
    private int mobileNum;
    private int licenceNum;
    private String docSpecialisation;


    //method to read the text file after every entry by the user and start of the program
    public ArrayList getDocArray() {
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            if(!file.ready()){
                throw new IOException();
            }
            while ((line = file.readLine()) != null){
                docArray.add(line);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return docArray;
    }

    //method to add doctor details to the arraylist and to the text file
    @Override
    public void updateDoclist(ArrayList<String> docArray) {
        //check whether there are 10 doctors in the system
        if (docArray.size() >= 10) {
            System.out.println("Only 10 doctors can be registered to the system");
            return;
        }
        //validating string with regex
        System.out.println("Enter the doctor's name");
        while (true) {
            name = input.nextLine();
            if (name.matches("[A-Za-z]+")) {
                break;
            }
            System.out.println("Please Enter a Valid Name: ");
        }

        System.out.println("Enter the doctor's surname");
        while (true){
            surname = input.nextLine();
            if(surname.matches("[A-Za-z]*")) {
                break;
            }
            System.out.println("Please Enter a Valid Surname: ");

        }

        System.out.println("Enter doctor's date of birth");
        while (true){
            if(input.hasNext()) {
                dob = input.nextLine();
                break;
            }else {
                System.out.println("Please Enter a Valid Date: ");
            }
        }

//      validating integer
        System.out.println("Enter doctor's mobile number");
        while (true) {
            try {
                mobileNum = Integer.parseInt(input.nextLine());
                break;
            }
            catch (Exception e) {
                System.out.println("Please enter a valid number");
            }
        }

        System.out.println("Enter doctor's licence number");
        while (true) {
            try {
                licenceNum = Integer.parseInt(input.nextLine());
                break;
            }
            catch (Exception e) {
                System.out.println("Please enter a valid licence number:");
            }
        }

        System.out.println("Enter doctor's specialisation");
        while (true){
            docSpecialisation = input.nextLine();
            if(docSpecialisation.matches("[A-Za-z]*")) {
                break;
            }else {
                System.out.println("Please Enter a Valid specialisation: ");
            }
        }

        docArray.add(name + "," + surname + "," + dob + "," + mobileNum + "," + licenceNum + "," + docSpecialisation);

        //update the text file
        try {
            FileWriter writer = new FileWriter(filename);
            Writer output = new BufferedWriter(writer);
            for(int i = 0; i < docArray.size(); i++){
                output.write(docArray.get(i).toString() + "\n");
            }
            output.close();
            System.out.println("File Updated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method for deleting a doctor by the license no
    @Override
    public void delDoc(ArrayList<String> docArray) {
        int index = 11;
        System.out.println("Enter the doctor's License Number: ");
        licenceNum = Integer.parseInt(input.nextLine());
        for(int i = 0; i < docArray.size(); i++){
            String data = docArray.get(i);
            ArrayList<String> docnames = new ArrayList<>(List.of(data.split(",")));
            int num = Integer.parseInt(docnames.get(4));
            if( licenceNum == num){
                index = i;
            }
        }

        //check if the user given number is valid and remove the doc from the system
        if (index != 11){
            docArray.remove(index);
            //update the text file
            try {
                FileWriter writer = new FileWriter(filename);
                Writer output = new BufferedWriter(writer);
                for(int i = 0; i < docArray.size(); i++){
                    output.write(docArray.get(i).toString() + "\n");
                }
                output.close();
                System.out.println("Doctor Deleted : "+ licenceNum);
                System.out.println("Total number of doctors in the system: "+ docArray.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Invalid License number");
        }
    }

    //method for printing doctor details in the console
    @Override
    public void printDoclist(ArrayList<String> docArray) {

        ArrayList<String> details = docArray;
        //sort the list by surname
        details.sort(new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return filter(lhs).compareTo(filter(rhs));
            }

            private String filter(String s) {
                // consider the first comma
                return s.replaceFirst("^.*?, ", "");
            }
        });
        
        for(int i = 0; i < details.size(); i++){
            String data = details.get(i);
            ArrayList<String> docnames = new ArrayList<>(List.of(data.split(",")));
            System.out.println(i+1 + ") " + docnames.get(1)+ " " + docnames.get(0)+ " | Licence No: " + docnames.get(4)+ " | Mobile No: " + docnames.get(3)+ " | Specialisation: " + docnames.get(5)+ " | DOB: " + docnames.get(2));
        }
    }
}
