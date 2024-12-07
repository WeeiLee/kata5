package software.ulpgc.kata5.ui;

import software.ulpgc.kata5.control.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private SwingPokemonDialog dialog;
    private PokemonImageDisplay imageDisplay;
    private PokemonInformationDisplay informationDisplay;

    public MainFrame(){
        this.commands = new HashMap<>();
        this.setTitle("PokéDex");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(toolbar(), BorderLayout.NORTH);
        this.add(createContentField(), BorderLayout.CENTER);
    }

    private Component createContentField() {
        this.imageDisplay = new PokemonImageDisplay();
        this.informationDisplay = new PokemonInformationDisplay();
        JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, imageDisplay, informationDisplay);
        splitPanel.setDividerLocation(400);
        return splitPanel;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(dialog = new SwingPokemonDialog());
        panel.add(createButton());
        return panel;
    }

    private Component createButton() {
        JButton button =  new JButton("search");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                commands.get("search").execute();
            }
        });
        return button;
    }

    public void put(String key, Command value) {commands.put(key,value);}

    public SwingPokemonDialog getDialog(){return this.dialog;}

    public PokemonImageDisplay getImageDisplay() {
        return imageDisplay;
    }

    public PokemonInformationDisplay getInformationDisplay() {
        return informationDisplay;
    }
}
