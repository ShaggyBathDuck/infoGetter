/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawid.infoGetter.custom.textFields;

import javafx.scene.control.TextField;
/**
 * This subclass of TextField provides that field accepts not only letters from Polish alphabet, but also spaces and dashes
 * Created by Dawid on 2016-04-25.
 */
public class LettersDashesAndSpacesTextField extends TextField {

    @Override
    public void replaceText(int i, int i1, String string){
        if(string.matches("[a-zA-ZęĘóÓąĄżŻźŹćĆłŁŚśńŃ -]*")|| string.isEmpty()) {
            if(string.contains(" ")&& (i==0 || overOccurrenceLimit(' ',2)))
                return;
            if(string.contains("-") && (i==0 || overOccurrenceLimit('-', 2)))
                return;
            super.replaceText(i,i1,string);
        }
    }

    /**
     * Some chars should be limited in this kind of fields
     * @param searchedChar char with occurrence limit
     * @param occurrenceLimit the number value of occurrence limit
     * @return  true when the occurrence of char is under limit
     */
    private boolean overOccurrenceLimit(char searchedChar, int occurrenceLimit){
        int counter = 0;
        for( int i=0; i<getLength(); i++ ) {
            if (getText().charAt(i) == searchedChar)
                counter++;
            if (counter > occurrenceLimit)
                return true;
        }
        return false;
    }

}