package com.fahrul.springjpapaginationsorting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahrul.springjpapaginationsorting.dto.APIResponse;
import com.fahrul.springjpapaginationsorting.entity.Product;
import com.fahrul.springjpapaginationsorting.service.ProductService;

@SpringBootApplication
@RestController
@RequestMapping("/products")
public class SpringJpaPaginationSortingApplication {

	@Autowired
	private ProductService productService;

	@GetMapping
	private APIResponse<List<Product>> getProducts() {
		List<Product> allProducts = productService.findAllProduct();
		return new APIResponse<>(allProducts.size(), allProducts);
	}

	@GetMapping("/{field}")
	private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
		List<Product> allProducts = productService.findProductWithSorting(field);
		return new APIResponse<>(allProducts.size(), allProducts);
	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	private APIResponse<Page<Product>> getProductWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Product> productWithPagination = productService.findProductWithPagination(offset, pageSize);
		return new APIResponse<>(productWithPagination.getSize(), productWithPagination);
	}

	@GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	private APIResponse<Page<Product>> getProductWithPaginationAndSort(@PathVariable int offset,
			@PathVariable int pageSize, @PathVariable String field) {
		Page<Product> productWithPagination = productService.findProductWithPaginationAndSorting(offset, pageSize,
				field);
		return new APIResponse<>(productWithPagination.getSize(), productWithPagination);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPaginationSortingApplication.class, args);
	}

}
