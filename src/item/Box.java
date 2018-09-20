package item;
//@author alieb
import utilities.geometry.FloatPoint;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Box extends Item {
  private int size=8; // Original Size should be 8;
  private Rectangle rectangle;
  private static final Color brown = new Color(150, 80, 0);
  private static final Color darkBrown = brown.darker().darker();
  
  public Box() {
    super(new Point(0,0));
    setLocation(new FloatPoint(getOrigin()));
    setDrawLocation(getLocation().toPoint());
    rectangle=new Rectangle(getLocation().toPoint().x, getLocation().toPoint().y, getSize(), getSize());
    setTileAdjustment(new Point(-getSize()/2, -getSize()/2));
  }
  public Box(int size) {
    super(new Point(0,0));
    setSize(size);
    setLocation(new FloatPoint(getOrigin()));
    setDrawLocation(getLocation().toPoint());
    rectangle=new Rectangle(getLocation().toPoint().x, getLocation().toPoint().y, getSize(), getSize());
    setTileAdjustment(new Point(-getSize()/2, -getSize()/2));
  }
  public Box(Point location, int size) {
    super(location);
    setSize(size);
    setLocation(new FloatPoint(location));
    setDrawLocation(location);
    rectangle=new Rectangle(getLocation().toPoint().x, getLocation().toPoint().y, getSize(), getSize());
    setTileAdjustment(new Point(-getSize()/2, -getSize()/2));
  }
  public Box(Point location) {
    super(location);
    setLocation(new FloatPoint(location));
    setDrawLocation(location);
    rectangle=new Rectangle(getLocation().toPoint().x, getLocation().toPoint().y, getSize(), getSize());
    setTileAdjustment(new Point(-getSize()/2, -getSize()/2));
  }
  
  public Rectangle getRectangle() {
    return rectangle;
  }
  
  public void setSize(int size) {
    this.size=size;
  }
  public int getSize() {
    return size;
  }
  
  public void step() {
  }
  public void draw(Graphics g) {
    setDrawLocation(getLocation().toPoint());//In case it moves
    g.setColor(brown);
    g.fillRect(getDrawLocation().x, getDrawLocation().y, size, size);
    g.setColor(darkBrown);
    g.drawLine(getDrawLocation().x, getDrawLocation().y, getDrawLocation().x+size, getDrawLocation().y+size);
    g.drawLine(getDrawLocation().x, getDrawLocation().y+size, getDrawLocation().x+size, getDrawLocation().y);
    g.setColor(Color.BLACK);
    g.drawRect(getDrawLocation().x, getDrawLocation().y, size, size);
  }
}