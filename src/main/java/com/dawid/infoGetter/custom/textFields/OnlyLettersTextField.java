/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawid.infoGetter.custom.textFields;

import javafx.scene.control.TextField;


/**
 * This subclass of TextField provides that field accepts only letters from Polish alphabet
 * Created by Dawid on 2016-04-25.
 */
public class OnlyLettersTextField extends TextField {
    
    @Override
    public void replaceText(int i, int i1, String string){
        if(string.matches("[a-zA-ZęĘóÓąĄżŻźŹćĆłŁśŚńŃ]*") || string.isEmpty()){
            super.replaceText(i,i1,string);
        }
    }

}