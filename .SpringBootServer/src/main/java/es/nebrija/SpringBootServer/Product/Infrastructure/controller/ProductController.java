package es.nebrija.SpringBootServer.Product.Infrastructure.controller;


import es.nebrija.SpringBootServer.Product.Application.service.ProductService;
import es.nebrija.SpringBootServer.Product.Infrastructure.dto.PostProductRequestDto;
import es.nebrija.SpringBootServer.Product.Infrastructure.dto.ResponseProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/server/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    private void addProduct(@RequestBody PostProductRequestDto product) {
        productService.addProduct(product);
    }

    @GetMapping
    private ResponseEntity<List<ResponseProductDto>> getProducts() {

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    private ResponseEntity<ResponseProductDto> getProductByName(@PathVariable(value = "name") String product_name) {
        return new ResponseEntity<>(productService.getProductByName(product_name), HttpStatus.OK);
    }

    @GetMapping("/identifier/{id}")
    private ResponseEntity<ResponseProductDto> getProductById(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private void updateProductById(@PathVariable(value = "id") String product_identifier, @RequestBody PostProductRequestDto postProductRequestDto) {

        productService.updateProduct(product_identifier, postProductRequestDto);
    }

    @DeleteMapping("/{id}")
    private void deleteProductById(@PathVariable(value = "id") String product_identifier) {
        productService.deleteProduct(product_identifier);
    }

}
