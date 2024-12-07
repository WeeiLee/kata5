package software.ulpgc.kata5.ui;

import software.ulpgc.kata5.model.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PokemonImageDisplay extends JPanel implements PokemonDisplay {
    @Override
    public void display(Pokemon pokemon) {
        this.removeAll();
        this.setLayout(new BorderLayout());
        try {
            this.add(createSplitPanel(pokemon), BorderLayout.CENTER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        revalidate();
    }

    private static JSplitPane createSplitPanel(Pokemon pokemon) throws IOException {
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new ImagePanel(pokemon.image().front()),
                new ImagePanel(pokemon.image().back()));
        splitPane.setDividerLocation(250);
        return splitPane;
    }
}
