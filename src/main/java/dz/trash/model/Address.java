package dz.trash.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Address {
    @Id
    @GeneratedValue

    private int address_id;


    private float latitude;
    private float longitude;

    @NotBlank
    private String street;
    @NotBlank
    private String city;

    @NotBlank
    private String country;



    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }



    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }



    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address(int address_id, float latitude, float longitude, String street, String city, String country){
        this.address_id = address_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.city = city;
        this.country = country;
    }
    public Address (){

    }
    public Address( float latitude, float longitude, String street, String city, String country){
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.city = city;
        this.country = country;
    }
    
    
    public boolean equals(Address o_address){
        return o_address.latitude==this.latitude && o_address.longitude ==this.longitude && o_address.street.equals(this.street) && o_address.city == this.city && this.country==country;
    }

    public String toString(){
        return ""+this.latitude+" "+this.longitude +"";
    }
}
