/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawid.infoGetter.model;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.NumberStringConverter;

/**
 * Data model of address, split in basic values
 * Created by Dawid on 2016-04-25.
 */
public class Address {
    private StringProperty street;
    private IntegerProperty houseNumber;
    private IntegerProperty apartmentNumber;
    private StringProperty postalCode;
    private StringProperty city;
    private StringProperty country;


    public Address() {
        this.street = new SimpleStringProperty("");
        this.houseNumber = new SimpleIntegerProperty(0);
        this.apartmentNumber = new SimpleIntegerProperty(0);
        this.postalCode = new SimpleStringProperty("");
        this.city = new SimpleStringProperty("");
        this.country = new SimpleStringProperty("");
    }

    public Address(StringProperty street, IntegerProperty houseNumber, IntegerProperty apartmentNumber, StringProperty postalCode, StringProperty city, StringProperty country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    /**
     * Way to bind bidirectional all properties of Address object
     * @param streetBind
     * @param houseNumberBind
     * @param apartmentNumberBind
     * @param postalCodeBind
     * @param cityBind
     * @param countryBind
     */
    public void bindBidirectionalAllProperties(StringProperty streetBind, StringProperty houseNumberBind, StringProperty apartmentNumberBind, StringProperty postalCodeBind, StringProperty cityBind, StringProperty countryBind){
        NumberStringConverter doNotShowZeroConverter= new NumberStringConverter(){
            @Override
            public String toString(Number value) {
                if(value.intValue()!=0)
                    return super.toString();
                else
                    return "";
            }
        };
        street.bindBidirectional(streetBind);
        Bindings.bindBidirectional(houseNumberBind, houseNumber, doNotShowZeroConverter);
        Bindings.bindBidirectional(apartmentNumberBind, apartmentNumber, doNotShowZeroConverter);
        postalCode.bindBidirectional(postalCodeBind);
        city.bindBidirectional(cityBind);
        country.bindBidirectional(countryBind);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public int getHouseNumber() {
        return houseNumber.get();
    }

    public IntegerProperty houseNumberProperty() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public int getApartmentNumber() {
        return apartmentNumber.get();
    }

    public IntegerProperty apartmentNumberProperty() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber.set(apartmentNumber);
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public StringProperty postalCodeProperty() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

}
