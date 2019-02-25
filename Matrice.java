/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
class Matrice {
    private int[][] a;
    private int inaltime;
    private int latime;

    public int getInaltime() {
        return inaltime;
    }

    public int[][] getA() {
        return a;
    }

    public void setA(final int[][] a) {
        this.a = a;
    }

    public void setInaltime(final int inaltime) {
        this.inaltime = inaltime;
    }

    public void setLatime(final int latime) {
        this.latime = latime;
    }

    public int getLatime() {
        return latime;
    }
    /**/
    Matrice() {
    }
    Matrice(final Matrice m) {
        for (int i = 0; i < latime; i++) {
            for (int j = 0; j < inaltime; j++) {
                a[i][j] = m.getElem(i, j);
            }
        }
    }
    Matrice(final int[][] a, final int lat, final int inalt) {
        this.a = a;
        this.latime = lat;
        this.inaltime = inalt;
    }
    Matrice(final int lat, final int inalt) {
        a = new int[lat][inalt];
        this.latime = lat;
        this.inaltime = inalt;
    }
    public int getElem(final int i, final int j) {
        return a[i][j];
    }
    public void setElem(final int i, final int j, final int col) {
        a[i][j] = col;
    }
    public int[][] getMatrice() {
        return a;
    }
}
