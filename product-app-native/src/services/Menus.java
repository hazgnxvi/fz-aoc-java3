package services;

import java.util.Scanner;

import dao.CustomerDao;
import models.Customer;
import services.customer.CustomerService;
import services.customer.CustomerServiceImp;

// tidak jadi pakai karena nilai akan terseret jika method sudah tidak dijalankan

public class Menus {
    public void menuCustomer() {
        Scanner input = new Scanner(System.in);
        Boolean isRetry = true;

        CustomerDao customerDao = new CustomerDao();
        CustomerService customerService = new CustomerServiceImp(customerDao);

        try {
            do {
                System.out.println("""
                        Customer Menu :
                        1. Register Customer
                        2. Show All Customer
                        3. Show Customer
                        4. Delete Customer
                        """);
                System.out.print("Select Menu Customer :");

                String selectMnu = input.nextLine();

                switch (selectMnu) {
                    case "1":
                        System.out.println("\n+++ Register Customer +++");

                        System.out.print("Input Fisrtname : ");
                        String fName = input.nextLine();
                        System.out.print("Input Lastname : ");
                        String lName = input.nextLine();
                        System.out.print("Input Email : ");
                        String email = input.nextLine();

                        // instance obj customer
                        Customer customer = new Customer(email, fName, lName);

                        customerService.registerCustomer(customer);
                        break;
                    case "2":
                        System.out.println("\n+++ List Customer +++");
                        customerService.showAllCustomer();
                        break;

                    default:
                        System.out.println("Menu Doesn't Exits!");
                        break;
                }

                while (true) {
                    System.out.print("Want Back to Menu App? (y|n) : ");
                    String answer = input.nextLine();

                    if ("y".equalsIgnoreCase(answer)) {
                        System.out.println();
                        isRetry = false;
                        break;
                    } else if ("n".equalsIgnoreCase(answer)) {
                        break;
                    } else {
                        System.out.println("Wrong Input!");
                        continue;
                    }
                }
            } while (isRetry);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            input.close();
        }
    }
}
