/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author maria
 */
public class Main {
    //static int[][] image;
    static String input = null;
    static BufferedReader in = null;
    static BufferedImage pozaObtinuta;
    Forme[] array = null;
    static int inaltime;
    static int latime;
    /*Singurul loc in care citesc inputul*/
    public void citire() throws FileNotFoundException, IOException {
        in = new BufferedReader(new FileReader(input));
        String line = null;
        //CREEZ FABRICA DE ELEMENTE
        line = in.readLine();
        int numarForme = Integer.parseInt(line);
        //System.out.println(numarForme);
        array = new Forme[numarForme];
        int contor = -1;
        while ((line = in.readLine()) != null) {
            contor++;
            String[] vector = line.split(" ");
            if (vector[0].equals(Strategy.CANVAS.toString())) {
                Canvas c = (Canvas) Factory.INSTANCE.creeazaForme(Strategy.CANVAS, vector);
                array[contor] = c;
            } else if (vector[0].equals(Strategy.LINE.toString())) {
                 Line l = (Line) Factory.INSTANCE.creeazaForme(Strategy.LINE, vector);
                 array[contor] = l;
            } else if (vector[0].equals(Strategy.SQUARE.toString())) {
                 Square sq = (Square) Factory.INSTANCE.creeazaForme(Strategy.SQUARE, vector);
                 array[contor] = sq;
            } else if (vector[0].equals(Strategy.RECTANGLE.toString())) {
                 Rectangle r = (Rectangle) Factory.INSTANCE.creeazaForme(Strategy.RECTANGLE,
                         vector);
                 array[contor] = r;
            } else if (vector[0].equals(Strategy.CIRCLE.toString())) {
                 Circle c = (Circle) Factory.INSTANCE.creeazaForme(Strategy.CIRCLE, vector);
                 array[contor] = c;
            } else if (vector[0].equals(Strategy.DIAMOND.toString())) {
                Diamond d = (Diamond) Factory.INSTANCE.creeazaForme(Strategy.DIAMOND, vector);
                array[contor] = d;
            } else if (vector[0].equals(Strategy.TRIANGLE.toString())) {
                Triangle t = (Triangle) Factory.INSTANCE.creeazaForme(Strategy.TRIANGLE, vector);
                array[contor] = t;
            } else if (vector[0].equals(Strategy.POLYGON.toString())) {
                Polygon p = (Polygon) Factory.INSTANCE.creeazaForme(Strategy.POLYGON, vector);
                array[contor] = p;
            }
        }
    }
    private void metodaDesenareForme(final int[][] matrice) {
      Drawer b = new Drawer(matrice);
      for (Forme f: array) {
        //incep sa vizitez obiectele si pentru fiecare obiect
	//in functie de natura lui vizitorul va aplica o anume metoda
          f.accept(b);
      }
    }
    private static String culoare;
    public static void main(final String[] args) throws IOException {
        //etapa de citire;
        input = args[0];
        Main m = new Main();
        m.citire();
        int[][] pixels = ((Canvas) m.array[0]).getMatrice();
        inaltime = ((Canvas) m.array[0]).getInaltime();
        latime = ((Canvas) m.array[0]).getLatime();
        //creez poza
        pozaObtinuta = new BufferedImage(((Canvas) m.array[0]).getLatime(),
                ((Canvas) m.array[0]).getInaltime(), BufferedImage.TYPE_INT_ARGB);
        File f = null;
         m.metodaDesenareForme(((Canvas) m.array[0]).getMatrice());
         //dupa ce am facut toate operatiunile posibile din metoda de mai sus,
	//la sfarsit pun datele din matricea de pixeli in poza.
        try {
             f = new File("drawing.png");
             for (int i = 0; i < latime; i++) {
                 for (int j = 0; j < inaltime; j++) {
                     pozaObtinuta.setRGB(i, j, ((Canvas) m.array[0]).getElem(i, j));
                 }
             }
             ImageIO.write(pozaObtinuta, "png", f);
    } catch (IOException e) {
            System.out.println("Error " +  e);
        }
    }
}
