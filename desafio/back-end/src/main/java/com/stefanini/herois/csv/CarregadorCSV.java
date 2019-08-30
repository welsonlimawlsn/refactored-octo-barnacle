package com.stefanini.herois.csv;

import java.io.IOException;

public interface CarregadorCSV<T> {

    T carregaCSV() throws IOException;

}
