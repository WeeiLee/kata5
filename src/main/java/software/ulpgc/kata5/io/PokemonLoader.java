package software.ulpgc.kata5.io;

import software.ulpgc.kata5.model.Pokemon;

public class PokemonLoader {
    private final JsonReader reader;
    private final JsonDeserializer deserializer;
    private final PokemonAdapter adapter;

    public PokemonLoader(JsonReader reader, JsonDeserializer deserializer, PokemonAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    public Pokemon get(){return adapter.adapt(deserializer.deserialize(reader.read()));}
}
