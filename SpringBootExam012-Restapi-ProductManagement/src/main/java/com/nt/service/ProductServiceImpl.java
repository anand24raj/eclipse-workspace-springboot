package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.entity.Product;
import com.nt.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product updateProduct(Long id, Product product) {

		Product existingProduct = productRepository.findById(id).orElse(null);

		if (existingProduct != null) {
			existingProduct.setName(product.getName());
			existingProduct.setCategory(product.getCategory());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setStockQuantity(product.getStockQuantity());
			existingProduct.setBrand(product.getBrand());

			return productRepository.save(existingProduct);
		}

		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}