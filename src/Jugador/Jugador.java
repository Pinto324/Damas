
package src.Jugador;

import src.Menu.IngresarDatos;

public class Jugador {
    private String Nombre;
    private int Id;
    private int Victorias;
    private int Derrotas;
    private String Color;
    private IngresarDatos Datos;
    private int ContadorJugadores = 1;
    
    public Jugador(String Nombre, int id, int Victorias, int Derrotas, String Color) {
        this.Nombre = Nombre;
        this.Id = id;
        this.Victorias = Victorias;
        this.Derrotas = Derrotas;
        this.Color = Color;
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
        return Color;
    }

    public void setFormaFicha(String FormaFicha) {
        this.Color = FormaFicha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String datosJugador(){
        String tmp = ("Id: "+ContadorJugadores+"  Jugador: " + Nombre + " Partidas Ganadas: " + Victorias + " Partidas Perdidas: " + Derrotas);
        ContadorJugadores++;
        return tmp;  
    }
    
    public void listadoJugadores(Jugador[] listadoJugadores){
        for (int i = 0; i < listadoJugadores.length; i++) {
            if (listadoJugadores[i]!=null) {
                System.out.println(listadoJugadores[i].datosJugador());
            }else{
                System.out.println("Espacio Disponible");
            }
        }
    }
    
}
