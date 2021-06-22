
package src.Tablero;

public class Fichas {
    private int Fichas;
    private String Identificador;

    public Fichas(int Fichas, String Identificador) {
        this.Fichas = Fichas;
        this.Identificador = Identificador;
    }

    public int getFichas() {
        return Fichas;
    }

    public void setFichas(int Fichas) {
        this.Fichas = Fichas;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }
    
}
