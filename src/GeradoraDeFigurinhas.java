import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        //leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/conteudo-maior.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria uma nova imagem em memória com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 100;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para novo imagem (em memóiria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,15,0,null );

        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD,30);
        graphics.setColor(Color.ORANGE);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("FIGURINHA",40,novaAltura - 50);

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem,"png",new File(nomeArquivo));
    }

}