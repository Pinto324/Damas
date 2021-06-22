
package src.Tablero;

import src.Jugador.Jugador;
import java.util.Scanner;

public class Partida {
    private Jugador Jugador1;
    private Jugador Jugador2;
    private Tablero Tablero;
    private int Contador = 0;
    private Jugadas Jugadas = new Jugadas();
    private int Turno = 0;
    private Fichas[][] Fichas = new Fichas[8][8];
    private Scanner sc = new Scanner(System.in);
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
    
        public void jugar() {
            this.Tablero.DibujarTablero(Jugador1.getNombre(), Jugador2.getNombre());
            do {
                ColocarFichas(Jugador1, Jugador2);
                Turno = 1;
                Fichas = Jugadas.MoverFicha(PedirIdFicha(Jugador1,Turno),Fichas,Turno);
                ColocarFichas();
                LipiarPosi();
                this.Tablero.DibujarTablero();
                    if (SeGano()==1) {
                        Premio(Jugador1,Jugador2);
                        
                        break;
                    }
                Turno = -1;
                Jugadas.MoverFicha(PedirIdFicha(Jugador2,Turno),Fichas,Turno);
                ColocarFichas();
                LipiarPosi();
                this.Tablero.DibujarTablero();
            } while (false);
                Premio(Jugador2,Jugador1);
        }
        
        public void Premio(Jugador J, Jugador Perdedor){
            System.out.println("FELICIDADES JUGADOR: " + J.getNombre() + " HAS GANADO");
            J.setVictorias(1+J.getVictorias());
            Perdedor.setDerrotas(Perdedor.getDerrotas()+1);
            String start = sc.nextLine();
            sc.reset();
            
        }
        
    public void LlenarFichas(int Color){
        String Id;
        if(Color==1){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Fichas[x][y] = new Fichas(0,"");
                if(x==0||x==1||x==2){
                    if(x == 1){
                        if(!(y%2==0)){
                            this.Fichas[x][y].setFichas(-1);
                            Id = "█"+ AsignarID();
                            Fichas[x][y].setIdentificador(Id);
                        }
                    }else{
                        if(y%2==0){
                            this.Fichas[x][y].setFichas(-1);
                            Id = "█"+ AsignarID();
                            Fichas[x][y].setIdentificador(Id);
                        }
                    }
                }else if(x==7||x==6||x==5){
                    if(x==6){
                        if(y%2==0){
                            this.Fichas[x][y].setFichas(1);
                            Id = "█"+ AsignarID();
                            Fichas[x][y].setIdentificador(Id);
                        }
                    }else{
                        if(!(y%2==0)){
                            this.Fichas[x][y].setFichas(1);
                            Id = "█"+ AsignarID();
                            Fichas[x][y].setIdentificador(Id);
                        }
                    }
                }
            }   
        }
        }else{
         for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Fichas[x][y] = new Fichas(0,"");
                if(x==0||x==1||x==2){
                    if(x == 1){
                        if(y%2==0){
                            this.Fichas[x][y].setFichas(-1);
                            Id = "█"+ AsignarID();
                            Fichas[x][y].setIdentificador(Id);
                        }
                    }else{
                        if(!(y%2==0)){
                            this.Fichas[x][y].setFichas(-1);
                            Id = "█"+ AsignarID();
                            Fichas[x][y].setIdentificador(Id);
                        }
                    }
                }else if(x==7||x==6||x==5){
                    if(x==6){
                        if(!(y%2==0)){
                            this.Fichas[x][y].setFichas(1);
                            Id = "█"+ AsignarID();
                            Fichas[x][y].setIdentificador(Id);
                        }
                    }else{
                        if(y%2==0){
                            this.Fichas[x][y].setFichas(1);
                            Id = "█"+ AsignarID();
                            Fichas[x][y].setIdentificador(Id);
                        }
                    }
                }
            }   
        }
        }
    }
    public String AsignarID(){
    String[] ID ={"A1","A2","A3","A4","B1","B2","B3","B4","C1","C2","C3","C4","X1","X2","X3","X4","Y1","Y2","Y3","Y4","Z1","Z2","Z3","Z4"};
        Contador++;
        return ID[Contador-1];        
    }
  
    //Se llenan las casillas con el identificador de su ficha:
    public void ColocarFichas(Jugador Jugador1, Jugador Jugador2){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if(Fichas[x][y].getFichas()==1){
                    this.Tablero.getTablero()[x][y] = Jugador1.getFormaFicha()+Fichas[x][y].getIdentificador();
                }else if(Fichas[x][y].getFichas()==-1){
                     this.Tablero.getTablero()[x][y] = Jugador2.getFormaFicha()+Fichas[x][y].getIdentificador();
                }else{
                    this.Tablero.getTablero()[x][y] = "";
                }
            }            
        }
    }
    public void ColocarFichas(){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if(Fichas[x][y].getFichas()==1){
                    this.Tablero.getTablero()[x][y] = Jugador1.getFormaFicha()+Fichas[x][y].getIdentificador();
                }else if(Fichas[x][y].getFichas()==-1){
                     this.Tablero.getTablero()[x][y] = Jugador2.getFormaFicha()+Fichas[x][y].getIdentificador();
                }else{
                    this.Tablero.getTablero()[x][y] = "";
                }
            }            
        }
    }
    public String PedirIdFicha(Jugador J, int Turno){
        boolean repetir = true;
        boolean Error = true;
        String Id= "";
        do{
        System.out.println("\nTurno de  " + J.getNombre());
        System.out.println("->Ingrese el Id de la ficha que quiere mover:");
        Id = sc.nextLine();
        sc.reset();
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if(Fichas[x][y].getIdentificador().equals("█"+Id)){
                        if(Fichas[x][y].getFichas()==Turno){
                        Error = false;
                        repetir = false;
                        Fichas[][] A = Jugadas.CasillasAMover(Id,Fichas,Turno);
                            if(!(A==null)){
                                Fichas = A;
                            }else{
                                System.out.println("\nLa ficha seleccionada no tiene movimientos disponibles, seleccione otra porfavor"); 
                                repetir = true;
                                Error = false;
                            }
                        }else{
                        System.out.println("No se puede utilizar la ficha del adversario");
                        repetir = true;
                        Error = false;
                        }
                    }
                }
            }   
            if(Error){
                System.out.println("No se encontró el id ingresado, vuelva a intentarlo");   
            }
            Error = true;
        }while(repetir);    
        return Id;
    }
    public void LipiarPosi(){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if(Fichas[x][y].getFichas()==2){
                    Fichas[x][y].setFichas(0);
                }
            }   
        }
    }
    public int SeGano(){
        int ContadorJ1 = 0;
        int ContadorJ2 = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if(Fichas[x][y].getFichas() == 1){
                    ContadorJ1++;
                }else if(Fichas[x][y].getFichas() == -1){
                    ContadorJ2++;
                }
            }
        }
        if(ContadorJ1==0){
            return -1;
        }else if(ContadorJ2==0){
            return 1;
        }else if(ContadorJ1==1&&ContadorJ2==1){
            return 0;
        }
        return 10;
    }
}
