package es.nebrija.SpringBootServer.Shop.Application.service;


import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.PostShopRequestDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ShopUpdateRequest;

import java.util.List;

public interface ShopService {
    ResponseShopDto getShopByName(String name);

    List<ResponseShopDto> getAllShops();

    void updateShop(ShopUpdateRequest shopUpdateRequest);

    void addShop(PostShopRequestDto postShopRequestDto);

    void deleteShop(String name);

}
