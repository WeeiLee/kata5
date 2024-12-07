package software.ulpgc.kata5.io;

import com.google.gson.Gson;
import software.ulpgc.kata5.io.pojos.PokemonGetResponse;

public class PokemonDeserializer implements JsonDeserializer{
    @Override
    public Object deserialize(String json) {
        return new Gson().fromJson(json, PokemonGetResponse.class);
    }
}
