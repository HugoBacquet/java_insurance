import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOUtils {

    private static Scanner scanner= new Scanner(System.in);

    public void writeInsuranceToFile(ArrayList<Customer> customerArrayList){
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("Insurance.save");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(customerArrayList);
            fout.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<Customer> readCustomerArrayListFromFle(String filename){
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(new File(filename));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read object
            ArrayList<Customer> customerArrayList = (ArrayList<Customer>) oi.readObject();

            oi.close();
            fi.close();
            return customerArrayList;
        } catch (FileNotFoundException e) {
            System.out.println("No any saved information");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

}
