package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.repository.ProductRepository;

@RequestMapping("/products")
@RestController
@Validated//to add Validation on request body or path variable
public class ProductController {

	private ProductRepository prorepo;
	@GetMapping
	public ResponseEntity<?> listAllProducts()
	{
		System.out.println("List all products");
		List<Product> products = prorepo.findAll();
		//invoke service layers method contro--->service impl(p)--->Jpa impl by service
		
		return  ResponseEntity.ok(products);///status code--Ok
	}
	
	@PostMapping
	public ResponseEntity<?> addNewProduct(@RequestBody Product prod )
	{
		System.out.println("In add Products"+prod);
		return new ResponseEntity<>(prorepo.save(prod),HttpStatus.CREATED);
	}
	
}
