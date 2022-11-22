package es.nebrija.SpringBootServer.Shop.Application.service;


import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ShopUpdateRequest;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public interface ShopService  {
    ResponseShopDto getShopByName(String name);

    List<ResponseShopDto> getAllShops();

    void updateShop(String name, ShopUpdateRequest shopUpdateRequest);

}
