package software.ulpgc.kata5.model;

import java.util.List;

public record Pokemon(String id, String name, float height, float weight, PokeImage image, List<String> types) {
    public record PokeImage(String front, String back){}
}
