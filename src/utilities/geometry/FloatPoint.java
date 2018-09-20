//@author alieb
package utilities.geometry;

import java.awt.Point;

public class FloatPoint {
  public float x;
  public float y;
  
  public FloatPoint() {
  }
  
  public FloatPoint(int x, int y) {
    this.x=(float)x;
    this.y=(float)y;
  }
  
  public FloatPoint(double x, double y) {
    this.x=(float)x;
    this.y=(float)y;
  }
  
  public FloatPoint(float x, float y) {
    this.x=x;
    this.y=y;
  }
  
  public FloatPoint(Point point) {
    this.x=(float)point.x;
    this.y=(float)point.y;
  }
  
  public FloatPoint(FloatPoint point) {
    this.x=point.x;
    this.y=point.y;
  }
  
  public boolean isEqual(FloatPoint point) {
    return(this.x==point.x && this.y==point.y);
  }
  
  public void translate(int dx, int dy) {
    this.x=this.x+dx;
    this.y=this.y+dy;
  }
  public void translate(double dx, double dy) {
    this.x=this.x+(float)dx;
    this.y=this.y+(float)dy;
  }
  public void translate(float dx, float dy) {
    this.x=this.x+dx;
    this.y=this.y+dy;
  }
  
  public Point toPoint() {
    return new Point((int)x, (int)y);
  }
  
  public String toString() {
    return "[X:"+x+" Y:"+y+"]";
  }
}
