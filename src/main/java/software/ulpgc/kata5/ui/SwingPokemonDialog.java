package software.ulpgc.kata5.ui;

import javax.swing.*;
import java.awt.*;

public class SwingPokemonDialog extends JPanel implements PokemonDialog{
    private final JTextField nameField;


    public SwingPokemonDialog(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(this.nameField = iniNameField());
    }

    private JTextField iniNameField() {
        JTextField textField = new JTextField();
        textField.setColumns(8);
        return textField;
    }

    @Override
    public String getPokemonName() {
        return nameField.getText();
    }
}
