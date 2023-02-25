import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Reader {

    public String lerLinha( String filePath) throws IOException {
        ArrayList<String> linhas = new ArrayList<>();
        FileReader arquivo = new FileReader(filePath);
        BufferedReader leitor = new BufferedReader(arquivo);
        String linha;
        while ((linha = leitor.readLine()) != null) {
            linhas.add(linha);
        }
        leitor.close();
        Random gerador = new Random();
        int indiceAleatorio = gerador.nextInt(linhas.size());
        return linhas.get(indiceAleatorio);
    }

}
