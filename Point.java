/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
public class Point {
    private int x;
    private int y;
    /**/
    public void setY(final int y) {
        this.y = y;
    }
    /**/
    public void setX(final int x) {
        this.x = x;
    }
    /**/
    public int getY() {
        return y;
    }
    /**/
    public int getX() {
        return x;
    }
    /**/
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}
