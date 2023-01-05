import java.util.Scanner;

public class GameTester {

    public static void main(String[] args) {
        int size; // Größe des Rasters
        int activeCells; // Anzahl lebendiger Zellen
        Scanner input = new Scanner(System.in); // liest die Eingabe des Nutzers
        GameOfLife game;
        try {
            System.out.print("Geben Sie die Größe des Feldes ein: ");
            size = Integer.parseInt(input.next());
            game = new GameOfLife(size);
            int m = 0;
            do {
                game.show();
                System.out.println("Wählen Sie eine Zahl aus dem Menü:");
                System.out.println("1 - Anzahl der Zellen bestimmen.");
                System.out.println("2 - Lebendige Zellen einfügen.");
                System.out.println("3 - Nächste Generation zeigen.");
                System.out.println("4 - n Generationen zeigen.");
                System.out.println("5 - Programm beenden.");
                System.out.println();
                m = Integer.parseInt(input.next());
                if (m == 1) {
                    System.out.print("Geben Sie die Anzahl lebendiger Zellen ein: ");
                    activeCells = Integer.parseInt(input.next());
                    game = new GameOfLife(size, activeCells);
                } else if (m == 2) {
                    String s = "";
                    do {
                        System.out.print("Geben Sie die Zelle ein (z.B. 1,5): ");
                        String cell = input.next();
                        if(cell.matches("\\d,\\d")){
                            String[] coord = cell.split(",",2);
                            int i = Integer.parseInt(coord[0]);
                            int j = Integer.parseInt(coord[1]);
                            game.setAliveCell(i,j);
                        }
                        System.out.print("Möchten Sie eine weitere Zelle hinzufügen?(J/N) ");
                        s = input.next();
                    } while (s.equals("J") || s.equals("j"));
                } else if (m == 3){
                    game.nextGeneration();
                } else if (m == 4){
                    System.out.print("Geben Sie die Anzahl der Generationen ein: ");
                    int n = Integer.parseInt(input.next());
                    game.futureGeneration(n-1);
                    game.nextGeneration();
                } else if (m == 5) {
                    System.out.println("Programm wurde beendet.");
                    return;
                } else {
                    System.out.println("Geben Sie eine Zahl von 1 bis 5 ein.");
                }
            } while (m != 5);

        } catch (Exception e) {
            System.out.println("Es muss eine natürliche Zahl sein!");
            return;
        }

        /*
        //Erzeugt ein 20x20-Feld mit 10 lebendigen Zellen
        //GameOfLife game1 = new GameOfLife(20, 10);

        //Erzeugt ein 20x20-Feld
        GameOfLife game1 = new GameOfLife(15);

        //Bipole
        game1.setAliveCell(3,3);
        game1.setAliveCell(3,4);
        game1.setAliveCell(4,4);
        game1.setAliveCell(5,1);
        game1.setAliveCell(6,1);
        game1.setAliveCell(6,2);
        //Block
        game1.setAliveCell(0,0);
        game1.setAliveCell(0,1);
        game1.setAliveCell(1,0);
        game1.setAliveCell(1,1);
        //Blinker
        game1.setAliveCell(0,8);
        game1.setAliveCell(1,8);
        game1.setAliveCell(2,8);
        //Gleiter
        game1.setAliveCell(9,1);
        game1.setAliveCell(10,2);
        game1.setAliveCell(11,0);
        game1.setAliveCell(11,1);
        game1.setAliveCell(11,2);
        //Oktagon
        game1.setAliveCell(7,9);
        game1.setAliveCell(7,10);
        game1.setAliveCell(8,8);
        game1.setAliveCell(8,11);
        game1.setAliveCell(9,7);
        game1.setAliveCell(9,12);
        game1.setAliveCell(10,6);
        game1.setAliveCell(10,13);
        game1.setAliveCell(11,6);
        game1.setAliveCell(11,13);
        game1.setAliveCell(12,7);
        game1.setAliveCell(12,12);
        game1.setAliveCell(13,8);
        game1.setAliveCell(13,11);
        game1.setAliveCell(14,9);
        game1.setAliveCell(14,10);

        game1.setAliveCell(7,7);
        game1.setAliveCell(7,8);
        game1.setAliveCell(7,9);
        game1.setAliveCell(8,7);
        game1.setAliveCell(8,9);
        game1.setAliveCell(9,7);
        game1.setAliveCell(9,9);
        game1.setAliveCell(11,7);
        game1.setAliveCell(11,9);
        game1.setAliveCell(12,7);
        game1.setAliveCell(12,9);
        game1.setAliveCell(13,7);
        game1.setAliveCell(13,8);
        game1.setAliveCell(13,9);


        game1.show();
        game1.futureGeneration(20);
        */
    }
}
