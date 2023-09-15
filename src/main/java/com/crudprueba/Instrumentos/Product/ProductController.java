package com.crudprueba.Instrumentos.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/CRUD/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return this.productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> registerProducts(@RequestBody Product product) {
//    public void registerProducts(@RequestBody Product product){
        return this.productService.postProduct(product);
    }

    @PutMapping
    public ResponseEntity<Object> updateProducts(@RequestBody Product product) {
        return this.productService.putProduct(product);
    }

//    @DeleteMapping (path = "{productId}")
//    public ResponseEntity<Object> deleteProducts(@PathVariable("productId") long id) {
//        return this.productService.deleteProduct(id);
//    }

    @DeleteMapping (path = "{productId}")
    public ResponseEntity<Object> deleteProducts(@RequestBody Product product) {
        return this.productService.deleteProduct(product);
    }

}
