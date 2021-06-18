
package Jugador;

public class Jugador {
    private String Nombre;
    private int Victorias;
    private int Derrotas;
    private String FormaFicha;
    private static int[][] Fichas;

    public Jugador(String Nombre, int Victorias, int Derrotas, String FormaFicha) {
        this.Nombre = Nombre;
        this.Victorias = Victorias;
        this.Derrotas = Derrotas;
        this.FormaFicha = FormaFicha;
        LlenarFichas();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getVictorias() {
        return Victorias;
    }

    public void setVictorias(int Victorias) {
        this.Victorias = Victorias;
    }

    public int getDerrotas() {
        return Derrotas;
    }

    public void setDerrotas(int Derrotas) {
        this.Derrotas = Derrotas;
    }

    public String getFormaFicha() {
        return FormaFicha;
    }

    public void setFormaFicha(String FormaFicha) {
        this.FormaFicha = FormaFicha;
    }

    public static int[][] getFichas() {
        return Fichas;
    }

    public static void setFichas(int[][] Fichas) {
        Jugador.Fichas = Fichas;
    }
    
    public void LlenarFichas(){
        this.Fichas = new int[8][8];
        for (int x = 0; x < this.Fichas.length; x++) {
            for (int y = 0; y < Fichas.length; y++) {
                if(x == 0||x==1||x==2){
                    if(x == 1){
                        if(!(y%2==0)){
                            Fichas[x][y] = -1;
                        }else{
                            Fichas[x][y] = 0;
                        }
                    }else{
                        if(y%2==0){
                            Fichas[x][y] = -1;
                        }else{
                            Fichas[x][y] = 0;
                        }
                    }
                
                }else if(x==7||x==6||x==5){
                    if(x==6){
                        if(y%2==0){
                            Fichas[x][y] = 1;
                        }else{
                            Fichas[x][y] = 0;
                        }
                    }else{
                        if(!(y%2==0)){
                            Fichas[x][y] = 1;
                        }else{
                            Fichas[x][y] = 0;
                        }
                    }
                }else{
                    Fichas[x][y] = 0;
                }
            }   
        }
    }
    
    public void ImprimirFichas(){
        for (int x = 0; x < this.Fichas.length; x++) {
            for (int y = 0; y < Fichas.length; y++) {
                System.out.println("posicion: "+x+" "+y+" "+Fichas[x][y]);
            }
        }    
    }
}
