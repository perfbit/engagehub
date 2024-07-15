package com.engagehub.api.customer.dgs;

import com.engagehub.api.model.Customer;
import com.engagehub.api.customer.service.CustomerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class CustomerDataFetcher {

    private final CustomerService customerService;

    public CustomerDataFetcher(CustomerService customerService) {
        this.customerService = customerService;
    }

    @DgsQuery
    public List<Customer> customers() {
        return customerService.findAllCustomers();
    }

    @DgsQuery
    public Optional<Customer> customerById(@InputArgument Long id) {
        return customerService.findCustomerById(id);
    }

    @DgsQuery
    public List<Customer> searchCustomers(
            @InputArgument String name,
            @InputArgument String email,
            @InputArgument String phoneNumber) {
        return customerService.searchCustomers(name, email, phoneNumber);
    }

    @DgsMutation
    public Customer addCustomer(@InputArgument String name,
                                @InputArgument String email,
                                @InputArgument String phoneNumber) {
        Customer customer = new Customer(null, name, email, phoneNumber);
        return customerService.saveCustomer(customer);
    }

    @DgsMutation
    public Customer updateCustomer(@InputArgument Long id,
                                   @InputArgument String name,

