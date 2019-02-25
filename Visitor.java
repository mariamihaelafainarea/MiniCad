/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria
 */

   public interface Visitor {
    void visit(Canvas c);
    void visit(Line l);
    void visit(Square s);
    void visit(Circle c);
    void visit(Polygon p);
    void visit(Diamond d);
    void visit(Rectangle r);
    void visit(Triangle aThis);
}
