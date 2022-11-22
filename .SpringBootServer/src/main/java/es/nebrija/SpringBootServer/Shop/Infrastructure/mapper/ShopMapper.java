package es.nebrija.SpringBootServer.Shop.Infrastructure.mapper;

import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ShopUpdateRequest;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ShopMapper {

    Shop toEntity(ResponseShopDto responseShopDto);
    Shop toEntity(ShopUpdateRequest shopUpdateRequest);
    ResponseShopDto toDto(Shop shop);
    List<ResponseShopDto> fromEntitiesToDto(List<Shop> shops);
}


