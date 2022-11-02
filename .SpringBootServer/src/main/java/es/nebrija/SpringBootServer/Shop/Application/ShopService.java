package es.nebrija.SpringBootServer.Shop.Application;

import es.nebrija.SpringBootServer.Product.Application.ProductService;
import es.nebrija.SpringBootServer.Product.Domain.Product;
import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
  @Autowired
  private ShopRepository shopRepository;
  @Autowired
  private ProductService productService;
  public List<Shop> getAllShops(){
    return shopRepository.findAll();
  }

  public Optional<Shop> getShopById(ObjectId identifier){
    return  shopRepository.findById(identifier.toString());
  }
  public Shop getShopByName(String name){
    return shopRepository.findByName(name);
  }

  public Shop getShopByNameOrTelephone(String name, String telephone){
    return  shopRepository.findByNameOrTelephone(name,telephone);
  }
  public void addShop(Shop shop){
    System.out.println(shop.toString());
    shopRepository.save(shop);
  }

  public void updateShop(ObjectId identifier,Shop shop){
    boolean exist= shopRepository.existsById(identifier.toString());
    if(exist){
      shopRepository.save(shop);
    }else {
      System.out.println("No existe");
    }
  }
  public void addProductToShop(String name, ObjectId product_id){
      Product product= productService.getProductById(product_id);
      Shop shop = shopRepository.findByName(name);

      shop.getProductList().add(product);
      shopRepository.save(shop);
    System.out.println(shop);
  }




}
