package online;

import java.lang.*;
import java.util.*;

import javax.print.DocFlavor.STRING;

import online.*;

class OnlineShop {
    private static ArrayList<Groceries> Products = new ArrayList<Groceries>();
    private static ArrayList<Customer> Users = new ArrayList<Customer>();

    public static void main(String[] args) {

        int userIp = 0;
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        Boolean bStopSignal = false;
        // entering into loop
        while (!bStopSignal) {
            System.out.println(
                    "Please select from below options: \r\n 1. Admin Login \r\n 2. Customer Login \r\n 3. Quit");
            userIp = scanner.nextInt();

            // Main menu
            switch (userIp) {
                case 1: // Admin Login
                    if (!validateAdminLogin()) {
                        System.out.println("Wrong credentails");
                        break;
                    }
                    AdminOperations();
                    break;
                case 2:
                    if (!validateCustomerLogin()) {
                        System.out.println("Wrong credentails");
                        break;
                    }
                    // CustomerOperations();
                    break;
                case 3:
                    bStopSignal = true;
                    break;
                default:
                    break;
            }
        }
    }

    private static Boolean AdminOperations() {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        int userIp = 0;
        Boolean bStopSignal = false;

        while (!bStopSignal) {

            System.out.println("Please select from below operations: ");
            System.out.println("1. Add/Update product ");
            System.out.println("2. Search existing customer ");
            System.out.println("3. Search highest priced product ");
            System.out.println("4. Products List ");
            System.out.println("5. Logout/Main menu ");

            userIp = scanner.nextInt();

            switch (userIp) {
                case 1:
                    AddProduct();
                    System.out.println("Product added successfully");
                    break;
                case 2:
                    System.out.println("Enter email address");
                    String email = scanner.next();
                    Customer cust = FindCustomer(email, 2);
                    if (cust == null) {
                        System.out.println("No customer exists with given details");
                        break;
                    }

                    System.out.println(cust.DisplayUserDetails());
                    break;
                case 3:
                    System.out.println(FindHighPricedProd());
                    break;
                case 4: // display all prod
                    DisplayProducts();
                    break;
                case 5:
                    bStopSignal = true;
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    private static Boolean AddProduct() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.println("Please provide Product Name: ");
        String ProdName = scanner.nextLine();
        System.out.println("Please provide Product Desc: ");
        String ProdDesc = scanner.nextLine();
        System.out.println("Please provide Product Quantity: ");
        int Quantity = scanner.nextInt();
        System.out.println("Please provide Product Price: ");
        float price = scanner.nextFloat();

        Groceries prod = new Groceries(ProdName, ProdDesc, Quantity, price);
        Products.add(prod);

        return true;
    }

    private static Boolean updateProduct() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.println("Please provide Product Name: ");
        String ProdName = scanner.nextLine();
        System.out.println("Please provide Product Desc: ");
        String ProdDesc = scanner.nextLine();
        System.out.println("Please provide Product Quantity: ");
        int Quantity = scanner.nextInt();
        System.out.println("Please provide Product Price: ");
        float price = scanner.nextFloat();

        Groceries prod = new Groceries(ProdName, ProdDesc, Quantity, price);
        Products.add(prod);

        return true;
    }

    private static Boolean validateAdminLogin() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.println("Please provide Admin password: ");
        String pass = scanner.nextLine();

        if (!pass.equals("admin")) {
            return false;
        }

        return true;
    }

    private static Boolean validateCustomerLogin() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        Boolean isFailed = false;
        Boolean bStopSignal = false;
        while (!bStopSignal) {
            System.out
                    .println(
                            "Select the following options: \r\n 1. Existing user login. \r\n 2. New user registratation. \r\n 3. Logout/Main menu");
            int userIp = scanner.nextInt();
            switch (userIp) {
                case 1:

                    System.out.println("Please provide your customer ID: ");
                    String CusID = scanner.next();
                    Customer Cstmer = FindCustomer(CusID, 1);

                    if (Cstmer == null) {
                        System.out.println("Invalid your customer ID: ");
                        return false;
                    }

                    System.out.println("Please provide your password: ");
                    String szPass = scanner.next();
                    if (!Cstmer.verifyPassword(szPass)) {
                        return false;
                    }

                    System.out.println("Login successfully ");
                    System.out.println(Cstmer.DisplayUserDetails());
                    break;
                case 2:
                    // take i/p from user
                    System.out.println("Please Enter your name: ");
                    String szName = scanner.next();

                    System.out.println("Please Enter your email: ");
                    String szEmail = scanner.next();

                    System.out.println("Please Enter your address: ");
                    String szAddress = scanner.next();
                    System.out.println("Please Enter your contact: ");
                    String szContact = scanner.next();
                    System.out.println("Please Enter your password: ");
                    String szPassword = scanner.next();
                    System.out.println("Please Enter your confirm password: ");
                    String szCPassword = scanner.next();

                    if (!szCPassword.equals(szPassword)) {
                        System.out.println("password doesn't match");
                        break;

                    }

                    Customer c = new Customer(szName, szEmail, szPassword, szAddress, szContact);
                    Users.add(c);
                    System.out.println("Registratation successfully ");
                    System.out.println(c.DisplayUserDetails());

                    break;
                case 3:
                    bStopSignal = true;
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    private static Customer FindCustomer(String data, int type) {

        Iterator it = Users.iterator();

        // Holds true till there is single element
        // remaining in the list
        while (it.hasNext()) {
            Customer c = (Customer) it.next();
            if (type == 1 && data.equals(c.GetCustomerID())) {
                return c;
            }

            if (type == 2 && data.equals(c.GetEmail())) {
                return c;
            }
        }

        return null;
    }

    public static void DisplayProducts() {

        System.out.println("Product ID \t\t Product Name \t\t Product Desc \t\t Quantity \t\t Price");
        if (Products.size() == 0) {
            System.out.println("No Products available");
        }

        Iterator it = Products.iterator();
        // Holds true till there is single element
        // remaining in the list
        while (it.hasNext()) {

            Groceries g = (Groceries) it.next();
            System.out.println(g.DisplayProduct());
        }
    }

    public static String FindHighPricedProd() {
        Iterator it = Products.iterator();
        Boolean bIsFirst = true;
        // Holds true till there is single element
        // remaining in the list
        Groceries High = null;
        while (it.hasNext()) {
            if (bIsFirst) {
                High = (Groceries) it.next();
                bIsFirst = false;
                continue;
            }

            Groceries g = (Groceries) it.next();
            if (g.GetProdPrice() > High.GetProdPrice()) {
                High = g;
            }
        }

        return High.DisplayProduct();
    }
};
