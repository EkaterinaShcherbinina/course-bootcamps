package com.shcherbinina.simplesbapp.repositories;

import com.shcherbinina.simplesbapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Optional;

public class CustomJdbcRepositoryImpl implements CustomJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Customer customerById(int id) {
        return jdbcTemplate.queryForObject("select * from customer where id = ?",
                (rs, rowNum) ->
                        Optional.of(new Customer(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone_number"),
                                rs.getString("email")
                        )),
                new Object[]{id}).get();
    }
}
