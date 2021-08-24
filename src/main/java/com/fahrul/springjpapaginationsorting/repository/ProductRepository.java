package com.fahrul.springjpapaginationsorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahrul.springjpapaginationsorting.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
