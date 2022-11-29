package es.nebrija.SpringBootServer.Shop.Infrastructure.dto;

import es.nebrija.SpringBootServer.Shop.Domain.Location;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ShopUpdateRequest {
    @NotNull
    private String name;
    @NotNull
    private String telephone;
    @NotNull
    private Location location = new Location();
    @NotNull
    private String shop_img;
}
