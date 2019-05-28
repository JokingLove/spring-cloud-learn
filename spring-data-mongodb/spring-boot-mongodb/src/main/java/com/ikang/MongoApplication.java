package com.ikang;

import com.ikang.entity.Customer;
import com.ikang.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public MongoApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        // delete all
        customerRepository.deleteAll();

        // save a couple of customers
        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("查询所有的 customer 信息：");
        customerRepository.findAll().forEach(System.out::println);
        System.out.println();

        // findByFirstName
        System.out.println(customerRepository.findByFirstName("Bob"));

        // findByLastName

        customerRepository.findByLastName("Smith").forEach(System.out::println);

        // findByFirstNameAndLastName
        System.out.println("findByFirstNameAndLastName 查询结果：");
        System.out.println(customerRepository.findByFirstNameAndLastName("Bob", "Smith"));


        // test
        System.out.println("test method 结果：");
        System.out.println(customerRepository.test("Alice"));
    }
}
