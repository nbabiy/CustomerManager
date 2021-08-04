package com.nbabiy.customerManager.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT c FROM Customer c WHERE  c.name LIKE :keyword" +
            " OR c.email LIKE :keyword"
            + " OR c.address LIKE :keyword ORDER BY c.id")
    List<Customer> findAllByKeyword(@Param("keyword") String keyword);

}
