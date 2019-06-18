package com.ikang.repository;

import com.ikang.entity.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Repository
public class CustomerRepository2 {

    private final MongoOperations mongoTemplate;

    public CustomerRepository2(MongoOperations mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public List<Customer> findByFirstName(String firstName) {
        Criteria criteria = where("firstName").is(firstName);
        return mongoTemplate.find(query(criteria), Customer.class);
    }

    public long count() {
        return mongoTemplate.count(query(where(null)), Customer.class);
    }

    public Map<String, Object> test() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.project("", ""));
        mongoTemplate.aggregate(aggregation, Customer.class);
        return null;
    }
}
