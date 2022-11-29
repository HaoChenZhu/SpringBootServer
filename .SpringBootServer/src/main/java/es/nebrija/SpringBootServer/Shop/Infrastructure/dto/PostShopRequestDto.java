package es.nebrija.SpringBootServer.Shop.Infrastructure.dto;

import es.nebrija.SpringBootServer.Shop.Domain.Location;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class PostShopRequestDto {
    @NotNull(message = "El nombre no puede ser nulo")
    private String name;
    @NotNull(message = "El telefono no puede ser nulo")
    private String telephone;
    @NotNull(message = "La localizacion no puede ser nulo")
    private Location location = new Location();
    @NotNull(message = "La imagen no puede ser nulo")
    private String shop_img;
}
