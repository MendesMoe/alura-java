import java.net.http.*;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.net.URI;

public class App {

    public static void main(String[] args) throws Exception {

        // connexion HTTP - Api imdb-api
        String url = "https://api.mocki.io/v2/549a5d8b";
        HttpClient client = HttpClient.newHttpClient();
        URI address = URI.create(url);
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // get 4 parameters by films
        var parser = new JsonParser();
        List<Map<String, String>> movieList = parser.parse(body);

        // print data
        for (Map<String, String> movie : movieList) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();
        }

    }
}
