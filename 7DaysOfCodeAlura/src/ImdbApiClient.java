import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbApiClient {

	private String url;

	public ImdbApiClient(String url) {
		this.url = url;
	}

	public String getBody() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		URI endereco = URI.create(this.url);
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();

	}

}
