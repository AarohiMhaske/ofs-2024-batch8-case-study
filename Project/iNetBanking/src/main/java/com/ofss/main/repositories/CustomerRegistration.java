package com.ofss.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Customer;

@Repository
public interface CustomerRegistration extends CrudRepository<Customer, Integer> {

}
