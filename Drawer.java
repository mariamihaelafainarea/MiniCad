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
public class Drawer implements Visitor {
    static int[][] poza = null;
    static int inal;
    static int lat;
    private final int opt = 8;
    private final int trei = 3;
    private final int patru = 4;
    private final int sase = 6;
    private final int ff = 0xFF;
    private final int saispe = 16;
    private final int zece = 10;
    //algoritm de generare a culorii
    public Drawer(final int[][] poza) {
        this.poza = poza;
    }
    public static int[][] drawCircle(final int xc, final int yc,
                                     final int x, final int y, final int col) {
        //la cerc nu mai pot aplica bresenham asa ca fac
        //alt algoritm
    if (xc + x < lat && xc + x >= 0
            && yc + y < inal && yc + y >= 0) {
        poza[xc + x][yc + y] = col;
    }
    if (xc - x < lat && xc - x >= 0
            && yc + y < inal && yc + y >= 0) {
        poza[xc - x][yc + y] = col;
    }
    if (xc + x < lat && xc + x >= 0
            && yc - y < inal && yc - y >= 0) {
        poza[xc + x][yc - y] = col;
    }
    if (xc - x < lat && xc - x >= 0
            && yc - y < inal && yc - y >= 0) {
        poza[xc - x][yc - y] = col;
    }
    if (xc + y < lat && xc + y >= 0
            && yc + x < inal && yc + x >= 0) {
        poza[xc + y][yc + x] = col;
    }
    if (xc - y < lat && xc - y >= 0
            && yc + x < inal && yc + x >= 0) {
        poza[xc - y][yc + x] = col;
    }
    if (xc + y < lat && xc + y >= 0
            && yc - x < inal && yc - x >= 0) {
        poza[xc + y][yc - x] = col;
    }
    if (xc - y < lat && xc - y >= 0
            && yc - x < inal && yc - x >= 0) {
        poza[xc - y][yc - x] = col;
    }
    return poza;
}
    public static int[][] bresenham(final int x1, final int y1,
                                    final int x2, final int y2,
                                    final int rgba) {
    // initialize variables
    //Acesta este algorimul de desenare a liniilor
    //pe baza punctelor de mai sus.
    int x = x1;
    int y = y1;
    int deltaX = Math.abs(x2 - x1);
    int deltaY = Math.abs(y2 - y1);
    int s1 = (int) Math.signum(x2 - x1);
    int s2 = (int) Math.signum(y2 - y1);
    // interchange deltaX and deltaY, depending on the slope of the line
    boolean interchanged;
    if (deltaY > deltaX) {
        int aux = deltaX;
        deltaX = deltaY;
        deltaY = aux;
        interchanged = true;
    } else {
            interchanged = false;
                }
    // initialize the error term to compensate for a nonzero intercept
    int error = 2 * deltaY - deltaX;
    for (int i = 0; i <= deltaX; i++) {
          int col = rgba;
     if (x >= 0 && y >= 0 && x < lat && y < inal) {
         poza[x][y] = col;
     }
     // System.out.println(col);
        while (error > 0) {
            if (interchanged) {
                x = x + s1;
            } else {
                y = y + s2;
            }
            error = error - 2 * deltaX;
                    }

        if (interchanged) {
            y = y + s2;
        } else {
            x = x + s1;
        }
        error = error + 2 * deltaY;
                }
    return poza;
}
    /*Metoda de vizitare a obiectului din Visitor Pattern*/
    @Override
    public void visit(final Canvas c) {
        //desenare Canvas
        int culoareDomne = c.RGB;
        inal = c.getInaltime();
        lat = c.getLatime();
        int r = (culoareDomne >> saispe) & ff;
        int g = (culoareDomne >> opt) & ff;
        int b = culoareDomne & ff;
        Color culoareC = new Color(r, g, b, c.opacity);
        int col = culoareC.getRGB();
        for (int i = 0; i < c.getLatime(); i++) {
            for (int j = 0; j < c.getInaltime(); j++) {
                    c.setElem(i, j, col);
            }
            }
    }
    /*Metoda de vizitare a obiectului din Visitor Pattern*/
    @Override
    public void visit(final Line l) {
       //desenare Linie
       int culoareDomne = l.RGB;
       int opac = l.opacity;
       int col = culoareDomne;
       poza = bresenham(l.getxStart(), l.getyStart(), l.getxStop(), l.getyStop(), col);
       //LINIA E CONSTRUITA BINE
    }
    /*Metoda de vizitare a obiectului din Visitor Pattern*/
    @Override
    public void visit(final Square s) {
        //creez exteriorul momentan . Flood fill-ul va fi dupa;
       int culoareDomne = s.RGB;
       int col = culoareDomne;
       poza = bresenham(s.getxStart(), s.getyStart(), s.getxStop(), s.getyStart(), col);
       poza = bresenham(s.getxStart(), s.getyStart(), s.getxStart(), s.getyStop(), col);
       poza = bresenham(s.getxStart(), s.getyStop(), s.getxStop(), s.getyStop(), col);
       poza = bresenham(s.getxStop(), s.getyStop(), s.getxStop(), s.getyStart(), col);
       Matrice m = new Matrice(poza, lat, inal);
       poza = FloodFill.incadrator(m, inal, lat, s.getxStart() + 1,
               s.getyStart() + 1, s.RGB, s.getRgbIntern());
    }
    /*Metoda de vizitare a obiectului din Visitor Pattern*/
    @Override
    public void visit(final Circle c) {
        //Desenare Cerc
        int culoareDomne = c.RGB;
        int col = culoareDomne;
        int d = trei - 2 * c.getRaza();
        int x = 0;
        int y = c.getRaza();
        while (y >= x) {
        // for each pixel we will
        // draw all eight pixels
        poza = drawCircle(c.getxCentru(), c.getyCentru(), x, y, col);
        x++;
        // check for decision parameter
        // and correspondingly
        // update d, x, y
        if (d > 0) {
            y--;
            d = d + patru * (x - y) + zece;
        } else {
            d = d + patru * x + sase;
        }
        poza = drawCircle(c.getxCentru(), c.getyCentru(), x, y, col);
        }
        Matrice m = new Matrice(poza, lat, inal);
       poza = FloodFill.incadrator(m, inal, lat, c.getxCentru(),
               c.getyCentru(), c.RGB, c.getCuloareInterior());
    }
    /*Metoda de vizitare a obiectului din Visitor Pattern*/
    @Override
    public void visit(final Polygon p) {
        //Desenare Polygon
        int culoareDomne = p.RGB;
        int col = culoareDomne;
        int suma1 = 0;
        int suma2 = 0;
        for (int i = 0; i < p.getNrPuncte() / 2 - 1; i++) {
            int xStart = p.getPointsOfPolygon()[i].getX();
            int yStart = p.getPointsOfPolygon()[i].getY();
            int xStop = p.getPointsOfPolygon()[i + 1].getX();
            int yStop = p.getPointsOfPolygon()[i + 1].getY();
            suma1 = suma1 + xStart + xStop;
            suma2 = suma2 + yStart + yStop;
            poza = bresenham(xStart, yStart, xStop, yStop, col);
       }
            int xStart = p.getPointsOfPolygon()[p.getNrPuncte() / 2 - 1].getX();
            int yStart = p.getPointsOfPolygon()[p.getNrPuncte() / 2 - 1].getY();
            int xStop = p.getPointsOfPolygon()[0].getX();
            int yStop = p.getPointsOfPolygon()[0].getY();
            suma1 = suma1 + xStart + xStop;
            suma2 = suma2 + yStart + yStop;
            int xG = 0;
            int yG = 0;
            for (int i = 0; i < p.getNrPuncte() / 2; i++) {
                xStart = p.getPointsOfPolygon()[i].getX();
                yStart = p.getPointsOfPolygon()[i].getY();
            xG = xG + xStart;
            yG = yG + yStart;
       }
            xG = xG / (p.getNrPuncte() / 2);
            yG = yG / (p.getNrPuncte() / 2);
             poza = bresenham(xStart, yStart, xStop, yStop, col);
             Matrice m = new Matrice(poza, lat, inal);
            poza = FloodFill.incadrator(m, inal, lat, xG, yG, p.RGB, p.getCuloareInterior());
    }
    /*Metoda de vizitare a obiectului din Visitor Pattern*/
    @Override
    public void visit(final Diamond d) {
        //Desenare Romb
        int culoareDomne = d.RGB;
       int col = culoareDomne;
       poza = bresenham(d.getxSus(), d.getySus(), d.getxDreapta(), d.getyDreapta(), col);
       poza = bresenham(d.getxDreapta(), d.getyDreapta(), d.getxJos(), d.getyJos(), col);
       poza = bresenham(d.getxJos(), d.getyJos(), d.getxStanga(), d.getyStanga(), col);
       poza = bresenham(d.getxSus(), d.getySus(), d.getxStanga(), d.getyStanga(), col);
       Matrice m = new Matrice(poza, lat, inal);
       poza = FloodFill.incadrator(m, inal, lat, (d.getxSus() + d.getxJos()) / 2,
               (d.getySus() + d.getyJos()) / 2, d.RGB, d.getCuloareInauntru());
    }
    /*Metoda de vizitare a obiectului din Visitor Pattern*/
    @Override
    public void visit(final Rectangle r) {
        //Desenare Dreptunghi
       int culoareDomne = r.RGB;
       int col = culoareDomne;
       poza = bresenham(r.getxStart(), r.getyStart(), r.getxStop(), r.getyStart(), col);
       poza = bresenham(r.getxStart(), r.getyStart(), r.getxStart(), r.getyStop(), col);
       poza = bresenham(r.getxStart(), r.getyStop(), r.getxStop(), r.getyStop(), col);
       poza = bresenham(r.getxStop(), r.getyStop(), r.getxStop(), r.getyStart(), col); //aci
       Matrice m = new Matrice(poza, lat, inal);
       poza = FloodFill.incadrator(m, inal, lat, r.getxStart() + 1,
               r.getyStart() + 1, r.RGB, r.getRgbIntern());
    }
    /*Metoda de vizitare a obiectului din Visitor Pattern*/
    @Override
    public void visit(final Triangle r) {
       //Desenare Triunghi
       int culoareDomne = r.RGB;
       int col = culoareDomne;
       poza = bresenham(r.getX1(), r.getY1(), r.getX2(), r.getY2(), col);
       poza = bresenham(r.getX2(), r.getY2(), r.getX3(), r.getY3(), col);
        poza = bresenham(r.getX3(), r.getY3(), r.getX1(), r.getY1(), col);
      Matrice m = new Matrice(poza, lat, inal);
       poza = FloodFill.incadrator(m, inal, lat,
               (r.getX1() + r.getX2() + r.getX3()) / trei,
               (r.getY1() + r.getY2() + r.getY3()) / trei, r.RGB, r.getCuloareInterna());
    }
}
