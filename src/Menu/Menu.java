
package Menu;

import Jugador.Jugador;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public Menu() {
    }
    
    public void MenuImpreso(){
        System.out.println("Bienvenido al Juego de damas");
            for (int x = 0; x < 5; x++) {
                System.out.println("Ingrese el nombre del usuario "+(x+1)+" :");
                sc.nextLine();
            }
    }
}
