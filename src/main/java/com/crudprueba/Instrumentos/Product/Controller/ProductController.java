package com.crudprueba.Instrumentos.Product.Controller;

import com.crudprueba.Instrumentos.Product.Domain.ProductDomain;
import com.crudprueba.Instrumentos.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/CRUD/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDomain> getProducts() {
        return this.productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> registerProducts(@RequestBody ProductDomain productDomain) {
//    public void registerProducts(@RequestBody Product product){
        return this.productService.postProduct(productDomain);
    }

    @PutMapping
    public ResponseEntity<Object> updateProducts(@RequestBody ProductDomain productDomain) {
        return this.productService.putProduct(productDomain);
    }

//    @DeleteMapping
//    public ResponseEntity<Object> deleteProducts(@RequestBody ProductDomain productDomain) {
//        return this.productService.deleteProduct(productDomain);
//    }

    @DeleteMapping (path = "{productId}")
    public ResponseEntity<Object> deleteProducts(@PathVariable("productId") long id) {
        return this.productService.deleteProduct(id);
    }



}
