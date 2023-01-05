import java.util.Random;

public class GameOfLife {
    private boolean[][] cells;

    // Konstruktoren
    //Erzeugt einen Raster mit Größe size x size
    public GameOfLife(int size){
        if(size < 0) {
            throw new IllegalArgumentException("Die Zahl muss eine natürliche Zahl sein!");
        }
        cells = new boolean[size][size];
    }
    //Erzeugt einen Raster mit Größe size x size und bestimmter Anzahl lebendiger Zellen
    public GameOfLife(int size, int aliveCells){
        if(size < 1){
            throw new IllegalArgumentException("Die Zahl muss eine natürliche Zahl sein!");
        }
        cells = new boolean[size][size];
        init(size, aliveCells);
    }

    // Methode erzeugt einen Raster mit zufällig platzierten lebendigen Zellen
    public void init(int size, int ac){
        if(ac < 0 || ac > size * size){
            System.out.println("Die Anzahl von lebendigen Zellen muss zwischen 0 und "+ (size*size) + " sein!");
            return;
        }
        while (ac > 0){
            Random randomI = new Random();
            Random randomJ = new Random();
            int i = randomI.ints(0,size).findFirst().getAsInt();
            int j = randomJ.ints(0, size).findFirst().getAsInt();
            if(!cells[i][j]){
                cells[i][j] = true;
                ac--;
            }
        }
    }

    // Methode setzt eine Zelle als lebendig
    public void setAliveCell(int i, int j){
        int size = cells.length;
        if(i >= 0 && i < size && j >= 0 && j < size){
            cells[i][j] = true;
        }
        else{
            System.out.println();
            System.out.println("Die Zelle liegt nicht im Raster.");
            System.out.println();
        }
    }

    /* Methode bestimmt Folgezustand für Zelle cells[i][j] aufgrund der
       Belegungen ihrer Nachbarzellen in dem Feld cells */
    public boolean nextState(int i, int j){
        int neighborCounter = 0;
        for (int k = i-1; k <= i+1; k++){
            if(k >= 0 && k < cells.length ){
                for (int h = j-1; h <= j+1; h++){
                if (h >= 0 && h < cells[k].length){
                        if(cells[k][h] && !(k==i && h==j)){
                            neighborCounter++; // es werden alle lebendigen Nachbarn gezählt
                        }
                    }
                }
            }
        }
        // wenn die Zelle lebendig ist und 2 bis 3 Nachbarn hat
        if(cells[i][j] && (neighborCounter == 2 || neighborCounter == 3)){
            return true;
        }
        // wenn die Zelle tot ist und 3 Nachbarn hat
        if(!cells[i][j] && neighborCounter == 3){
            return true;
        }
        return false;
    }

    /* Methode erzeugt ein neues Feld, das die nächste Generation von Zellen
       enthaelt, nachdem die Methode nextState auf alle Zellen des
       Feldes cells angewandt worden ist */
    public void nextGeneration(){
        int size = cells.length;
        boolean[][] newCells = new boolean[size][size];
        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells[i].length; j++){
                newCells[i][j] = nextState(i,j);
            }
        }
        cells = newCells;
    }

    /* Methode erzeugt ein neues Feld, das den Zustand der Zellen enthaelt,
       nachdem die Methode nextGeneration n-mal auf das Feld cells angewandt
       worden ist */
    public void futureGeneration (int n){
        for (int k = 1; k <= n; k++){
            nextGeneration();
            show();
        }
    }

    /* Methode gibt das Feld cells in einer übersichtlichen rechteckigen
      Darstellung */
    public void show(){
        for(int i = 0; i < cells.length; i++ ){
            for (int j = 0; j < cells[i].length; j++){
                System.out.print("|");
                if (cells[i][j]){
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }

}
