package lesson4_level2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {


    private Calculator calculator;

    public Controller() {
        this.calculator = new Calculator();
    }

    @FXML
    public Button btnAdd;

    public void clickBtnAdd(ActionEvent actionEvent) {

    }

    public void buttonBackSpaceClick(ActionEvent actionEvent) {
    }

    public void buttonClearEnteredClick(ActionEvent actionEvent) {
    }

    public void buttonClearClick(ActionEvent actionEvent) {
    }

    public void buttonNegateClick(ActionEvent actionEvent) {
    }

    public void buttonSqrtClick(ActionEvent actionEvent) {
    }

    public void buttonDigitClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String digit = button.getText();
        //calculator.digit(digit);
    }

    public void buttonOperatorClick(ActionEvent actionEvent) {
    }

    public void buttonPercentClick(ActionEvent actionEvent) {
    }

    public void buttonFractionOneClick(ActionEvent actionEvent) {
    }

    public void buttonEnterClick(ActionEvent actionEvent) {
    }

    public void buttonCommaClick(ActionEvent actionEvent) {
    }
}
