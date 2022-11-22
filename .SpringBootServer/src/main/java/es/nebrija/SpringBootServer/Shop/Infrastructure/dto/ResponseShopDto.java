package es.nebrija.SpringBootServer.Shop.Infrastructure.dto;

import es.nebrija.SpringBootServer.Shop.Domain.Location;
import lombok.Data;

@Data
public class ResponseShopDto {

    private String name;
    private String telephone;
    private Location location;
    private String shop_img;

}
