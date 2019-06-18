package com.ikang.repository;

import com.ikang.entity.Customer;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);

    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

/*    @Query("SELECT * from customer u where u.firstName=:firstName")
    Customer test(@Param("firstName") String firstName);*/

}
