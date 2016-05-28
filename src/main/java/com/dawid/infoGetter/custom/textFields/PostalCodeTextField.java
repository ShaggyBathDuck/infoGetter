/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawid.infoGetter.custom.textFields;

import javafx.scene.control.TextField;

/**
 * This subclass of TextField ensure validation of postal code, with only numbers and dash at 2 place
 * Created by Dawid on 2016-04-25.
 */
public class PostalCodeTextField extends TextField {

    @Override
    public void replaceText(int i, int i1, String string){
        if(string.matches("[0-9]*-?")&& string.length()+getLength()<7 || string.isEmpty()){
            if((i!=2 && !string.equals("-")) || (i==2 && (string.equals("-")||string.isEmpty())))
                super.replaceText(i,i1,string);
        }
    }
}

