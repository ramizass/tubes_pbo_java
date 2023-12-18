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

            // Hitung BMR
            double bmr;
            if (isMale) {
                bmr = 88.362 + (13.397 * weight) - (5.677 * age);
            } else {
                bmr = 447.593 + (9.247 * weight) - (4.330 * age);
            }

            // Display hasil
            String resultText = "Kebutuhan Kalori Basal Anda: " + String.format("%.2f", bmr) + " kalori per hari";


            double sedentaryMultiplier = 1.2; // Sedentary lifestyle multiplier
            double totalCalories = bmr * sedentaryMultiplier;

            // Display rekomendasi makanan
            resultText += "\nRekomendasi Makanan: " + getFoodRecommendations(totalCalories);
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
            return "Anda disarankan untuk mengonsumsi makanan ringan yang rendah kalori." +
                    "\nRekomendasi makanan rendah kalori:" +
                    "\n1. Kacang-kacangan" +
                    "\n2. Ikan stim" +
                    "\n3. Ayam tanpa kulit" +
                    "\n4. Tahu";
        } else if (totalCalories < 2000) {
            return "Anda disarankan untuk mengonsumsi makanan seimbang dan nutrisi.";
        } else {
            return "Anda dapat mengonsumsi makanan dengan tambahan kalori sehat." +
                    "\nRekomendasi makanan tinggi kalori:" +
                    "\n1. Daging merah" +
                    "\n2. Nasi putih" +
                    "\n3. Cokelat" +
                    "\n4. Ikan berlemak (Salmon, Makarel, Tuna)";
        }
    }
}
