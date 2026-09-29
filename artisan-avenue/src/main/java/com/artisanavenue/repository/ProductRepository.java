package com.artisanavenue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artisanavenue.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Spring Data JPA provides all the required CRUD methods automatically

}


//Because we write:
//
//public interface ProductRepository extends JpaRepository<Product, Long>
//
//we don't need to manually write SQL queries like SELECT * FROM products or INSERT INTO products.
//
//Benefit of Abstraction / Interface:
//We just use ready-made methods such as findAll(), save(), and deleteById().
//
//Behind the scenes, Spring Data JPA and Hibernate automatically create the required SQL queries and execute them in the database.