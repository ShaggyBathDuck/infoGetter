/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawid.infoGetter.custom.textFields;

import javafx.scene.control.TextField;

/**
 * This subclass of TextField provides that field accepts only numbers
 * Created by Dawid on 2016-04-25.
 */
public class OnlyNumbersTextField extends TextField {

    @Override
    public void replaceText(int i, int i1, String string){
        if(string.matches("[0-9]*") || string.isEmpty()  ){
            super.replaceText(i,i1,string);
        }
    }


}