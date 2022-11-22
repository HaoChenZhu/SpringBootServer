package es.nebrija.SpringBootServer.Shop.Application.service;

import es.nebrija.SpringBootServer.Shop.Application.repository.ShopRepository;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ShopUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.nebrija.SpringBootServer.Product.Application.service.ProductService;
import es.nebrija.SpringBootServer.Product.Domain.Product;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dao.ShopDao;
import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.mapper.ShopMapper;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
  @Autowired
  private ShopRepository shopRepository;
  @Autowired
  private ShopMapper shopMapper;
  @Autowired
  private ProductService productService;



  public List<ResponseShopDto> getAllShops(){
    return shopMapper.fromEntitiesToDto(shopRepository.findAll());
  }

  @Override
  public ResponseShopDto getShopByName(String name){
    Shop shop= shopRepository.findByName(name);
    return shopMapper.toDto(shop);
  }

  public void addShop(Shop shop){
    System.out.println(shop.toString());
    shopRepository.save(shop);
  }

  public void updateShop(String name, ShopUpdateRequest shopUpdateRequest){
    boolean exist= shopRepository.existsByName(name);
    if(exist){
      shopRepository.save(shopMapper.toEntity(shopUpdateRequest));
    }else {
      System.out.println("No existe");
    }
  }
  public void addProductToShop(String name, ObjectId product_id){
      Product product= productService.getProductById(product_id);
      Shop shop = shopRepository.findByName(name);

      shop.getProductList().add(product);
      shopRepository.save(shop);
  }




}
