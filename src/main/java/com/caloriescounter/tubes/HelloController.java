package com.caloriescounter.tubes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField heightTextField;

    @FXML
    private void calculateCalories() {
        // Ambil nilai inputan
        boolean isMale = maleRadioButton.isSelected();
        boolean isFemale = femaleRadioButton.isSelected();

        if (!isMale && !isFemale) {
            resultLabel.setText("Pilih jenis kelamin terlebih dahulu.");
            return;
        }

        try {
            int age = Integer.parseInt(ageTextField.getText());
            double weight = Double.parseDouble(weightTextField.getText());
            int height = Integer.parseInt(heightTextField.getText());

            // Hitung BMR
            double bmr;
            if (isMale) {
                bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
            } else {
                bmr = 665 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
            }

            // Display hasil
            String resultText = "HASIL PERHITUNGAN BMR (BASAL METABOLIC RATE) \n\nKebutuhan Kalori Basal Anda: " + String.format("%.2f", bmr) + " kalori per hari";

            double sedentaryMultiplier = 1.2; // Sedentary lifestyle multiplier
            double totalCalories = bmr * sedentaryMultiplier;

            // Display rekomendasi makanan
            resultText += "\nRekomendasi Makanan: \n" + getFoodRecommendations(totalCalories);
            resultLabel.setText(resultText);

            // Switch scene
            switchToResultScene(resultText);

        } catch (NumberFormatException e) {
            resultLabel.setText("Masukkan usia dan berat badan dengan benar.");
        }
    }

    private void switchToResultScene(String resultText) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultScene.fxml"));
            Parent root = loader.load();

            ResultController resultController = loader.getController();
            resultController.setResultText(resultText);

            Stage stage = (Stage) maleRadioButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getFoodRecommendations(double totalCalories) {
        // Rekomendasi makanan berdasar kebutuhan kalori
        if (totalCalories < 1500) {
            return "\nAnda disarankan untuk mengonsumsi \nmakanan ringan yang rendah kalori.";

        } else if (totalCalories < 2000) {
            return "\nAnda disarankan untuk mengonsumsi \nmakanan seimbang dan nutrisi.";
        } else {
            return "\nAnda dapat mengonsumsi \nmakanan dengan tambahan kalori tinggi.";
        }
    }
}
