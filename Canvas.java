/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
public class Canvas extends Forme {
    //clasa care implementeaza fundalul
     private int[][] a = null;
     private int inaltime;
     private int latime;
    /*preia inaltimea*/
    public int getInaltime() {
        return inaltime;
    }
    /*preia latimea*/
    public int getLatime() {
        return latime;
    }
    //tb sa.i pun culorile cum trebuie in constructor
    //ce e mai jos sunt valori particulare;
    //Pentru Singleton Pattern
    public static final Canvas INSTANCE = new Canvas();
    Canvas(final int inaltime, final int latime, final int rgb, final int opacity) {
         a = new int[latime][inaltime];
       this.latime = latime;
       this.inaltime = inaltime;
       this.RGB = rgb;
       this.opacity = opacity;
    }
    public static Canvas getCanvas() {
        return INSTANCE;
    }
    /*am nevoie sa obtin cateodata matricea de pixeli din canvas*/
    public int[][] getMatrice() {
        return a;
    }
    public Canvas() {
    }
    /*alteori setez o anumite matrice de pixeli.*/
    public void setMatrice(final int[][] m) {
        //tb sa ai grija sa trimiti deja color.getRGB
            for (int i = 0; i < latime; i++) {
                for (int j = 0; j < inaltime; j++) {
                    a[j][i] = m[i][j];
                }
            }
    }
    /*alteori setez doar un element*/
    public void setElem(final int x, final int y, final int val) {
        a[x][y] = val;
    }
    /*alteori preiau un element*/
    public int getElem(final int x, final int y) {
        return a[x][y];
    }
    /*metoda tip din Visitor Pattern*/
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
