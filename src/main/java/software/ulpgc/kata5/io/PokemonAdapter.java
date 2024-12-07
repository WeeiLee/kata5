package software.ulpgc.kata5.io;

import software.ulpgc.kata5.io.pojos.PokemonGetResponse;
import software.ulpgc.kata5.model.Pokemon;

import java.util.List;

public class PokemonAdapter implements Adapter{
    @Override
    public Pokemon adapt(Object object) {
        return adapt((PokemonGetResponse) object);
    }
    private Pokemon adapt(PokemonGetResponse response){
        return new Pokemon(
                response.id(),
                response.name(),
                toStandardMeasure(response.height()),
                toStandardMeasure(response.weight()),
                insertPokemonImage(response),
                insertPokemonType(response)
        );
    }

    private List<String> insertPokemonType(PokemonGetResponse response) {
        return response.types().stream()
                .map(PokemonGetResponse.TypeSlot::type)
                .map(PokemonGetResponse.Type::name)
                .toList();
    }


    private static Pokemon.PokeImage insertPokemonImage(PokemonGetResponse response) {
        return new Pokemon.PokeImage(response.sprites().front_default(), response.sprites().back_default());
    }

    private Float toStandardMeasure(String text) {
        return Float.parseFloat(text) / 10;

    }
}
