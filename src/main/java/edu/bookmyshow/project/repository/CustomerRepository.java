package edu.bookmyshow.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bookmyshow.project.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
