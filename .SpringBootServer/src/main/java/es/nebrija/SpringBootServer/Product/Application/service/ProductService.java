package es.nebrija.SpringBootServer.Product.Application.service;

import es.nebrija.SpringBootServer.Product.Application.repository.ProductRepository;
import es.nebrija.SpringBootServer.Product.Domain.Product;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;
  public void addProduct(Product product){
    productRepository.save(product);
  }

  public List<Product> getProducts(){
    return productRepository.findAll();
  }

  public Product getProductById(ObjectId product_id){
    return productRepository.findProductByProductId(product_id.toString());
 }

 public Product getProductByProductName(String product_name){
    return productRepository.findProductByProductName(product_name);
  }

  public void updateProduct(ObjectId product_id,Product product){
    boolean existProduct= productRepository.existsById(product_id.toString());

    if(existProduct){
      productRepository.save(product);
    }else {
      System.out.println("No existe");
    }
  }

}
