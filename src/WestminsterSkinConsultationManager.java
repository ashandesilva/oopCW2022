import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    String filename = "doclist.txt";
    String line;
    Scanner input = new Scanner(System.in);
    ArrayList<String> docArray = new ArrayList<>();
    private String name;
    private String surname;
    private String dob;
    private int mobileNum;
    private int licenceNum;
    private String docSpecialisation;


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

    @Override
    public void updateDoclist(ArrayList<String> docArray) {
//        System.out.println("Enter the doctor's name");
//        while (true){
//            if(input.hasNext("[A-Za-z]*")) {
//                name = input.nextLine();
//                break;
//            }
//            System.out.println("Please Enter a Valid Name: ");
//
//
//        }

        //validating string with regex
        System.out.println("Enter the doctor's name");
        while (true) {
            name = input.nextLine();
            if (name.matches("[a-zA-Z]+")) {
                break;
            }
            System.out.println("Please Enter a Valid Name: ");
        }

        System.out.println("Enter the doctor's surname");
        while (true){
            surname = input.nextLine();
            if(surname.matches("[A-Za-z]*")) {
                break;
            }else {
                System.out.println("Please Enter a Valid Surname: ");
            }
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

        System.out.println(docArray);
        docArray.add(name + "," + surname + "," + dob + "," + mobileNum + "," + licenceNum + "," + docSpecialisation);
        System.out.println(docArray);
//        for(int i = 0; i < 3; i++) {
//            //if(docList.get(i).getName()=="") {
//            //  System.out.println("add 3");
//
//            docList.add(new Doctor(name, surname, birthDay, mobileNum, licenceNum, docSpecialisation));
//            //System.out.println("add 4");
//
//            break;
//            //}else {
//
//            //}
//
//        }
        try {
            FileWriter writer = new FileWriter(filename);
            Writer output = new BufferedWriter(writer);
            for(int i = 0; i < docArray.size(); i++){
                output.write(docArray.get(i).toString() + "\n");
            }
            //writer.write(String.valueOf(docArray.toString().replace("[","").replace("]","")));
            output.close();
            System.out.println("Updated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delDoc(ArrayList<String> docArray) {
        int index = 0;
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
        docArray.remove(index);

        try {
            FileWriter writer = new FileWriter(filename);
            Writer output = new BufferedWriter(writer);
            for(int i = 0; i < docArray.size(); i++){
                output.write(docArray.get(i).toString() + "\n");
            }
            //writer.write(String.valueOf(docArray.toString().replace("[","").replace("]","")));
            output.close();
            System.out.println("Doctor Deleted : "+ licenceNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printDoclist(ArrayList<String> docArray) {

        ArrayList<String> details = docArray;
        details.sort(new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return filter(lhs).compareTo(filter(rhs));
            }

            private String filter(String s) {
                // consider the first comma
                return s.replaceFirst("^.*?, ", "");
                // to consider the last comma instead:
                // return s.replaceFirst("^.*, ", "");
            }
        });
        
        for(int i = 0; i < details.size(); i++){
            String data = details.get(i);
            ArrayList<String> docnames = new ArrayList<>(List.of(data.split(",")));

            System.out.println(i+1 + ") " + docnames.get(1)+ " " + docnames.get(0)+ " | Licence No: " + docnames.get(4)+ " | Mobile No: " + docnames.get(3)+ " | Specialisation: " + docnames.get(5)+ " | DOB: " + docnames.get(2));
        }
    }
}
