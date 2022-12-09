package es.nebrija.SpringBootServer.Shop.Infrastructure.mapper;

import es.nebrija.SpringBootServer.Product.Domain.Product;
import es.nebrija.SpringBootServer.Product.Infrastructure.dto.ResponseProductDto;
import es.nebrija.SpringBootServer.Shop.Domain.Shop;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.PostShopRequestDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopDto;
import es.nebrija.SpringBootServer.Shop.Infrastructure.dto.ResponseShopProductDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface  ShopMapper {
    Shop toEntity(PostShopRequestDto postShopRequestDto);

    ResponseShopDto toDto(Shop shop);

    //ResponseShopProductDto fromEntitiesToDto(Shop shop);

    List<ResponseShopDto> fromEntitiesToDto(List<Shop> shops);


    default ResponseShopProductDto fromEntitiesToDto(Shop shop){
        ResponseShopProductDto responseShopProductDto= new ResponseShopProductDto();
        List<ResponseProductDto> list= new ArrayList<>();
        responseShopProductDto.setName(shop.getName());
        for (Product product: shop.getProductList()) {
            ResponseProductDto responseProductDto=new ResponseProductDto();
            responseProductDto.setPrice(product.getPrice());
            responseProductDto.setProductCategory(product.getProductCategory());
            responseProductDto.setProductDescription(product.getProductDescription());
            responseProductDto.setProductImg(product.getProductImg());
            responseProductDto.setProductDetail(product.getProductDetail());
            responseProductDto.setProductName(product.getProductName());

            list.add(responseProductDto);

        }
        responseShopProductDto.setList(list);
        return responseShopProductDto;

    }
}


