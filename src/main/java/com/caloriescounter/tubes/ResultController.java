// ResultController.java
package com.caloriescounter.tubes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultController {

    @FXML
    private Label resultLabel;

    @FXML
    private ToggleButton sayurAsemButton;

    @FXML
    private ToggleButton gadoGadoButton;

    @FXML
    private ToggleButton sateKambingButton;

    @FXML
    private ToggleButton nasiPadangButton;

    @FXML
    private ToggleGroup recipeToggleGroup;

    public void setResultText(String text) {
        resultLabel.setText(text);}

    private void switchToRecipeScene(String recipeFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SayurAsem.fxml"));
            Parent root = loader.load();

            AsemController recipeController = loader.getController();
            // Pass any necessary data to the recipe controller if needed

            Stage stage = (Stage) sayurAsemButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void switchToRecipeScene2(String recipeFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GadoGado.fxml"));
            Parent root = loader.load();

            GadoController recipeController = loader.getController();
            // Pass any necessary data to the recipe controller if needed

            Stage stage = (Stage) gadoGadoButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchToRecipeScene3(String recipeFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NasiPadang.fxml"));
            Parent root = loader.load();

            PadangController recipeController = loader.getController();
            // Pass any necessary data to the recipe controller if needed

            Stage stage = (Stage) nasiPadangButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchToRecipeScene4(String recipeFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SateKambing.fxml"));
            Parent root = loader.load();

            KambingController recipeController = loader.getController();
            // Pass any necessary data to the recipe controller if needed

            Stage stage = (Stage) sateKambingButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleToggleButtonSelection() {
        if (sayurAsemButton.isSelected()) {
            switchToRecipeScene("SayurAsemRecipe.fxml");
        } else if (gadoGadoButton.isSelected()) {
            switchToRecipeScene2("GadoGadoRecipe.fxml");
        } else if (sateKambingButton.isSelected()) {
            switchToRecipeScene3("SateKambingRecipe.fxml");
        } else if (nasiPadangButton.isSelected()) {
            switchToRecipeScene4("NasiPadangRecipe.fxml");
        }
    }
}
