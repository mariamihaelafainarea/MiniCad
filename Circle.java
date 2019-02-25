/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
public class Circle extends Forme {
    private int xCentru;
    private int yCentru;
    private int raza;
    private int culoareInterior;
    private int opacitateInterior;
    /**/
    public int getCuloareInterior() {
        return culoareInterior;
    }
    /**/
    public int getOpacitateInterior() {
        return opacitateInterior;
    }
    /**/
    public int getOpacity() {
        return opacity;
    }
    /**/
    public int getRGB() {
        return RGB;
    }
    /**/
    public int getRaza() {
        return raza;
    }
    /**/
    public int getxCentru() {
        return xCentru;
    }
    /**/
    public int getyCentru() {
        return yCentru;
    }
    /**/
    public void setCuloareInterior(final int culoareInterior) {
        this.culoareInterior = culoareInterior;
    }
    /**/
    public void setOpacitateInterior(final int opacitateInterior) {
        this.opacitateInterior = opacitateInterior;
    }
    /**/
    public void setOpacity(final int opacity) {
        this.opacity = opacity;
    }
    /**/
    public void setRGB(final int RGB) {
        this.RGB = RGB;
    }
    /**/
    public void setRaza(final int raza) {
        this.raza = raza;
    }
    /**/
    public void setxCentru(final int xCentru) {
        this.xCentru = xCentru;
    }
    /**/
    public void setyCentru(final int yCentru) {
        this.yCentru = yCentru;
    }
    public Circle(final int xCentru, final int yCentru, final int raza,
            final int culoareMargine, final int opacitateMargine,
                  final int culoareInterior, final int opacitateInterior) {
        this.xCentru = xCentru;
        this.yCentru = yCentru;
        this.raza = raza;
        this.RGB = culoareMargine;
        this.opacity = opacitateMargine;
        this.culoareInterior = culoareInterior;
        this.opacitateInterior = opacitateInterior;
    }
    /*Metoda din Visitor Pattern*/
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
