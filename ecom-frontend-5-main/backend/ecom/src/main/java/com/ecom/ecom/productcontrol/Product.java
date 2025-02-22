package com.ecom.ecom.productcontrol;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.ecom.entity.Productsmodel;
import com.ecom.ecom.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class Product {

	@Autowired
	private ProductService productservices;
	@GetMapping("/products")
	
	public ResponseEntity<List<Productsmodel>> getProducts() {
		return new ResponseEntity<>(productservices.getAllProducts(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Productsmodel> getProductbyid(@PathVariable int id){
	   
		Productsmodel product =productservices.getproductbyid(id);
		if(product.getId()>0) {
			
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("product/{productId}/image")
	public ResponseEntity<byte[]> getImageByproductid(@PathVariable int productId){
		Productsmodel product=productservices.getproductbyid(productId);
		if(product.getId()>0) {
			return new ResponseEntity<>(product.getImageData(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	  
	}
	@PostMapping("/product")
	public ResponseEntity<?> addproduct(@RequestPart Productsmodel product,@RequestPart MultipartFile imageFile){
		
		 Productsmodel saved=null;
		try {
			saved = productservices.addproduct(product,imageFile);
			 return new ResponseEntity<>(saved,HttpStatus.CREATED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Productsmodel product,@RequestPart MultipartFile imageFile){
		Productsmodel updateproduct=null;
		
		try {
			updateproduct=productservices.updateproduct(product,imageFile);
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		
		catch(IOException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteproduct(@PathVariable int id){
		Productsmodel product=productservices.getproductbyid(id);
		if(product !=null) {
			productservices.deleteproduct(id);
			return new ResponseEntity<>("deleted",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<List<Productsmodel>> search(@RequestParam String keyword) {
	    List<Productsmodel> products = productservices.searchproducts(keyword);
	    
	    if (products.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    System.out.println("Searching with keyword: " + keyword);
	    return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
