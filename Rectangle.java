/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
public class Rectangle extends Forme {
    private int xStart;
    private int xStop;
    private int yStart;
    private int yStop;
    private int rgbIntern;
    private int opacitateInauntru;
    /**/
    public int getOpacitateInauntru() {
        return opacitateInauntru;
    }
    /**/
    public int getRGB() {
        return RGB;
    }
    /**/
    public int getOpacity() {
        return opacity;
    }
    /**/
    public int getRgbIntern() {
        return rgbIntern;
    }
    /**/
    public int getxStart() {
        return xStart;
    }
    /**/
    public int getxStop() {
        return xStop;
    }
    /**/
    public int getyStart() {
        return yStart;
    }
    /**/
    public int getyStop() {
        return yStop;
    }
    /**/
    public void setOpacitateInauntru(final int opacitateInauntru) {
        this.opacitateInauntru = opacitateInauntru;
    }
    /**/
    public void setOpacity(final int opacity) {
        this.opacity = opacity;
    }
    /**/
    public void setRgbIntern(final int rgbIntern) {
        this.rgbIntern = rgbIntern;
    }
    /**/
    public void setRGB(final int RGB) {
        this.RGB = RGB;
    }
    /**/
    public void setxStart(final int xStart) {
        this.xStart = xStart;
    }
    /**/
    public void setxStop(final int xStop) {
        this.xStop = xStop;
    }
    /**/
    public void setyStart(final int yStart) {
        this.yStart = yStart;
    }
    /**/
    public void setyStop(final int yStop) {
        this.yStop = yStop;
    }
    public Rectangle() {
    }
    //RECTANGLE <coordonata x a coltului stanga sus>
    // <coordonata y a coltului stanga sus>
    // <dimensiunea înălțimii> <dimensiunea lungimii> #RGB A #RGB A
    public Rectangle(final int xStart, final int yStart, final int xStop, final int yStop,
                     final int culoareMargine, final int opacitateMargine,
                     final int culoareInauntru, final int opacitateInauntru) {
        this.xStart = xStart;
        this.xStop = xStop;
        this.yStart = yStart;
        this.yStop = yStop;
        this.RGB = culoareMargine; //RGB = CULOAREA DIN MARGINE
        this.rgbIntern = culoareInauntru;
        this.opacity = opacitateMargine;
        this.opacitateInauntru = opacitateInauntru;
    }
    /**/
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
