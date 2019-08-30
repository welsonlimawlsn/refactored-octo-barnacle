package com.stefanini.herois.personagem.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.stefanini.herois.csv.CarregadorCSV;
import com.stefanini.herois.personagem.entity.Personagem;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonagemCSV implements CarregadorCSV<List<Personagem>> {

    private static final String ARQUIVO = "/home/welson/charcters_stats.csv";

    public PersonagemCSV() {

    }

    @Override
    public List<Personagem> carregaCSV() throws IOException {
        List<Personagem> personagems = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get(ARQUIVO));
        CSVReader leitor = new CSVReaderBuilder(reader).withSkipLines(1).build();
        List<String[]> csv = leitor.readAll();
        int count = 0;

        for (String[] linhas : csv) {
            Personagem personagem = new Personagem();
            for (String coluna : linhas) {
                if (count == 0)
                    personagem.setNome(coluna);
                if (count == 1)
                    personagem.setAlinhamento(coluna);
                if (count == 2)
                    personagem.setInteligencia(Integer.valueOf(coluna));
                if (count == 3)
                    personagem.setForca(Integer.valueOf(coluna));
                if (count == 4)
                    personagem.setDestreza(Integer.valueOf(coluna));
                if (count == 5)
                    personagem.setDefesa(Integer.valueOf(coluna));
                if (count == 6)
                    personagem.setPoder(Integer.valueOf(coluna));
                if (count == 7)
                    personagem.setCombate(Integer.valueOf(coluna));

                count++;

                if (count == 8) {
                    personagems.add(personagem);
                    personagem = null;
                    count = 0;
                }
            }
        }

        leitor.close();

        return personagems;
    }
}
