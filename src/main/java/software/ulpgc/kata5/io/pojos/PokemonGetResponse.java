package software.ulpgc.kata5.io.pojos;

import java.util.List;

public record PokemonGetResponse(Sprite sprites, String id, String height, String weight, String name, List<TypeSlot> types) {

    public record Sprite(String front_default, String back_default) {}
    public record TypeSlot(String slot, Type type){}
    public record Type(String name, String url){}
}