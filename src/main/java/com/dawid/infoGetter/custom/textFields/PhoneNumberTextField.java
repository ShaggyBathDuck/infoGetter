/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawid.infoGetter.custom.textFields;

import javafx.scene.control.TextField;

/**
 * This subclass of TextField ensure validation of phone number, with multiple formats form around the world
 * Created by Dawid on 2016-04-25.
 */
public class PhoneNumberTextField extends TextField {
    @Override
    public void replaceText(int i, int i1, String string){
        if((string.matches("[0-9 +-/(/)]*")&&string.length()+getLength()<15)|| string.isEmpty()){
            super.replaceText(i,i1,string);
        }
    }


}