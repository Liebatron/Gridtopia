package item;

import item.control.AbstractController;
import utilities.geometry.FloatPoint;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
/** @author alieb */
public class Item {
  private Point origin;
  private FloatPoint location;
  private Point drawLocation;
  private Point tileAdjustment=new Point(0,0);
  protected static Random random = new Random();
  
  public Item() {
    setOrigin(new Point(0, 0));
  }
  public Item(Point origin) {
    setOrigin(origin);
  }
  
  private void setOrigin(Point origin) {
    this.origin=origin;
  }
  public Point getOrigin() {
    return origin;
  }
  
  public FloatPoint getLocation() {
    return location;
  }
  public void setLocation(FloatPoint location) {
    this.location=location;
  }
  
  public Point getDrawLocation() {
    return drawLocation;
  }
  public void setDrawLocation(Point drawLocation) {
    this.drawLocation=drawLocation;
  }
  
  public void setTileAdjustment(Point tileAdjustment) {
    this.tileAdjustment=tileAdjustment;
  }
  public Point getTileAdjustment() {
    return tileAdjustment;
  }
  
  //All reactions should be calculated prior to executing the step
  public void react(AbstractController controller) {
  }
  public void react() {
  }
  //All steps should be carried out before anything is drawn
  public void step(){
  }
  //Only draw when all items have stepped and the final frame state is known
  public void draw() {
  }
  public void draw(Graphics g) {
  }
}
