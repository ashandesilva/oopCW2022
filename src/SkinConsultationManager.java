import java.util.ArrayList;

public interface SkinConsultationManager {

    //read the file and get the array of doctors and add, del, print it


    public void updateDoclist(ArrayList<String> list);

    public void delDoc(ArrayList<String> list);
    public void printDoclist(ArrayList<String> list);
}
