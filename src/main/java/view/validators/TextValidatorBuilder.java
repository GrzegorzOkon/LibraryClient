package view.validators;

import javafx.scene.control.TextInputControl;

public interface TextValidatorBuilder {
    void buildInputText(TextInputControl input);

    boolean validate();
}
