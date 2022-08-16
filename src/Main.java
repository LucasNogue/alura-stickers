import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //Fazer uma conexão HTTP

        //Conexão com a API do IMDB
        //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        //ExtratorDeConteudoIMDB extrator = new ExtratorDeConteudoIMDB();

        //Conexão com a API da NASA
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();

        //Conexão com a API de linguagens
        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++){

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/"+  conteudo.getTitulo() + ".png";

            geradora.cria(inputStream,nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
