package software.ulpgc.kata5.ui;

import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {
    private final String PokemonInformation;

    public InformationPanel(String pokemonInformation) {
        PokemonInformation = pokemonInformation;
        setLayout(new BorderLayout());
        add(createScrollPane(), BorderLayout.CENTER);
    }

    private Component createScrollPane() {
        return new JScrollPane(createTextArea());

    }

    private Component createTextArea() {
        JTextArea textArea = new JTextArea(8,15);
        textArea.setText(this.PokemonInformation);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 24));
        return textArea;
    }
}
