
package Tablero;

import Jugador.Jugador;

public class Tablero {    
    String ClorRojo = "\u001B[41;31m";
    String Reset = "\u001B[0;0m";  
    String ColorBlanco = "\u001B[40;37m";
    private final String VACIO = "";
    private String[][] tablero;

    public Tablero() {
        this.tablero = new String[8][8];
        llenarTablero();
    }
         //gets y sets
    public String[][] getTablero() {
        return tablero;
    }
    
    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }
    //Metodos del uso del tablero
    //Llenar el tablero con vacio:
    private void llenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = VACIO;
            }            
        }
    }
    //Dibujo del tablero Con los jugadores
    public void DibujarTablero(String Jugador1, String Jugador2) {
        System.out.println("Jugador1:" + Jugador1 + "\t\t\t\t\t\t\t\t\t\t\t\t" + "Jugador2:" + Jugador2);
        System.out.println("\t");
        for (int x = 0; x < tablero.length ; x++) {
            for (int y = 0; y < tablero.length; y++) {
                ElegirColorCasilla(x,y);
            }
            System.out.println("");
        }
    }
    //dibujo del tablero sin los jugadores
    public void DibujarTablero(){
        for (int x = 0; x < tablero.length ; x++) {
            for (int y = 0; y < tablero.length; y++) {
                ElegirColorCasilla(x,y);
            }
            System.out.println("");
        }
    
    }

    public void ElegirColorCasilla(int x, int y){

        if(x == 1|| x==3||x==5||x==7){
            if(y%2==0){
                System.out.print(ColorBlanco+"\t");
                System.out.print(tablero[x][y] + "\t");
                System.out.print(Reset);
            }else{
                System.out.print(ClorRojo+"\t");
                System.out.print(tablero[x][y] + "\t");
                System.out.print(Reset); 
            }        
        }else{
            if(y%2==0){
                System.out.print(ClorRojo+"\t");
                System.out.print(tablero[x][y] + "\t");
                System.out.print(Reset);
            }else{
                System.out.print(ColorBlanco+"\t");
                System.out.print(tablero[x][y] + "\t");
                System.out.print(Reset);
            }
        }
    }
}
