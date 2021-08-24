package com.fahrul.springjpapaginationsorting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fahrul.springjpapaginationsorting.entity.Product;
import com.fahrul.springjpapaginationsorting.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}

	public List<Product> findProductWithSorting(String field) {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	public Page<Product> findProductWithPagination(int offset, int pageSize) {
		Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
		return products;
	}

	public Page<Product> findProductWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		return products;
	}

}
