package com.caloriescounter.tubes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultController {

    @FXML
    private Label resultLabel;

    public void setResultText(String text) {
        resultLabel.setText(text);
    }
}
