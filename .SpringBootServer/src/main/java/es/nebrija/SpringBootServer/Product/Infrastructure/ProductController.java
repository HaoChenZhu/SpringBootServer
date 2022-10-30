package es.nebrija.SpringBootServer.Product.Infrastructure;


import es.nebrija.SpringBootServer.Product.Application.ProductService;
import es.nebrija.SpringBootServer.Product.Domain.Product;
import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/server/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping
  private void addShop(@RequestBody Product product) {
    System.out.println("Hola");
    productService.addProduct(product);
  }
  @GetMapping
  private List<Product> getProducts(){
    return productService.getProducts();
  }
  @GetMapping("/{id}")
  private Optional<Product> getProductById(@PathVariable(value = "id") String product_id){
    ObjectId id = new ObjectId(product_id);
    return productService.getProductById(id);
  }
 /* @GetMapping("/product/name/{name}")
  private Optional<Product> getProductByName(@PathVariable(value = "name") String product_name){
    return productService.getProductByName(product_name);
  }*/

  @PutMapping("/{id}")
  private void updateProductById(@PathVariable(value = "id") String product_identifier, Product product){
    ObjectId id= new ObjectId(product_identifier);
    productService.updateProduct(id,product);
  }

}
