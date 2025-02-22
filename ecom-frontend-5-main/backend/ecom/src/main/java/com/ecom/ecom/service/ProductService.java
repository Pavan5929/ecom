package com.ecom.ecom.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.ecom.entity.Productsmodel;
import com.ecom.ecom.repo.ProductRepo;
@Service
public class ProductService {

	@Autowired
	private ProductRepo productrepo;
	public List<Productsmodel>  getAllProducts(){
		
		return productrepo.findAll();
	}
	
	public Productsmodel getproductbyid(int id) {
		return productrepo.findById(id).orElse(null);
	}
	
	public Productsmodel addproduct(Productsmodel product,MultipartFile image) throws IOException {
		product.setImagename(image.getOriginalFilename());
		product.setImagetype(image.getContentType());
		product.setImageData(image.getBytes());
		return productrepo.save(product);
	}
	
	public Productsmodel updateproduct(Productsmodel product,MultipartFile image) throws IOException {
		
		product.setImagename(image.getOriginalFilename());
		product.setImagetype(image.getContentType());
		product.setImageData(image.getBytes());
		return productrepo.save(product);
	}
	
	public void deleteproduct(int id) {
		productrepo.deleteById(id);
	}

	public List<Productsmodel> searchproducts(String keyword) {
		// TODO Auto-generated method stub
		return productrepo.searchproducts(keyword);
	}
}
