import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Quanti libri vuoi aggiungere alla tua libreria?");
        int libriDaAggiungere = Integer.parseInt(scan.nextLine());
        boolean isInputValid;
        Libro[] libreria = new Libro[libriDaAggiungere];
        for (int i = 0; i < libriDaAggiungere; i++) {
            isInputValid = false;
            while (!isInputValid) {
                System.out.println("Titolo: ");
                String titolo = scan.nextLine();
                System.out.println("Autore: ");
                String autore = scan.nextLine();
                System.out.println("Numero pagine: ");
                int pagine = Integer.parseInt(scan.nextLine());
                System.out.println("Editore: ");
                String editore = scan.nextLine();

                try{
                    Libro libro = new Libro(titolo, pagine, autore, editore);
                    libreria[i] = libro;
                    System.out.println("Libro " + libro.getTitolo() + " aggiunto correttamente");
                    isInputValid = true;
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        //Scrivo sul file
        FileWriter fw;
        try {
            fw = new FileWriter("./lista-libri.txt", true);
            for (int i = 0; i < libreria.length; i++) {
                fw.write("Libro n." + (i+1) + " " + libreria[i].toString() + "\n");
                System.out.println(libreria[i]);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Leggo il file
        File miaLibreria = new File("./lista-libri.txt");
        try {
            Scanner bookReader = new Scanner(miaLibreria);
            while(bookReader.hasNextLine()){
                String line = bookReader.nextLine();
                System.out.println(line);
            }
            bookReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found at specified location.");
        }


    }
}