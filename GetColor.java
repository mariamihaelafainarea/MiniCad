/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;

/**
 *
 * @author maria
 */
final class GetColor {
    private GetColor() {
    }
    //clasa imi obtine in "int" numarul care reprezinta culoarea
    //primita ca parametru printr-un string.
    public static int getCuloare(final String culoare, final int opacitate) {
        final int saispe = 16;
        final int opt = 8;
        final int sase = 6;
        final int patru = 4;
        String culUpper = culoare.toUpperCase();
        int culoareDomne;
        int r =  Integer.valueOf(culUpper.substring(0, 2), saispe);
        int g =  Integer.valueOf(culUpper.substring(2, patru), saispe);
        int b =  Integer.valueOf(culUpper.substring(patru, sase), saispe);
        Color culoareC = new Color(r, g, b, opacitate);
        int col = culoareC.getRGB();
        return col;
    }
    public static void main(final String[] args) {
        String c = new String("FF00FF");
    }
}
