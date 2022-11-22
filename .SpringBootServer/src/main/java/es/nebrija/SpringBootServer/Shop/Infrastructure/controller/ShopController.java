package es.nebrija.SpringBootServer.Shop.Infrastructure.controller;

import es.nebrija.SpringBootServer.Shop.Application.repository.ShopRepository;
import es.nebrija.SpringBootServer.Shop.Application.repository.ShopRepositoryImpl;
import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Application.service.ShopServiceImpl;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ShopUpdateRequest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/server")
public class ShopController {
  @Autowired
  private ShopServiceImpl shopServiceImpl;


  @PostMapping
  private void addShop(@RequestBody Shop shop) {
    shopServiceImpl.addShop(shop);
  }
  @PostMapping("/addProduct/{name}/{idProduct}")
  public void addProduct(@PathVariable(value = "idProduct")String productId, @PathVariable(value = "name") String name){
    ObjectId id= new ObjectId(productId);
    shopServiceImpl.addProductToShop(name,id);
  }

  @GetMapping
  private List<ResponseShopDto> getShops() {
    return shopServiceImpl.getAllShops();
  }
  @GetMapping("/name/{name}")
  private ResponseShopDto getShop(@PathVariable String name){
    ResponseShopDto responseShopDto= shopServiceImpl.getShopByName(name);
    return responseShopDto;
  }
  @PutMapping("/{name}")
  private  void updateShop(@PathVariable(value = "name") String name,@RequestBody ShopUpdateRequest shop){
    shopServiceImpl.updateShop(name,shop);
  }


}
