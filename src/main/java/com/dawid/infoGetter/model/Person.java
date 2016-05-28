/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawid.infoGetter.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Data model of personal data
 * Created by Dawid on 2016-04-25.
 */
public class Person {
    private StringProperty name;
    private StringProperty surname;
    private Address address;
    private StringProperty phoneNumber;

    
    public Person() {
        this.name = new SimpleStringProperty("");
        this.surname = new SimpleStringProperty("");
        this.address = new Address();
        this.phoneNumber = new SimpleStringProperty("");
    }

    public Person(StringProperty name, StringProperty surname, Address address, StringProperty phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Way to bind bidirectional all properties of Person object
     * @param nameBind
     * @param surnameBind
     * @param phoneNumberBind
     */
    public void bindBidirectionalAllProperties(StringProperty nameBind, StringProperty surnameBind, StringProperty phoneNumberBind){
        name.bindBidirectional(nameBind);
        surname.bindBidirectional(surnameBind);
        phoneNumber.bindBidirectional(phoneNumberBind);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
}
