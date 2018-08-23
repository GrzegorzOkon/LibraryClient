package view.validators;

import javafx.scene.control.TextInputControl;

public class EmptySpaceTextValidatorBuilder implements TextValidatorBuilder {
    private TextInputControl currentInput;

    @Override
    public void buildInputText(TextInputControl input) {
        currentInput = input;
    }

    @Override
    public boolean validate() {
        String text = currentInput.getText();

        if (!text.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
