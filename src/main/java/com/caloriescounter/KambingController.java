// SayurAsemRecipeController.java
package com.caloriescounter.tubes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class KambingController {

    @FXML
    private Label recipeLabel;

    public void setRecipeText(String text) {
        recipeLabel.setText(text);
    }
}

// Similar controllers for other recipes...
