package com.ikang;

import com.ikang.entity.Customer;
import com.ikang.repository.CustomerRepository;
import com.ikang.repository.CustomerRepository2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final CustomerRepository2 customerRepository2;

    public MongoApplication(CustomerRepository customerRepository, CustomerRepository2 customerRepository2) {
        this.customerRepository = customerRepository;
        this.customerRepository2 = customerRepository2;
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
//        System.out.println("test method 结果：");
//        System.out.println(customerRepository.test("Alice"));

        // findByFirstName
        System.out.println("这个是通过 customerRepository2 的方法查询的结果：");
        System.out.println(customerRepository2.findByFirstName("Bob"));

        System.out.println("总数为：" + customerRepository2.count());
    }
}
