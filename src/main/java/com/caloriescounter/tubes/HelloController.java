package com.caloriescounter.tubes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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
        // Get input values
        boolean isMale = maleRadioButton.isSelected();
        boolean isFemale = femaleRadioButton.isSelected();

        if (!isMale && !isFemale) {
            resultLabel.setText("Pilih jenis kelamin terlebih dahulu.");
            return;
        }

        try {
            int age = Integer.parseInt(ageTextField.getText());
            double weight = Double.parseDouble(weightTextField.getText());

            // Calculate BMR based on gender
            double bmr;
            if (isMale) {
                // BMR formula for men: BMR = 88.362 + (13.397 * weight in kg) + (4.799 * height in cm) - (5.677 * age)
                bmr = 88.362 + (13.397 * weight) - (5.677 * age);
            } else {
                // BMR formula for women: BMR = 447.593 + (9.247 * weight in kg) + (3.098 * height in cm) - (4.330 * age)
                bmr = 447.593 + (9.247 * weight) - (4.330 * age);
            }

            // Display the result
            resultLabel.setText("Kebutuhan Kalori Basal Anda: " + String.format("%.2f", bmr) + " kalori per hari");
        } catch (NumberFormatException e) {
            resultLabel.setText("Masukkan usia dan berat badan dengan benar.");
        }
    }
}
