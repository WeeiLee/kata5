package software.ulpgc.kata5.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class PokemonReader implements JsonReader{
    private final String name;

    public PokemonReader(String name) {
        this.name = name.toLowerCase();
    }

    @Override
    public String read() {
        try {
            return read("https://pokeapi.co/api/v2/pokemon/" + this.name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String read(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(GET)
                .execute();
        if(response.statusCode() != 200) throw new RuntimeException("Hay un error");
        return response.body();
    }
}
