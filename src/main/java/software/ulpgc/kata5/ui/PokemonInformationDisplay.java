package software.ulpgc.kata5.ui;

import software.ulpgc.kata5.model.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PokemonInformationDisplay extends JPanel implements PokemonDisplay {
    @Override
    public void display(Pokemon pokemon) {
        removeAll();
        setLayout(new BorderLayout());
        try {
            add(createSplitPanel(pokemon), BorderLayout.CENTER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        revalidate();
    }

    private static JSplitPane createSplitPanel(Pokemon pokemon) throws IOException {
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new InformationPanel(getInfo(pokemon)),
                new ImagePanel("https://i.pinimg.com/736x/92/64/d5/9264d5ec77eec85e69b81c66449afb3c.jpg"));
        splitPane.setDividerLocation(250);
        return splitPane;
    }
    private static String getInfo(Pokemon pokemon) {
        return    "\n"
                + "     ID   : " + pokemon.id() + "\n"
                + "     NAME : " + pokemon.name() + "\n"
                + "     WEIGHT : " + pokemon.weight() + "KG \n"
                + "     HEIGHT : " + pokemon.height() + "KG \n"
                + "     TYPE : " + pokemon.types() + "\n";
    }


}
