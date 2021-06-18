
package Menu;

import Jugador.Jugador;
import Tablero.Partida;
import Tablero.Tablero;

public class main {
        public static void main(String[] args) {
        Tablero A = new Tablero();
        Jugador J1 = new Jugador("P1",0,0,"X");
        Jugador J2 = new Jugador("P2",0,0,"O");
        Partida Partida = new Partida(J1,J2,A);
        Partida.ColocarFichas(J1, J2);
        A.DibujarTablero(J1.getNombre(), J2.getNombre());
    
    }
}
