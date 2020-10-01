import java.util.ArrayList;
import java.util.Scanner;

public class MainDriver {

    private ArrayList<Customer> customerArrayList;
    private ArrayList<Insurance> insuranceArrayList;
    private Customer currentCustomer;
    private static Scanner scanner;
    IOUtils handleFiles = new IOUtils();

    public MainDriver() {

        //load saved customer array list
        try {
            ArrayList<Customer> customerArrayListSaved = handleFiles.readCustomerArrayListFromFle("Insurance.save");
            if(customerArrayListSaved!=null)
                this.customerArrayList = customerArrayListSaved;
            else
                this.customerArrayList = new ArrayList<Customer>();
        }
        catch (Exception e){
            System.out.println("Invalid Input");
        }

        this.insuranceArrayList = new ArrayList<Insurance>();
        scanner = new Scanner(System.in);

        //insurance services
        this.insuranceArrayList.add(new Insurance(1, "Health Insurance", 5000, true));
        this.insuranceArrayList.add(new Insurance(2, "Vehicle Insurance", 2000, false));
        this.insuranceArrayList.add(new Insurance(3, "Site Insurance", 6000, false));
    }

    public void mainMenu(){
        System.out.println("Welcome to Insurance System\n" +
                "Please enter your selection...\n" +
                "1) Customer Login \n" +
                "2) Register New Customer \n" +
                "3) exit \n");
    }

    public void afterLoginMenu(){
        System.out.println("Welcome "+this.currentCustomer.getCustomerName()+"\n"+
                "Please enter your selection...\n" +
                "1) View Subscribed Insurances \n" +
                "2) Add new Insurance \n" +
                "3) back \n");
    }

    public void run(){
        boolean run =true;

        while (run) {
            this.mainMenu();
            int mainSelection = scanner.nextInt();
            scanner.nextLine();

            if (mainSelection == 1) {

                int status = this.logInCustomer();

                if(status>0) {

                    boolean runAfterLoginMenu = true;
                    while (runAfterLoginMenu) {


                        this.afterLoginMenu();
                        int afterLoginSelection = scanner.nextInt();
                        scanner.nextLine();

                        if (afterLoginSelection == 1) {
                            this.currentCustomer.viewInsurance();
                        } else if (afterLoginSelection == 2) {
                            this.addInsuranceToCurrentCustomer();
                        } else if (afterLoginSelection == 3) {
                            runAfterLoginMenu = false;
                        }
                    }
                }

            } else if (mainSelection == 2) {
                this.addCustomer();
            }
            if (mainSelection == 3) {
                handleFiles.writeInsuranceToFile(this.customerArrayList);
                run=false;
            }
        }
    }

    public void addCustomer() {
        System.out.println("Please Enter Name: ");
        String name = scanner.nextLine();
        this.currentCustomer = new Customer(name);

        System.out.println("Please Enter New User Name: ");
        String userName = scanner.nextLine();
        System.out.println("Please Enter New User Password: ");
        String passWord = scanner.nextLine();
        this.currentCustomer.setUserName(userName);
        this.currentCustomer.setUserPassword(passWord);

        System.out.println("Please Enter Your Age: ");
        int age = scanner.nextInt();
        this.currentCustomer.setAge(age);
        scanner.nextLine();

        System.out.println("Please Enter Your Annual income in USD: ");
        double annualIncome = scanner.nextDouble();
        this.currentCustomer.setAnnualIncomeInUsd(annualIncome);
        scanner.nextLine();

        this.customerArrayList.add(this.currentCustomer);


    }

    public int logInCustomer() {
        System.out.println("Please Enter User Name:");
        String userName = scanner.nextLine();
        System.out.println("Password Please: ");
        String userPassword = scanner.nextLine();

        if (checkLogin(userName, userPassword) == null) {
            System.out.println("Invalid User Name or Password !");
            return -1;
        } else {
            this.currentCustomer = checkLogin(userName, userPassword);
//            System.out.println("Welcome "+this.currentCustomer.getCustomerName());
            return 1;
        }
    }

    private Customer checkLogin(String userName, String passWord) {
        for (int i = 0; i < this.customerArrayList.size(); i++) {
            if (this.customerArrayList.get(i).getUserName().equals(userName) &&
                    this.customerArrayList.get(i).getUserPassword().equals(passWord)) {
                return this.customerArrayList.get(i);
            }
        }
        return null;
    }

    public void addInsuranceToCurrentCustomer() {
        System.out.println("List of available Insurances for you..");

        for (int i = 0; i < this.insuranceArrayList.size(); i++) {
            System.out.println(this.insuranceArrayList.get(i).toString());
        }

        System.out.println("Enter your preferred id to add:");
        int enteredId=scanner.nextInt();
        scanner.nextLine();
        this.currentCustomer.getInsuranceArrayList().add(getInsuranceFromId(enteredId));

    }

    private Insurance getInsuranceFromId(int id){
        for (int i = 0; i < this.insuranceArrayList.size(); i++) {
            if (this.insuranceArrayList.get(i).getInsuranceId()==id) {
                return this.insuranceArrayList.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MainDriver mainDriver=new MainDriver();
        mainDriver.run();
    }
}
