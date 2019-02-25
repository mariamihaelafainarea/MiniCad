/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
public class Line extends Forme {
    private int xStart;
    private int xStop;
    private int yStart;
    private int yStop;
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
    public int getOpacity() {
        return opacity;
    }
    /**/
    public int getRGB() {
        return RGB;
    }
    /**/
    public void setOpacity(final int opacity) {
        this.opacity = opacity;
    }
    /**/
    public void setRGB(final int rgb) {
        this.RGB = rgb;
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
    public Line(final int xStart, final int yStart, final int xStop,
                final int yStop, final int rgb, final int opacity) {
        super(rgb, opacity);
        this.xStart = xStart;
        this.xStop = xStop;
        this.yStart = yStart;
        this.yStop = yStop;
    }
    public Line() {
    }
    /**/
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
