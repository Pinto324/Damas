
package src.Tablero;


public class Tablero {
    String ClorRojo = "\u001B[41m";
    String Reset = "\u001B[0m";  
    String ColorBlanco = "\u001B[40m";
    private final String VACIO = "";
    private String[][] tablero;
    public Tablero() {
        this.tablero = new String[8][9];
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }
    //Dibujo del tablero Con los jugadores
    public void DibujarTablero(String Jugador1, String Jugador2) {
        System.out.println("Jugador1:" + Jugador1 + "\t\t\t\t\t\t\t\t\t\t\t\t" + "Jugador2:" + Jugador2);
        System.out.println("\t");
        System.out.println("\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8");
        System.out.println("______________________________________________________________________________________________________________________________________");
        for (int x = 0; x < 8 ; x++) {
            for (int y = 0; y < 9 ; y++) {
                ElegirColorCasilla(x,y);
            }
            System.out.println("");
        }
    }
    //Dibujo de tablero en partida:
    public void DibujarTablero(){
        System.out.println("\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8");
        System.out.println("______________________________________________________________________________________________________________________________________");
        for (int x = 0; x < 8 ; x++) {
            for (int y = 0; y < 9 ; y++) {
                ElegirColorCasilla(x,y);
            }
            System.out.println("");
        }
    }
    
    public void ElegirColorCasilla(int x, int y){
        if(y!=8){
        if(x == 1|| x==3||x==5||x==7&&y!=8){
            if(y%2==0){
                System.out.print(ColorBlanco+"\t");
                System.out.print(tablero[x][y] + "\t");
                System.out.print(Reset);
            }else{
                System.out.print(ClorRojo+"\t");
                System.out.print(tablero[x][y] + "\t");
                System.out.print(Reset); 
            }        
        }else if(x==0||x == 2|| x==4||x==6&&y!=8){
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
        }else if(y==8){
            System.out.print("|  "+(x+1));
        }
    }    
}