
package src.Tablero;

import java.util.Scanner;

public class Jugadas {
    private Scanner sc = new Scanner(System.in);
    private int[] CordFichaComida = new int[2];
    private int[] MovComer = new int[2];
    public Jugadas() {
    }
    public int ConfirmarCordenada(int x, int y, int[][] Fichas){
        switch (Fichas[x][y]) {
            case 1:
                return 1;
            case -1:
                return -1;
            default:
                return 0;
        }
    }
    public Fichas[][] CasillasAMover(String id, Fichas[][] Fichas, int Turno){
        //Cambia los valores de 0 a 2 para poder habilitar el movimiento:
        boolean Llave = true;
        int[] Esquinas= new int[4];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if(Fichas[y][x].getIdentificador().equals("█"+id)){
                    try{
                    Esquinas = CompararEsquinas(x,y,Fichas);
                    }catch(ArrayIndexOutOfBoundsException e){
                    }
                    //Turno del jugador 2:
                    if(Turno==-1){
                        //Columna 1
                        if(Fichas[y][0]==Fichas[y][x]){
                            if(Fichas[y+1][x+1].getFichas()==0){
                                Fichas[y+1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y+1][x+1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x+2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x+2;    
                                    Llave = false;
                                }
                            }
                            //para la esquina supérior izquieda
                            try{
                            if(Fichas[y-1][x+1].getFichas()==0){
                                Fichas[y-1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y-1][x+1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x+2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x+2;
                                    Llave = false;
                                }
                            }
                            //Para la esquina inferior izquierda
                            }catch(ArrayIndexOutOfBoundsException e){
                                try{
                                if(Fichas[y+1][x+1].getFichas()==0){
                                    Fichas[y+1][x+1].setFichas(2);
                                    Llave = false;
                                }else if(Fichas[y+1][x+1].getFichas()==1){
                                    if(PuedeComer(Fichas,y ,x)){
                                        Fichas[y+2][x+2].setFichas(2);
                                        CordFichaComida[0]=y+1;
                                        CordFichaComida[1]=x+1;
                                        MovComer[0]= y+2;
                                        MovComer[1]= x+2;
                                        Llave = false;
                                    }
                                }
                              }catch(ArrayIndexOutOfBoundsException e1){
                                if(Fichas[y-1][x+1].getFichas()==0){
                                    Fichas[y-1][x+1].setFichas(2);
                                    Llave = false;
                                }else if(Fichas[y-1][x+1].getFichas()==1){
                                    if(PuedeComer(Fichas,y ,x)){
                                        Fichas[y-2][x+2].setFichas(2);
                                        CordFichaComida[0]=y-1;
                                        CordFichaComida[1]=x+1;
                                        MovComer[0]= y-2;
                                        MovComer[1]= x+2;
                                        Llave = false;
                                    }
                                }
                            }  
                            }
                            //Columna 8
                        }else if(Fichas[y][7]==Fichas[y][x]){
                            //try para la esquina superior derecha
                        try{
                            if(Fichas[y+1][x-1].getFichas()==0){
                                Fichas[y+1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y+1][x-1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x-2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x-2;
                                    Llave = false;
                                }
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            try{
                                if(Fichas[y+1][x+1].getFichas()==0){
                                    Fichas[y+1][x+1].setFichas(2);
                                    Llave = false;
                                }else if(Fichas[y+1][x+1].getFichas()==1){
                                    if(PuedeComer(Fichas,y ,x)){
                                        Fichas[y+2][x+2].setFichas(2);
                                        CordFichaComida[0]=y+1;
                                        CordFichaComida[1]=x+1;
                                        MovComer[0]= y+2;
                                        MovComer[1]= x+2;
                                        Llave = false;
                                    }
                                }
                            }catch(ArrayIndexOutOfBoundsException e2){
                                if(Fichas[y-1][x+1].getFichas()==0){
                                    Fichas[y-1][x+1].setFichas(2);
                                    Llave = false;
                                }else if(Fichas[y-1][x+1].getFichas()==1){
                                    if(PuedeComer(Fichas,y ,x)){
                                        Fichas[y-2][x+2].setFichas(2);
                                        CordFichaComida[0]=y-1;
                                        CordFichaComida[1]=x+1;
                                        MovComer[0]= y-2;
                                        MovComer[1]= x+2;
                                        Llave = false;
                                    }
                                }
                            }    
                        }        
                            if(Fichas[y-1][x-1].getFichas()==0){
                                Fichas[y-1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y-1][x-1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x-2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x-2;   
                                    Llave = false;
                                }
                            }
                            //Fila 1
                        }else if(Fichas[0][x]==Fichas[y][x]){
                            if(Fichas[y+1][x-1].getFichas()==0){
                                Fichas[y+1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y+1][x-1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x-2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x-2;
                                    Llave = false;
                                }
                            }
                            if(Fichas[y+1][x+1].getFichas()==0){
                                Fichas[y+1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y+1][x+1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x+2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x+2;  
                                    Llave = false;
                                }
                            }
                        //Fila 8    
                        }else if(Fichas[7][x]==Fichas[y][x]){
                            if(Fichas[y-1][x-1].getFichas()==0){
                                Fichas[y-1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y-1][x-1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x-2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x-2;  
                                    Llave = false;
                                }
                            }
                            if(Fichas[y-1][x+1].getFichas()==0){
                                Fichas[y-1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y-1][x+1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x+2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x+2;
                                    Llave = false;
                                }
                            }    
                        //cualquier buena xd    
                        }else{
                            try{
                            if(Esquinas[0]==0){
                                Fichas[y+1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Esquinas[0]==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x-2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x-2; 
                                    Llave = false;
                                }
                            }
                            if(Esquinas[1]==0){
                                Fichas[y+1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Esquinas[1]==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x+2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x+2;  
                                    Llave = false;
                                }
                            }
                            if(Esquinas[2]==0){
                                Fichas[y-1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Esquinas[2]==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x+2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x+2;
                                    Llave = false;
                                }
                            }
                            if(Esquinas[3]==0){
                                Fichas[y-1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Esquinas[3]==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x-2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x-2;
                                    Llave = false;
                                }
                            }
                            }catch(ArrayIndexOutOfBoundsException e){
                                
                            }
                        }
                    //Primer jugador        
                    }else if(Turno==1){
                        //Columna 1
                        if(Fichas[y][0]==Fichas[y][x]){
                            if(Fichas[y-1][x+1].getFichas()==0){
                                Fichas[y-1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y-1][x+1].getFichas()==-1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x+2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x+2;
                                    Llave = false;
                                }
                            }
                            if(Fichas[y+1][x+1].getFichas()==0){
                                Fichas[y+1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y+1][x+1].getFichas()==-1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x+2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x+2;
                                    Llave = false;
                                }
                            }
                        //Columna 8    
                        }else if(Fichas[y][7]==Fichas[y][x]){
                            if(Fichas[y+1][x-1].getFichas()==0){
                                Fichas[y+1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y+1][x-1].getFichas()==-1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x-2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x-2;
                                    Llave = false;
                                }
                            }
                            if(Fichas[y-1][x-1].getFichas()==0){
                                Fichas[y-1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y-1][x-1].getFichas()==-1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x-2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x-2;
                                    Llave = false;
                                }
                            }
                        //Fila 8    
                        }else if(Fichas[7][x]==Fichas[y][x]){
                            if(Fichas[y-1][x-1].getFichas()==0){
                                Fichas[y-1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y-1][x-1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x-2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x-2;
                                    Llave = false;
   
                                }
                            }
                            if(Fichas[y-1][x+1].getFichas()==0){
                                Fichas[y-1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y-1][x+1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x+2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x+2;
                                    Llave = false;
                                }
                            }
                        //Fila 1
                        }else if(Fichas[0][x]==Fichas[y][x]){
                            if(Fichas[y+1][x-1].getFichas()==0){
                                Fichas[y+1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y+1][x-1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x-2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x-2;
                                    Llave = false;
                                }
                            }
                            if(Fichas[y+1][x+1].getFichas()==0){
                                Fichas[y+1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Fichas[y+1][x+1].getFichas()==1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x+2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x+2;
                                    Llave = false;
                                }
                            }
                            //Normal
                        }else{
                            if(Esquinas[0]==0){
                                Fichas[y+1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Esquinas[0]==-1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x-2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x-2; 
                                    Llave = false;
                                }
                            }
                            if(Esquinas[1]==0){
                                Fichas[y+1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Esquinas[1]==-1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y+2][x+2].setFichas(2);
                                    CordFichaComida[0]=y+1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y+2;
                                    MovComer[1]= x+2;
                                    Llave = false;
                                }
                            }
                            if(Esquinas[2]==0){
                                Fichas[y-1][x+1].setFichas(2);
                                Llave = false;
                            }else if(Esquinas[2]==-1){
                                System.out.println("esquina 2");
                            if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x+2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x+1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x+2;
                                    Llave = false;
                                }
                            }
                            if(Esquinas[3]==0){
                                Fichas[y-1][x-1].setFichas(2);
                                Llave = false;
                            }else if(Esquinas[3]==-1){
                                if(PuedeComer(Fichas,y ,x)){
                                    Fichas[y-2][x-2].setFichas(2);
                                    CordFichaComida[0]=y-1;
                                    CordFichaComida[1]=x-1;
                                    MovComer[0]= y-2;
                                    MovComer[1]= x-2;
                                    Llave = false;
                                }
                            }
                        }
                    }    
                }                
            }
        }
        if(Llave){
            return null;
        }
        return Fichas;
    }
        
    public int[] CompararEsquinas(int x, int y, Fichas[][] Fichas){
        int[] Esquinas = new int[4];
        Esquinas[0]=Fichas[y+1][x-1].getFichas();
        Esquinas[1]=Fichas[y+1][x+1].getFichas();
        Esquinas[2]=Fichas[y-1][x+1].getFichas();
        Esquinas[3]=Fichas[y-1][x-1].getFichas();
        return Esquinas;
    }
    
    public Fichas[][] MoverFicha(String id,Fichas[][] Fichas,int Turno){
        int PosAMover[] = new int[2];//X,Y
        int Antiguo[] =new int[2];
        boolean repetir = false;
        boolean Fin = true;
        do{
            do {
                System.out.println("->Ingrese la posicion en x que desea mover su ficha:");
                PosAMover[0] = sc.nextInt()-1;
                sc.reset();
                if (PosAMover[0] < 0 || PosAMover[0] > 7) {
                    System.out.println("Cordenada incorrecta, Intente de [1 a 8]");
                    repetir = true;
                } else {
                    repetir = false;
                }
            } while (repetir);

        do {
            System.out.println("->Ingrese la posicion en y que desea mover su ficha:");
            PosAMover[1] = sc.nextInt()-1;
            sc.reset();
            if (PosAMover[0] < 0 || PosAMover[0] > 8) {
                System.out.println("Cordenada incorrecta, Intente de [1 a 8]");
                repetir = true;
            } else {
                repetir = false;
            }
        } while (repetir);
            if(!(PosAMover[1]==MovComer[0]&&PosAMover[0]==MovComer[1])){
                if(EsLegal(PosAMover[0], PosAMover[1], Fichas)){            
                Antiguo =  CordenadasPorId(id,Fichas);    
                Fichas[PosAMover[1]][PosAMover[0]].setFichas(Turno);
                Fichas[PosAMover[1]][PosAMover[0]].setIdentificador("█"+id);
                Fichas[Antiguo[0]][Antiguo[1]].setFichas(0);
                Fichas[Antiguo[0]][Antiguo[1]].setIdentificador("");
                Fin = false;
                }else{
                System.out.println("Movimiento invalido, siga las reglas del juego.");
                Fin = true;
                }
            }else{
                Antiguo =  CordenadasPorId(id,Fichas);    
                Fichas[PosAMover[1]][PosAMover[0]].setFichas(Turno);
                Fichas[PosAMover[1]][PosAMover[0]].setIdentificador("█"+id);
                Fichas[Antiguo[0]][Antiguo[1]].setFichas(0);
                Fichas[Antiguo[0]][Antiguo[1]].setIdentificador("");
                Fichas[CordFichaComida[0]][CordFichaComida[1]].setFichas(0);
                Fichas[CordFichaComida[0]][CordFichaComida[1]].setIdentificador("");
                Fin = false;
                MovComer = new int[2];
                CordFichaComida = new int[2];
            }
        }while(Fin);
    return Fichas;
    }
    
    public int[] CordenadasPorId(String id,Fichas[][] Fichas){
    int[] XY = new int[2];    
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Fichas[j][i].getIdentificador().equals("█"+id)){
                    XY[0] = j;
                    XY[1] = i;
                }
            }
        }
        return XY;
    }
    public boolean EsLegal(int x, int y, Fichas[][] Fichas){
        if(Fichas[y][x].getFichas()==2){
            return true;
        }else{
        return false;
        }
    }
    public boolean EsComida(int x, int y, Fichas[][] Fichas, int Turno){
        int FichasEnemigas;
            if(Turno==1){
                FichasEnemigas = -1;
            }else{
                FichasEnemigas = 1;
            }
            if(Fichas[y][x].getFichas()==2&&Fichas[y-1][x-1].getFichas()==FichasEnemigas || Fichas[y+1][x-1].getFichas()==FichasEnemigas || Fichas[y-1][x+1].getFichas()==FichasEnemigas || Fichas[y+1][x+1].getFichas()==FichasEnemigas){
                return true;
            }else{
            return false;
        }
    }
    public boolean PuedeComer(Fichas[][] Ficha,int y , int x){
        try{
            if(!(Ficha[y][0]==Ficha[y][x]||Ficha[y][7]==Ficha[y][x]||Ficha[0][x]==Ficha[y][x]||Ficha[7][x]==Ficha[y][x])){
                if(Ficha[y+1][x+1].getFichas()==0||Ficha[y+1][x-1].getFichas()==0||Ficha[y-1][x+1].getFichas()==0||Ficha[y-1][x-1].getFichas()==0){
                    return true;
                }
            }else if(!(Ficha[y][1]==Ficha[y][x]||Ficha[y][6]==Ficha[y][x]||Ficha[1][x]==Ficha[y][x]||Ficha[6][x]==Ficha[y][x])){
                if(Ficha[y+1][x+1].getFichas()==0||Ficha[y+1][x-1].getFichas()==0||Ficha[y-1][x+1].getFichas()==0||Ficha[y-1][x-1].getFichas()==0){
                        return true;
                }
            }
        }catch(ArrayIndexOutOfBoundsException  e){
            try{
                if(Ficha[y+2][x+2].getFichas()==0){
                    return true;
                }
            }catch(ArrayIndexOutOfBoundsException  e1){
                try{
                    if(Ficha[y+2][x-2].getFichas()==0){
                        return true;                        
                    }
                }catch(ArrayIndexOutOfBoundsException  e2){
                    try{
                        if(Ficha[y-2][x+2].getFichas()==0){
                            return true;
                        }
                    }catch(ArrayIndexOutOfBoundsException  e3){
                        try{
                            if(Ficha[y-2][x-2].getFichas()==0){
                                return true;
                            }
                        }catch(ArrayIndexOutOfBoundsException  e4){       
                        }
                    }
                }
            }
        }
        return false;
    }
}
