/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */
abstract class Forme implements Visitable {
    int RGB;
    int opacity;
    Forme(final int RGB, final int opacity) {
        this.RGB = RGB;
        this.opacity = opacity;
    }
    Forme() {
    }
}
