/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author maria
 */
final class FloodFill {
    private FloodFill() {
    }
    public static void fillArea(final Matrice picture, final int inaltime,
                                 final int latime, final int x,
                                 final int y, final int borderColor,
                                 final int internColor) {
       if (x < 0 || x > latime
               ||
               y < 0 || y >= inaltime) {
           //(1)
           //verific daca elem curent se afla in limite
            return;
        }
        Queue<Point> queue = new LinkedList<Point>();
        //creez coada
        if (picture.getElem(x, y) == borderColor) {
            // daca pixelul de pe x,y e colorat in borderCOlor e naspa,pleaca
            return;
        }
        queue.add(new Point(x, y)); // adauga primul punct
        Matrice verificareFostaTrece = new Matrice(picture.getLatime(), picture.getInaltime());
        //(2)
	//matricea ma ajuta sa vad ce puncte au fost deja vizitate ca sa nu ma mai intorc acolo
	//fara ea algorimul merge la infinit
        while (!queue.isEmpty()) {
            Point p = queue.remove(); // incep sa ma folosesc de coada
            if (picture.getElem(p.getX(), p.getY()) != borderColor
                    && verificareFostaTrece.getElem(p.getX(), p.getY()) == 0) {
                // cat timp elemetul nu e borderCOlor
               picture.setElem(p.getX(), p.getY(), internColor); // il setez la itern color
               verificareFostaTrece.setElem(p.getX(), p.getY(), 1);
                if (p.getX() - 1 >= 0 && picture.getElem(p.getX() - 1, p.getY()) != borderColor
                        && verificareFostaTrece.getElem(p.getX() - 1, p.getY()) == 0) {
                   //gasit element stanga
                    queue.add(new Point(p.getX() - 1, p.getY()));
                }
                if (p.getX() + 1 < latime && picture.getElem(p.getX() + 1, p.getY()) != borderColor
                        && verificareFostaTrece.getElem(p.getX() + 1, p.getY()) == 0) {
                    queue.add(new Point(p.getX() + 1, p.getY()));
                }
                if (p.getY() - 1 >= 0 && picture.getElem(p.getX(), p.getY() - 1) != borderColor
                        && verificareFostaTrece.getElem(p.getX(), p.getY() - 1) == 0) {
                    queue.add(new Point(p.getX(), p.getY() - 1));
                }
                if (p.getY() + 1 < inaltime
                        && picture.getElem(p.getX(), p.getY() + 1) != borderColor
                        && verificareFostaTrece.getElem(p.getX(), p.getY() + 1) == 0) {
                    //(3) algoritmul functioneaza doar daca pixelul nu are aceasi
	//culoare cu bound-ul
                    queue.add(new Point(p.getX(), p.getY() + 1));
                }
            }
        }
   return;
}
    //algoritmul de floodfill se bazeaza pe faptul ca programul cauta
//puncte ce nu ies din matrice (1), pe care nu le-a vizitat (2)
//si care nu au aceasi culoare cu marginea formei (3).
    public static int[][] incadrator(final Matrice picture,
                                     final int inaltime, final int latime,
                                     final int x, final int y,
                                     final int borderColor,
                                     final int internColor) {
        fillArea(picture, inaltime, latime, x, y, borderColor, internColor);
        return picture.getMatrice();
    }
}
