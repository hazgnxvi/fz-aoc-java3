import java.util.Scanner;

import dao.CustomerDao;
import dao.ProductDao;
import models.Customer;
import models.Product;
import services.Product.ProductService;
import services.Product.ProductServiceImp;
import services.customer.CustomerService;
import services.customer.CustomerServiceImp;

// import services.Menus;

public class App {

    private static void showApp() {
        System.out.println("""
                === SISTEM PRODUCT App ===

                ---Customers Menu---
                1. Register Customer
                2. Show All Customer
                3. Show Customer
                4. Update Customer
                5. Delete Customer
                --------------------

                ---Product Menu---
                6. Add Product
                7. Show All Product
                8. Show Product
                ------------------

                ---Transaction---
                8. Add Transaction
                9. Show All Transaction
                10. Show Transaction
                -----------------

                ---Order Menu---
                11. Add Order
                12. Show All Order
                13. Show Order
                ----------------
                """);

        // 1. Customers
        // 2. Order
        // 3. Product
        // 4. Transaction
        // 5. Exit
        System.out.print("select menu : ");
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Boolean isRetryMenu = true;

        CustomerDao customerDao = new CustomerDao();
        CustomerService customerService = new CustomerServiceImp(customerDao);

        ProductDao productDao = new ProductDao();
        ProductService productService = new ProductServiceImp(productDao);

        // Menus menus = new Menus();
        try {
            do {
                showApp();
                String selectMenu = input.nextLine();
                switch (selectMenu) {
                    case "1":
                        System.out.println();
                        // menus.menuCustomer();
                        System.out.println("+++ Register Customer +++");

                        // input
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
                        System.out.println();
                        System.out.println("+++ List Customer +++");

                        customerService.showAllCustomer();
                        break;

                    case "3":
                        System.out.println();
                        System.out.println("+++ Find Customer By Number");

                        System.out.print("input no : ");
                        Integer idFind = input.nextInt();

                        customerService.showCustomerById(idFind);
                        input.nextLine();
                        break;

                    case "4":
                        System.out.println();
                        System.out.println("+++ Update Customer By Number");

                        System.out.print("input no : ");
                        Integer idUpdate = input.nextInt();
                        input.nextLine();

                        System.out.print("Input Fisrtname : ");
                        String fNameUpdate = input.nextLine();
                        System.out.print("Input Lastname : ");
                        String lNameUpdate = input.nextLine();
                        System.out.print("Input Email : ");
                        String emailUpdate = input.nextLine();

                        Customer customerUpdate = new Customer(emailUpdate, fNameUpdate, lNameUpdate);

                        customerService.updateCustomerById(idUpdate, customerUpdate);
                        break;

                    case "5":
                        System.out.println();
                        System.out.println("+++ Delete Customer By Number");

                        System.out.print("input no : ");
                        Integer idDelete = input.nextInt();

                        customerService.deleteCustomerById(idDelete);
                        input.nextLine();
                        break;

                    case "6":
                        System.out.println();
                        System.out.println("+++ Add Product +++");

                        // input
                        System.out.print("Input Name : ");
                        String pName = input.nextLine();
                        System.out.print("Input Description : ");
                        String pDesc = input.nextLine();
                        System.out.print("Input Price : ");
                        Double pPrice = input.nextDouble();
                        System.out.print("Input Quantity : ");
                        Integer pQuantity = input.nextInt();

                        Product product = new Product(pName, pDesc, pPrice, pQuantity);

                        productService.addProduct(product);
                        input.nextLine();
                        break;

                    case "7":
                        System.out.println();
                        System.out.println("+++ List Products +++");

                        productService.showAllProduct();
                        break;

                    case "8":
                        System.out.println();
                        System.out.println("+++ Find Product By Number");

                        System.out.print("input no : ");
                        Integer idProduct = input.nextInt();
                        input.nextLine();

                        productService.showProductById(idProduct);
                        break;

                    // case "5":
                    // System.out.println("Thank you for using this application");
                    // isRetryMenu = false;
                    // break;
                    default:
                        System.out.println("Menu Doesn't Exits!");
                        break;
                }

                while (true) {
                    System.out.print("\nWant to Retry Menu? (y|n) : ");
                    String answer = input.nextLine();

                    if ("y".equalsIgnoreCase(answer)) {
                        System.out.println();
                        break;
                    } else if ("n".equalsIgnoreCase(answer)) {
                        System.out.println("Thank you for using this application");
                        isRetryMenu = false;
                        break;
                    } else {
                        System.out.println("Wrong Input!");
                        continue;
                    }

                }
            } while (isRetryMenu);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }

}
