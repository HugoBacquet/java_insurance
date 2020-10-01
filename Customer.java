import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    private String customerName;
    private int age;
    private String userName;
    private String userPassword;
    private double annualIncomeInUsd;
    private ArrayList<Insurance> insuranceArrayList;

    public Customer(String customerName) {
        this.customerName = customerName;
        insuranceArrayList=new ArrayList<Insurance>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public ArrayList<Insurance> getInsuranceArrayList() {
        return insuranceArrayList;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAnnualIncomeInUsd() {
        return annualIncomeInUsd;
    }

    public void setAnnualIncomeInUsd(double annualIncomeInUsd) {
        this.annualIncomeInUsd = annualIncomeInUsd;
    }

    public void addInsurance(Insurance insurance){
        insuranceArrayList.add(insurance);
    }

    public void viewInsurance(){
        if(insuranceArrayList.size()==0){
            System.out.println("Currently You Have No Any Subscriptions !");
        }
        else {
            for (int i = 0; i < insuranceArrayList.size(); i++) {
                System.out.println(insuranceArrayList.get(i).toString() + "\n");
            }
        }
    }
}
