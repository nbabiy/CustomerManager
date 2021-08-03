package com.nbabiy.customerManager.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author nazariibabii
 */
@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getOne(Long id) {
        return customerRepository.getOne(id);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void update(Long id, Customer customer) {
        Customer customerUpdate = customerRepository.getOne(id);
        if (customerUpdate!=null) {
            customerUpdate.setName(customer.getName());
            customerUpdate.setEmail(customer.getEmail());
            customerUpdate.setAddress(customer.getAddress());
            customerRepository.saveAndFlush(customerUpdate);
        }
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
