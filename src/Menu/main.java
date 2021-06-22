

package src.Menu;

import src.Jugador.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class main {
        static Scanner sn = new Scanner(System.in);
        static Jugador[] Jugadores = new Jugador[10];
        static int ContadorJugadores = 0;
        static IngresarDatos D = new IngresarDatos();
        public static void main(String[] args) {
        Menu Inicio = new Menu();
        
        String ColorNegro = "\u001B[30m";
        String Reset = "\u001B[0;0m";  
        String ColorBlanco = "\u001B[37m";
        boolean salir = false;
        int opcion; 
         while (!salir) {
             System.out.println("\n Bienvenido a Damas \n");
             System.out.println("1) Jugar");
             System.out.println("2) Ingresar Jugadores");
             System.out.println("3) Informacion de Jugadores");
             System.out.println("5) Salir");
             try {
                 System.out.println("Escribe una de las opciones");
                 opcion = sn.nextInt();
                 sn.reset();
                 switch (opcion) {
                     case 1:
                        Jugador J1 = Jugadores[ElegirJugadores(Jugadores)];
                        Jugador J2 = Jugadores[ElegirJugadores(Jugadores)];
                        Inicio.PiedraPapelTijeras(J1,J2,1);
                        Inicio.DecidirColor(J1, J2);
                        break;
                     case 2:
                        agregarJugador();
                        break;
                     case 3:
                        for (int i = 0; i < ContadorJugadores; i++) {
                        System.out.println("Id: "+ Jugadores[i].getId()+"  Jugador: " + Jugadores[i].getNombre() + " Partidas Ganadas: " + Jugadores[i].getVictorias()+ " Partidas Perdidas: " + Jugadores[i].getDerrotas());
                        }
                        break;
                     case 5:
                         salir = true;
                         break;
                     default:
                         System.out.println("Esa opcion no existe");
                 }
             } catch (InputMismatchException e) {
                 System.out.println("Debes insertar un número");
                 sn.next();
                 sn.close();
             }
         }
    }
        public static int ElegirJugadores(Jugador[] Lista){
            int ID;
            System.out.println("Escriba los Id de los jugadores que van a jugar:");
            ID = sn.nextInt();
                for (int i = 0; i < 10; i++) {
                    if(ID==Lista[i].getId()){
                    return (ID-1);
                    }
                }
            return -1;    
        }
        public static void agregarJugador(){
        String NombreJugador;
        NombreJugador = D.IngresarString("Ingrese el nombre del Jugador:");
        Jugadores[ContadorJugadores] =  new Jugador(NombreJugador,(ContadorJugadores+1), 0, 0, "");
        ContadorJugadores++;
    }
}
