package software.ulpgc.kata5.control;

import software.ulpgc.kata5.io.PokemonAdapter;
import software.ulpgc.kata5.io.PokemonDeserializer;
import software.ulpgc.kata5.io.PokemonLoader;
import software.ulpgc.kata5.io.PokemonReader;
import software.ulpgc.kata5.model.Pokemon;
import software.ulpgc.kata5.ui.PokemonDialog;
import software.ulpgc.kata5.ui.PokemonDisplay;

public class ShowPokemonCommand implements Command {
    private final PokemonDisplay imageDisplay;
    private final PokemonDisplay informationDisplay;
    private final PokemonDialog dialog;

    public ShowPokemonCommand(PokemonDisplay imageDisplay, PokemonDisplay informationDisplay, PokemonDialog dialog) {
        this.imageDisplay = imageDisplay;
        this.dialog = dialog;
        this.informationDisplay = informationDisplay;
    }


    @Override
    public void execute() {
        PokemonLoader loader = new PokemonLoader(
                new PokemonReader(dialog.getPokemonName()),
                new PokemonDeserializer(),
                new PokemonAdapter());
        Pokemon pokemon = loader.get();
        imageDisplay.display(pokemon);
        informationDisplay.display(pokemon);
    }
}
