/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
public class Polygon extends Forme {
    private int nrPuncte;
    private Point[] pointsOfPolygon;
    private int culoareInterior;
    private int opacitateInterior;
    /**/
    public void setRGB(final int RGB) {
        this.RGB = RGB;
    }
    /**/
    public void setPointsOfPolygon(final Point[] pointsOfPolygon) {
        this.pointsOfPolygon = pointsOfPolygon;
    }
    /**/
    public void setOpacity(final int opacity) {
        this.opacity = opacity;
    }
    /**/
    public void setOpacitateInterior(final int opacitateInterior) {
        this.opacitateInterior = opacitateInterior;
    }
    /**/
    public void setNrPuncte(final int nrPuncte) {
        this.nrPuncte = nrPuncte;
    }
    /**/
    public void setCuloareInterior(final int culoareInterior) {
        this.culoareInterior = culoareInterior;
    }
    /**/
    public int getRGB() {
        return RGB;
    }
    /**/
    public Point[] getPointsOfPolygon() {
        return pointsOfPolygon;
    }
    /**/
    public int getNrPuncte() {
        return nrPuncte;
    }
    /**/
    public int getOpacity() {
        return opacity;
    }
    /**/
    public int getOpacitateInterior() {
        return opacitateInterior;
    }
    /**/
    public int getCuloareInterior() {
        return culoareInterior;
    }
    /**/
    public Polygon() {
    }
    public Polygon(final int n, final int[] v, final int culoareMargine,
                   final int opacitateMargine,
                   final int culoareInterior, final int opacitateInterior) {
        nrPuncte = n;
        pointsOfPolygon = new Point[n / 2];
        int count = 0;
        for (int i = 0; i < v.length; i = i + 2) {
            pointsOfPolygon[count] = new Point(v[i], v[i + 1]);
            count++;
        }
        RGB = culoareMargine;
        opacity = opacitateMargine;
        this.culoareInterior = culoareInterior;
        this.opacitateInterior = opacitateInterior;
    }
    /**/
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
