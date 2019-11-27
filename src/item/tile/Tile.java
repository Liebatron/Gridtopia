package item.tile;

import item.Item;
import utilities.geometry.FloatPoint;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
/** @author alieb */
public class Tile extends Item {
  private TileGrid container;
  private Image img;
  private Item content=null;
  private int tileSize=0;
  
  public Tile(TileGrid container, Point topRightCorner, int tileSize) {
    setContainer(container);
    setDrawLocation(topRightCorner);
    setLocation(new FloatPoint(topRightCorner));
    this.tileSize=tileSize;
    img = TileImages.getGrassTile();
  }
  
  private void setContainer(TileGrid container) {
    this.container=container;
  }
  public TileGrid getContainer() {
    return container;
  }
  
  public FloatPoint getCenter() {
    return new FloatPoint(getLocation().x+(tileSize/2), getLocation().y+(tileSize/2));
  }
  
  public void setContent(Item content) {
    if(getContent()!=null) {
      getContainer().getTileContents().remove(getContent());
    }
    if(content!=null) {
      getContainer().getTileContents().add(content);
      FloatPoint center = getCenter();
      content.setLocation(new FloatPoint(center.x+content.getTileAdjustment().x, center.y+content.getTileAdjustment().y));
    }
    this.content=content;
  }
  public Item getContent() {
    return content;
  }
  
  public void draw(Graphics g) {
    setDrawLocation(getLocation().toPoint());
    g.fillRect(getDrawLocation().x, getDrawLocation().y, tileSize, tileSize);
    g.drawImage(img, getDrawLocation().x, getDrawLocation().y, null);
    drawContent(g);
  }
  public void drawContent(Graphics g) {
    if(getContent()!=null) {
      getContent().draw(g);
    }
  }
}