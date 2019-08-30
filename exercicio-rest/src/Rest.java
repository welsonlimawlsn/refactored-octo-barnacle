import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Rest {

    private static final Path PATH = Paths.get("rest.txt");

    public static void main(String[] args) throws IOException {
        postInsere();
        System.out.println(getRecupera());
        putAtualiza();
        System.out.println(getRecupera());
        deleteRemove();
    }

    private static void postInsere() throws IOException {
        criaArquivo();
        escreveNoArquivo("Eu amo Java!");
    }

    private static void putAtualiza() throws IOException {
        escreveNoArquivo("Eu amo Java! E quero muito trabalhar na Stefanini.");
    }

    private static String getRecupera() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(PATH)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }

    private static void deleteRemove() throws IOException {
        Files.deleteIfExists(PATH);
    }

    private static void criaArquivo() throws IOException {
        if (Files.notExists(PATH)) {
            Files.createFile(PATH);
        }
    }

    private static void escreveNoArquivo(String s) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(PATH)) {
            bufferedWriter.write(s);
        }
    }
}
