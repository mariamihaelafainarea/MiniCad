/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author maria
 */
public final class Factory implements IFactory {
    private final int three = 3;
    private final int two = 2;
    private final int one = 1;
    private final int four = 4;
    private final int five = 5;
    private final int six = 6;
    private final int seven = 7;
    private final int eight = 8;
    private final int nine = 9;
    private final int ten = 10;
    public static final Factory INSTANCE = new Factory();
    //aici se face singleton pattern prin faptul ca fac
    //privat constructorul si implementez o instanta a clasei
    //o singura data
    private Factory() {
    }
    public Forme creeazaForme(final Strategy s, final String[] vector) {
        if (s == Strategy.CANVAS) {
            //CANVAS <înălțime> <lățime> #RGB A
            String x = vector[three].substring(1);
            int xx = GetColor.getCuloare(x, Integer.parseInt(vector[four]));
            return new Canvas(Integer.parseInt(vector[one]),
                    Integer.parseInt(vector[two]), xx,
                    Integer.parseInt(vector[four]));
            // desi fac RGB cu opacitate, salvez si opacitatea . nu stiu cand imi va trebui
            //CHECKED
        } else if (s == Strategy.LINE) {
            //LINE <coordonata x de start> <coordonata y de start>
            // <coordonata x de final> <coordonata y de final> #RGB A
            String x = vector[five].substring(1);
            int xx = GetColor.getCuloare(x, Integer.parseInt(vector[six]));
            return new Line(Integer.parseInt(vector[1]),
                    Integer.parseInt(vector[2]), Integer.parseInt(vector[three]),
                    Integer.parseInt(vector[four]), xx, Integer.parseInt(vector[six]));
            //CHECKED
        } else if (s == Strategy.SQUARE) {
            //SQUARE <coordonata x a coltului stanga sus>
            //<coordonata y a coltului stanga sus> <dimensiunea unei laturi> #RGB A #RGB A
            int xStgSus = Integer.parseInt(vector[1]);
            int yStgSus = Integer.parseInt(vector[2]);
            int xDrSus = xStgSus + Integer.parseInt(vector[three]) - 1;
            int yStgJos = yStgSus + Integer.parseInt(vector[three]) - 1;
            String x = vector[four].substring(1);
            int xx = GetColor.getCuloare(x, Integer.parseInt(vector[five]));
            int culoareMargine = xx;
            int opacitateMargine = Integer.parseInt(vector[five]);
            x = vector[six].substring(1);
            xx = GetColor.getCuloare(x, Integer.parseInt(vector[seven]));
            int culoareInauntru = xx;
            int opacitateInauntru = Integer.parseInt(vector[seven]);
            return new Square(Integer.parseInt(vector[1]),
                    Integer.parseInt(vector[2]), xDrSus, yStgJos, culoareMargine,
                    opacitateMargine, culoareInauntru, opacitateInauntru);
            //CHECKED
        } else if (s == Strategy.RECTANGLE) {
            // RECTANGLE <coordonata x a coltului stanga sus>
            // <coordonata y a coltului stanga sus>
            // <dimensiunea înălțimii> <dimensiunea lungimii> #RGB A #RGB A
             int xStgSus = Integer.parseInt(vector[1]);
            int yStgSus = Integer.parseInt(vector[2]);
            int xDrSus = xStgSus + Integer.parseInt(vector[four]) - 1;
            int yStgJos = yStgSus + Integer.parseInt(vector[three]) - 1;
            String x = vector[five].substring(1);
            int xx = GetColor.getCuloare(x, Integer.parseInt(vector[six]));
            int culoareMargine = xx;
            int opacitateMargine = Integer.parseInt(vector[six]);
            x = vector[seven].substring(1);
            xx = GetColor.getCuloare(x, Integer.parseInt(vector[eight]));
            int culoareInauntru = xx;
            int opacitateInauntru = Integer.parseInt(vector[eight]);
            return new Rectangle(xStgSus, yStgSus, xDrSus, yStgJos, culoareMargine,
                    opacitateMargine, culoareInauntru, opacitateInauntru);
        } else if (s == Strategy.DIAMOND) {
            // DIAMOND <coordonata x a centrului>
            // <coordonata y a centrului> <dimensiunea diagonalei orizontale>
            // <dimensiunea diagonalei verticale> #RGB A #RGB A
            int xCentru = Integer.parseInt(vector[1]);
            int yCentru = Integer.parseInt(vector[2]);
            int latime = Integer.parseInt(vector[three]);
            int inaltime = Integer.parseInt(vector[four]);
            int xSus = (int) (xCentru);
            int xJos = (int) (xCentru);
            int ySus = (int) (yCentru - Math.floor(inaltime / 2));
            int yJos = (int) (yCentru + Math.floor(inaltime / 2));
            int yDreapta = (int) (yCentru);
            int yStanga = (int) (yCentru);
            int xStanga = (int) (xCentru - Math.floor(latime / 2));
            int xDreapta = (int) (xCentru + Math.floor(latime / 2));
            int culoareMargine;
            int culoareInauntru;
            String x = vector[five].substring(1);
            int xx = GetColor.getCuloare(x, Integer.parseInt(vector[six]));
            culoareMargine = xx;
            x = vector[seven].substring(1);
            xx = GetColor.getCuloare(x, Integer.parseInt(vector[eight]));
            culoareInauntru = xx;
            return new Diamond(xSus, xJos, ySus, yJos, xStanga, xDreapta, yStanga, yDreapta,
                    culoareMargine, Integer.parseInt(vector[six]),
                    culoareInauntru, Integer.parseInt(vector[eight]));
        } else if (s == Strategy.CIRCLE) {
            // CIRCLE <coordonata x a centrului> <coordonata y a centrului> <raza> #RGB A #RGB A
            int culoareMargine;
            int culoareInauntru;
            String x = vector[four].substring(1);
            int xx = GetColor.getCuloare(x, Integer.parseInt(vector[five]));
            culoareMargine = xx;
            x = vector[six].substring(1);
            xx = GetColor.getCuloare(x, Integer.parseInt(vector[seven]));
            culoareInauntru = xx;
        return new Circle(Integer.parseInt(vector[1]), Integer.parseInt(vector[2]),
                Integer.parseInt(vector[three]), culoareMargine,
        Integer.parseInt(vector[five]), culoareInauntru,
        Integer.parseInt(vector[seven]));
        } else if (s == Strategy.TRIANGLE) {
            // TRIANGLE <coordonata x a primului punct> <coordonata y a primului punct>
            //<coordonata x a celui de-al doilea punct>
            //<coordonata y a celui de-al doilea punct> <coordonata x a celui de-al treilea punct>
            //<coordonata y a celui de-al treilea punct> #RGB A #RGB A
            int x1 = Integer.parseInt(vector[1]);
            int y1 = Integer.parseInt(vector[2]);
            int x2 = Integer.parseInt(vector[three]);
            int y2 = Integer.parseInt(vector[four]);
            int x3 = Integer.parseInt(vector[five]);
            int y3 = Integer.parseInt(vector[six]);
            int culoareMargine;
            int culoareInauntru;
            String x = vector[seven].substring(1);
            int xx = GetColor.getCuloare(x, Integer.parseInt(vector[eight]));
            culoareMargine = xx;
            x = vector[nine].substring(1);
            xx = GetColor.getCuloare(x, Integer.parseInt(vector[ten]));
            culoareInauntru = xx;
            return new Triangle(x1, y1, x2, y2, x3, y3,
                    culoareMargine,
                    Integer.parseInt(vector[eight]),
                    culoareInauntru,
                    Integer.parseInt(vector[ten]));
    } else if (s == Strategy.POLYGON) {
        // POLYGON <numarul de puncte> (numarul de puncte) *
            // (<coordonata x a unui punct> <coordonata y a unui punct>) #RGB A #RGB A
        int[] v = new int[2 * Integer.parseInt(vector[1])];
        int n =  2 * Integer.parseInt(vector[1]);
        for (int i = 2; i <= 2 * Integer.parseInt(vector[1]) + 1; i++) {
            v[i - 2] = Integer.parseInt(vector[i]);
        }
            int culoareMargine;
            int culoareInauntru;
            String x = vector[n + 2].substring(1);
            int xx = GetColor.getCuloare(x, Integer.parseInt(vector[n + three]));
            culoareMargine = xx;
            x = vector[n + four].substring(1);
            xx = GetColor.getCuloare(x, Integer.parseInt(vector[n + five]));
            culoareInauntru = xx;
        return new Polygon(n, v, culoareMargine,
                 Integer.parseInt(vector[n + three]),
                 culoareInauntru,
                 Integer.parseInt(vector[n + five]));
        //s-ar putea sa dea seg fault din cauza dimului
        //return null;
    } else {
            throw new IllegalArgumentException("Nu ai furnizat o strategie valida! ");
        }
    }
}
