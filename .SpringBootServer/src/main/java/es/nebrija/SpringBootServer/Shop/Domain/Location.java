package es.nebrija.SpringBootServer.Shop.Domain;

import lombok.Data;

@Data
public class Location {
  private String country;
  private String address;
  private String city;
  private String province;
  private String code;

}
