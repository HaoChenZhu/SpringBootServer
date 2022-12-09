package es.nebrija.SpringBootServer.Shop.Application.service;

import es.nebrija.SpringBootServer.Product.Application.repository.ProductRepository;
import es.nebrija.SpringBootServer.Product.Application.service.ProductServiceImpl;
import es.nebrija.SpringBootServer.Product.Infrastructure.dto.ResponseProductDto;
import es.nebrija.SpringBootServer.Product.Infrastructure.mapper.ProductMapper;
import es.nebrija.SpringBootServer.Shop.Application.repository.ShopRepository;
import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.PostShopRequestDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopProductDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ShopUpdateRequest;
import es.nebrija.SpringBootServer.Shop.Infrastructure.mapper.ShopMapper;
import es.nebrija.SpringBootServer.exceptions.NotValuesException;
import es.nebrija.SpringBootServer.exceptions.ProductNotFoundException;
import es.nebrija.SpringBootServer.exceptions.ShopAlreadyExistsException;
import es.nebrija.SpringBootServer.exceptions.ShopNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductServiceImpl productServiceImpl;


    @Override
    public List<ResponseShopDto> getAllShops() throws NotValuesException {
        if(shopRepository.findAll().size()<=0) throw new NotValuesException();
        return shopMapper.fromEntitiesToDto(shopRepository.findAll());
    }

    @Override
    public ResponseShopDto getShopByName(String name) throws ShopNotFoundException {
        if (!shopRepository.existsByName(name)) throw new ShopNotFoundException(name);
        Shop shop = shopRepository.findShopByName(name);

        return shopMapper.toDto(shop);
    }

    @Override
    public ResponseShopProductDto getShopProductByName(String name) throws ShopNotFoundException {
        if (!shopRepository.existsByName(name)) throw new ShopNotFoundException(name);
        Shop shop = shopRepository.findShopByName(name);
        return shopMapper.fromEntitiesToDto(shop);

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

    @Override
    public void addProductToShop(String name, String product_name) throws ShopNotFoundException, ProductNotFoundException {
        boolean exist = shopRepository.existsByName(name);
        boolean existProduct = productRepository.existsByName(product_name);
        if (!exist) throw new ShopNotFoundException(name);
        if (!existProduct) throw new ProductNotFoundException(product_name);
        ResponseProductDto product = productServiceImpl.getProductByName(product_name);
        Shop shop = shopRepository.findShopByName(name);

        shop.getProductList().add(productMapper.toEntity(product));
        shopRepository.update(shop);
    }


}
