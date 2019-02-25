

class Triangle extends Forme {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int culoareInterna;
    private int opacitateInterna;
    public int getCuloareInterna() {
        return culoareInterna;
    }
    public int getOpacitateInterna() {
        return opacitateInterna;
    }
    public int getOpacity() {
        return opacity;
    }
    public int getRGB() {
        return RGB;
    }
    public int getX1() {
        return x1;
    }
    public int getX2() {
        return x2;
    }
    public int getX3() {
        return x3;
    }
    public int getY1() {
        return y1;
    }
    public int getY2() {
        return y2;
    }
    public int getY3() {
        return y3;
    }
    public void setCuloareInterna(final int culoareInterna) {
        this.culoareInterna = culoareInterna;
    }
    public void setOpacitateInterna(final int opacitateInterna) {
        this.opacitateInterna = opacitateInterna;
    }
    public void setOpacity(final int opacity) {
        this.opacity = opacity;
    }
    public void setRGB(final int RGB) {
        this.RGB = RGB;
    }
    public void setX1(final int x1) {
        this.x1 = x1;
    }
    public void setX2(final int x2) {
        this.x2 = x2;
    }
    public void setX3(final int x3) {
        this.x3 = x3;
    }
    public void setY1(final int y1) {
        this.y1 = y1;
    }
    public void setY2(final int y2) {
        this.y2 = y2;
    }
    public void setY3(final int y3) {
        this.y3 = y3;
    }
    Triangle() {
    }
     Triangle(final int x1, final int y1, final int x2, final int y2,
                    final int x3,  final int y3,  final int rgb,
                    final int opacity,  final int culoareInterna,
                    final  int opacitateInterna) {
        super(rgb, opacity);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.culoareInterna = culoareInterna;
        this.opacitateInterna = opacitateInterna;
        this.RGB = rgb;
        this.opacity = opacity;
    }
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
