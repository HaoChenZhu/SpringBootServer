package es.nebrija.SpringBootServer.Shop.Application.service;

import es.nebrija.SpringBootServer.Product.Application.service.ProductService;
import es.nebrija.SpringBootServer.Product.Domain.Product;
import es.nebrija.SpringBootServer.Shop.Application.repository.ShopRepository;
import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.PostShopRequestDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ShopUpdateRequest;
import es.nebrija.SpringBootServer.Shop.Infrastructure.exceptions.ShopAlreadyExistsException;
import es.nebrija.SpringBootServer.Shop.Infrastructure.exceptions.ShopNotFoundException;
import es.nebrija.SpringBootServer.Shop.Infrastructure.mapper.ShopMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ProductService productService;


    @Override
    public List<ResponseShopDto> getAllShops() {
        return shopMapper.fromEntitiesToDto(shopRepository.findAll());
    }

    @Override
    public ResponseShopDto getShopByName(String name) throws ShopNotFoundException {
        if (!shopRepository.existsByName(name)) throw new ShopNotFoundException(name);
        Shop shop = shopRepository.findShopByName(name);

        return shopMapper.toDto(shop);
    }

    @Override
    public void addShop(PostShopRequestDto postShopRequestDto) throws ShopAlreadyExistsException {
        if (shopRepository.existsByName(postShopRequestDto.getName()))
            throw new ShopAlreadyExistsException(postShopRequestDto.getName());
        shopRepository.save(shopMapper.toEntity(postShopRequestDto));
    }

    @Override
    public void deleteShop(String name) throws ShopNotFoundException {
        if (!shopRepository.existsByName(name)) throw new ShopNotFoundException(name);
        shopRepository.delete((name));
    }

    @Override
    public void updateShop(ShopUpdateRequest shopUpdateRequest) throws ShopNotFoundException {
        boolean exist = shopRepository.existsByName(shopUpdateRequest.getName());

        if (exist) {
            Shop updateShop = shopRepository.findShopByName(shopUpdateRequest.getName());
            updateShop.setShop_img(shopUpdateRequest.getShop_img());
            updateShop.setLocation(shopUpdateRequest.getLocation());
            updateShop.setTelephone(shopUpdateRequest.getTelephone());

            shopRepository.update(updateShop);
        } else {
            throw new ShopNotFoundException(shopUpdateRequest.getName());
        }
    }

    public void addProductToShop(String name, ObjectId product_id) {
        Product product = productService.getProductById(product_id);
        Shop shop = shopRepository.findShopByName(name);
        System.out.println(shop.toString() + product.toString());
        shop.getProductList().add(product);
        shopRepository.update(shop);
    }


}
