package es.nebrija.SpringBootServer.Shop.Infrastructure.dto;

import es.nebrija.SpringBootServer.Shop.Domain.Location;
import lombok.Data;

@Data
public class ShopUpdateRequest {
    private String name;
    private String telephone;
    private Location location = new Location();
    private String shop_img;
}
