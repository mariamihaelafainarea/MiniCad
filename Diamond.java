

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maria
 */
public class Diamond extends Forme {
    private int xSus;
    private int xJos;
    private int ySus;
    private int yJos;
    private int xStanga;
    private int xDreapta;
    private int yStanga;
    private int yDreapta;
    private int culoareInauntru;
    private int opacitateInauntru;
    /**/
    public int getySus() {
        return ySus;
    }
    /**/
    public void setySus(final int ySus) {
        this.ySus = ySus;
    }
    /**/
    public void setyStanga(final int yStanga) {
        this.yStanga = yStanga;
    }
    /**/
    public void setyJos(final int yJos) {
        this.yJos = yJos;
    }
    /**/
    public void setyDreapta(final int yDreapta) {
        this.yDreapta = yDreapta;
    }
    /**/
    public void setxSus(final int xSus) {
        this.xSus = xSus;
    }
    /**/
    public void setxStanga(final int xStanga) {
        this.xStanga = xStanga;
    }
    /**/
    public void setxJos(final int xJos) {
        this.xJos = xJos;
    }
    /**/
    public void setxDreapta(final int xDreapta) {
        this.xDreapta = xDreapta;
    }
    /**/
    public void setRGB(final int RGB) {
        this.RGB = RGB;
    }
    /**/
    public void setOpacity(final int opacity) {
        this.opacity = opacity;
    }
    /**/
    public void setOpacitateInauntru(final int opacitateInauntru) {
        this.opacitateInauntru = opacitateInauntru;
    }
    /**/
    public void setCuloareInauntru(final int culoareInauntru) {
        this.culoareInauntru = culoareInauntru;
    }
    /**/
    public int getyStanga() {
        return yStanga;
    }
    /**/
    public int getxSus() {
        return xSus;
    }
    /**/
    public int getyJos() {
        return yJos;
    }
    /**/
    public int getyDreapta() {
        return yDreapta;
    }
    /**/
    public int getxStanga() {
        return xStanga;
    }
    /**/
    public int getxJos() {
        return xJos;
    }
    /**/
    public int getxDreapta() {
        return xDreapta;
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
    public int getOpacitateInauntru() {
        return opacitateInauntru;
    }
    /**/
    public int getCuloareInauntru() {
        return culoareInauntru;
    }
    public Diamond() {
    }
    public Diamond(final int xSus, final int xJos, final int ySus, final int yJos,
                   final int xStanga, final int xDreapta, final int yStanga, final
                   int yDreapta, final int culoareMargine, final int opacitateMargine,
            final int culoareInauntru, final int opacitateInauntru) {
        this.xSus = xSus;
        this.xJos = xJos;
        this.xStanga = xStanga;
        this.xDreapta = xDreapta;
        this.ySus = ySus;
        this.yJos = yJos;
        this.yStanga = yStanga;
        this.yDreapta = yDreapta;
        RGB = culoareMargine;
        opacity = opacitateMargine;
        this.culoareInauntru = culoareInauntru;
        this.opacitateInauntru = opacitateInauntru;
    }
    /*Metoda din Visitor Pattern*/
    public void accept(final Visitor v) {
       v.visit(this);
    }
}
