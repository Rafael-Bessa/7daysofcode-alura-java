import java.io.PrintWriter;
import java.util.List;

public class GeradorHTML {

	private final PrintWriter writer;

	public GeradorHTML(PrintWriter pw) {
		this.writer = pw;
	}

	public void gerador(List<Filme> listaFilmes) {

		writer.print("<html> <head> </head> <body> <h1> " + listaFilmes.get(0).title() +"</h1>  "
				+ "<hr> <img src=" + listaFilmes.get(0).urlImage() + ">"
				+ "<br> <br>"
				+ "Nota: <strong>" + listaFilmes.get(0).rating() + "</strong> - "
				+ "Ano: <strong>" + listaFilmes.get(0).year() + "</strong>"
				+ ""
				+ ""
				+ ""
				+ ""
				+ "</body> </html>");

	}

}
