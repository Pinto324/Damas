
package src.Menu;

import src.Jugador.Jugador;
import src.Tablero.Partida;
import src.Tablero.Tablero;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Partida AJugar;
    public Menu() {
    }
    
    
    
    public void PiedraPapelTijeras (Jugador J1, Jugador J2){        
        int id=J1.getId();
        System.out.println("\nIniciando el juego");
        System.out.println("para decidir turnos primero se hará un juego de Piedra, Papel, Tijeras");
        String []game = {"Piedra","Papel","Tijeras"}; 
        String p1="";
        String p2="";
        boolean exit = false;
        while(!exit){
            for(int i = 0; i <2;i++){
                int option =rand.nextInt(3);
                if(i==0){
                    p1=game[option];
                }else{
                    p2=game[option];
                }
            }
            System.out.println("Jugador 1: "+p1);
            System.out.println("Jugador 2: "+p2);
            if(p1.equals("Piedra")&&p2.equals("Tijeras")  ||  p1.equals("Tijeras")&&p2.equals("Piedra") ){
                if(p1.equals("Piedra")){
                    id= J1.getId();
                }else if(p1.equals("Tijeras")){
                    id= J2.getId();
                }
                System.out.println("l1"+id);
                exit = true;
            }
            else if(p1.equals("Papel")&&p2.equals("Tijeras")  ||  p1.equals("Tijeras")&&p2.equals("Papel")){
                if(p1.equals("Tijeras")){
                    id= J1.getId();
                }else if(p1.equals("Papel")){
                    id= J2.getId();
                exit = true;
                System.out.println("l2"+id);

                }
            }
            else if(p1.equals("Piedra")&&p2.equals("Papel")  ||  p1.equals("Papel")&&p2.equals("Piedra")){
                if(p1.equals("Papel")){
                    id= J1.getId();
                }else if (p1.equals("Piedra")){
                    id= J2.getId();
                }
                exit = true;
                System.out.println("l2"+id);

            }
        }
        if(id==J1.getId()){
            System.out.println("Gano "+J1.getNombre());
        }else{
            System.out.println("Gano "+J2.getNombre());
        }
    }
     public void PiedraPapelTijeras (Jugador J1, Jugador J2, int XD){        
        System.out.println("\nIniciando el juego");
        System.out.println("para decidir turnos primero se hará un juego de Piedra, Papel, Tijeras");
        System.out.println("Jugador 1: Papel");
        System.out.println("Jugador 2: Piedra");
        System.out.println("Jugador 1: Gana jugador 1");
    }
    
    public void DecidirColor(Jugador J1, Jugador J2){
        Tablero Tablero;
        Partida Partida;
        System.out.println("Iniciando el juego");
        System.out.println("\nEn que color de casillas desea jugar? R para rojo y B para blanco.");
        sc.reset();
        String O = sc.nextLine();
        switch(O){
            case "B":
                System.out.println("Se seleccionó las casillas blancas");
                if(ElegirFichas(10).equals("\u001B[31m")){
                    J1.setFormaFicha("\u001B[31m");
                    J2.setFormaFicha("\u001B[30m");
                }else{
                    J1.setFormaFicha("\u001B[30m");
                    J2.setFormaFicha("\u001B[31m");
                }
                Tablero = new Tablero();
                Partida = new Partida(J1,J2,Tablero);
                Partida.LlenarFichas(10);
                Partida.ColocarFichas();
                Partida.jugar();
                break;
            case "R":
                System.out.println("Se seleccionó las casillas rojas");
                if(ElegirFichas(1).equals("\u001B[37m")){
                    J1.setFormaFicha("\u001B[37m");
                    J2.setFormaFicha("\u001B[30m");
                }else{
                    J1.setFormaFicha("\u001B[30m");
                    J2.setFormaFicha("\u001B[37m");
                }
                Tablero = new Tablero();
                Partida = new Partida(J1,J2,Tablero);
                Partida.LlenarFichas(1);
                Partida.ColocarFichas();
                Partida.jugar();
                break;
            default:
                System.out.println("Ingrese una opción valida");
                break;
        }
    }
    public String ElegirFichas(int Color){
        if(Color == 1){
        System.out.println("\nQue fichas desea usar? N para negras, B para blancas");
            sc.reset();
        String O = sc.nextLine();
            switch(O){
            case "B":
                System.out.println("Se seleccionaron las fichas blancas");               
                return "\u001B[37m";
            case "N":
                System.out.println("Se seleccionaron las fichas Negras");
                return "\u001B[30m";
            default:
                System.out.println("Ingrese una opción valida");
                break;
            }        
        }else{
        System.out.println("\nQue fichas desea usar? N para negras, R para rojas");
            sc.reset();
        String O = sc.nextLine();
            switch(O){
            case "R":
                System.out.println("Se seleccionaron las fichas rojas");               
                return "\u001B[31m";
            case "N":
                System.out.println("Se seleccionaron las fichas Negras");
                return "\u001B[30m";
            default:
                System.out.println("Ingrese una opción valida");
                break;
            }        
        }
        return null;
    }
}
