package es.nebrija.SpringBootServer.Product.Application;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public Optional<Product> getProductById(ObjectId product_id){
    return productRepository.findById(product_id.toString());
  }

/*  public Optional<Product> getProductByName(String product_name){
    return productRepository.findByproduct_name(product_name);
  }*/

  public void updateProduct(ObjectId product_id,Product product){
    boolean existProduct= productRepository.existsById(product_id.toString());

    if(existProduct){
      productRepository.save(product);
    }else {
      System.out.println("No existe");
    }
  }

}
