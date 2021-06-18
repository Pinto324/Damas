
package Tablero;

import Jugador.Jugador;
import java.util.Scanner;

public class Partida {
    private Jugador Jugador1;
    private Jugador Jugador2;
    private Tablero Tablero;
    private Scanner sc;
    public Partida(Jugador Jugador1, Jugador Jugador2, Tablero Tablero) {
        this.Jugador1 = Jugador1;
        this.Jugador2 = Jugador2;
        this.Tablero = Tablero;
    }

    public Jugador getJugador1() {
        return Jugador1;
    }

    public void setJugador1(Jugador Jugador1) {
        this.Jugador1 = Jugador1;
    }

    public Jugador getJugador2() {
        return Jugador2;
    }

    public void setJugador2(Jugador Jugador2) {
        this.Jugador2 = Jugador2;
    }

    public Tablero getTablero() {
        return Tablero;
    }

    public void setTablero(Tablero Tablero) {
        this.Tablero = Tablero;
    }
    public void ColocarFichas(Jugador Jugador1, Jugador Jugador2){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if(Jugador1.getFichas()[x][y]==1){
                    this.Tablero.getTablero()[x][y]=Jugador1.getFormaFicha();
                }else if(Jugador1.getFichas()[x][y]==-1){
                     this.Tablero.getTablero()[x][y]=Jugador2.getFormaFicha();
                }
            }            
        }
    }
}
