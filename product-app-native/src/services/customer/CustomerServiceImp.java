package services.customer;

import java.util.List;
import java.util.Objects;

import dao.CustomerDao;
import models.Customer;

public class CustomerServiceImp implements CustomerService {
    CustomerDao customerDao;

    public CustomerServiceImp(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void registerCustomer(Customer customer) {
        // cek null customer
        if (Objects.isNull(customer)) {
            throw new RuntimeException("Customer can't be null!");
        }

        // save data to dao/static list customer array
        customerDao.add(customer);
        System.out.println("Success Register!");
    }

    @Override
    public void showAllCustomer() {
        List<Customer> customers = customerDao.findAll();

        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i));
        }
    }

    @Override
    public void showCustomerById(Integer id) {
        if (id > customerDao.size()) {
            throw new RuntimeException("No customer is not found!");
        }

        Customer customer = customerDao.findById(id);
        System.out.println(customer);
    }

    @Override
    public void updateCustomerById(Integer id, Customer customer) {
        if (id > customerDao.size()) {
            throw new RuntimeException("No customer is not found!");
        }

        customerDao.updataById(id, customer);
        System.out.println("Update Success");
    }

    @Override
    public void deleteCustomerById(Integer id) {
        if (id > customerDao.size()) {
            throw new RuntimeException("No customer is not found!");
        }

        customerDao.deleteById(id);
        System.out.println("Delete Success");

    }

}
