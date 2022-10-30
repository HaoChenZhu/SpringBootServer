package es.nebrija.SpringBootServer.Shop.Infrastructure;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Application.ShopService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/server")
public class ShopController {
  @Autowired
  private ShopService shopService;

  @PostMapping
  private void addShop(@RequestBody Shop shop) {
    shopService.addShop(shop);
  }
  @GetMapping("/{id}")
  private Optional<Shop> getShopById(@PathVariable(value = "id") String id){
    ObjectId a = new ObjectId(id);
    return shopService.getShopById(a);
  }
  @GetMapping
  private List<Shop> getShops() {
    return shopService.getAllShops();
  }

  @GetMapping("/name/{name}")
  private Optional<Shop> getShop(@PathVariable String name){
    return shopService.getShopByName(name);
  }
  @PutMapping("/{id}")
  private  void updateShop(@PathVariable(value = "id") String identifier,@RequestBody Shop shop){
    ObjectId id= new ObjectId(identifier);
    shopService.updateShop(id,shop);
  }


}
