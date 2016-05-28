package com.dawid.infoGetter.controller;

import com.dawid.infoGetter.custom.textFields.OnlyNumbersTextField;
import com.dawid.infoGetter.custom.textFields.PostalCodeTextField;
import com.dawid.infoGetter.custom.textFields.LettersDashesAndSpacesTextField;
import com.dawid.infoGetter.custom.textFields.OnlyLettersTextField;
import com.dawid.infoGetter.custom.textFields.PhoneNumberTextField;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.dawid.infoGetter.model.Address;
import com.dawid.infoGetter.model.Person;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 */
public class FXMLController implements Initializable{
    @FXML StackPane scenesStack;
    @FXML Button nextSceneButton;
    @FXML Button previousSceneButton;
    @FXML Button closeSceneButton;
    @FXML OnlyLettersTextField nameTextField;
    @FXML LettersDashesAndSpacesTextField surnameTextField;
    @FXML OnlyLettersTextField streetTextField;
    @FXML OnlyNumbersTextField houseNumberTextField;
    @FXML OnlyNumbersTextField apartmentNumberTextField;
    @FXML PostalCodeTextField postalCodeTextField;
    @FXML LettersDashesAndSpacesTextField cityNameTextField;
    @FXML LettersDashesAndSpacesTextField countryNameTextField;
    @FXML PhoneNumberTextField phoneNumberTextField;
    @FXML Label slashShowLabel;
    private IntegerProperty currentSceneID;
    private Person personalData;
    @Override

    public void initialize(URL location, ResourceBundle resources) {
        Address address= new Address();
        address.bindBidirectionalAllProperties(streetTextField.textProperty(), houseNumberTextField.textProperty(), apartmentNumberTextField.textProperty(),
                postalCodeTextField.textProperty(), cityNameTextField.textProperty(), countryNameTextField.textProperty());
        personalData=new Person();
        personalData.setAddress(address);
        personalData.bindBidirectionalAllProperties(nameTextField.textProperty(), surnameTextField.textProperty(), phoneNumberTextField.textProperty());
        currentSceneID= new SimpleIntegerProperty(0);
        nextSceneButton.visibleProperty().bind(currentSceneID.lessThan(scenesStack.getChildren().size()-1));
        previousSceneButton.visibleProperty().bind(currentSceneID.greaterThan(0));
        slashShowLabel.visibleProperty().bind(personalData.getAddress().apartmentNumberProperty().isNotEqualTo(0));
    }
    /**
     * Pop from StackPane first component, and add it on the end of stack
     */
    @FXML public void nextScene() {
        Node tmp = scenesStack.getChildren().get(0);
        scenesStack.getChildren().remove(0);
        scenesStack.getChildren().get(0).setVisible(true);
        tmp.setVisible(false);
        scenesStack.getChildren().add(tmp);
        currentSceneID.setValue(currentSceneID.getValue()+1);
    }

    /**
     * Get from StackPane last component, and push it in the stack
     */
    @FXML public void previousScene() {
        scenesStack.getChildren().get(0).setVisible(false);
        Node tmp = scenesStack.getChildren().get(scenesStack.getChildren().size()-1);
        scenesStack.getChildren().remove(scenesStack.getChildren().size()-1);
        scenesStack.getChildren().add(0,tmp);
        scenesStack.getChildren().get(0).setVisible(true);
        currentSceneID.setValue(currentSceneID.getValue()-1);
    }

    /**
     *
     */
    @FXML public void closeScene() {
        Stage stage = (Stage) closeSceneButton.getScene().getWindow();
        stage.close();}
}

