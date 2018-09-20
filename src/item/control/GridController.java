package item.control;

import DotPanel.Keyboard.Keys;
import item.tile.TileGrid;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
/**@author alieb*/
public interface GridController {
  
  public void start();
  
  public void setGrid(TileGrid grid);
  public TileGrid getGrid();
  
  public void setKeys(Keys keys);
  public Keys getKeys();
  
  public void middleClick(int x, int y);
  public void rightClick(int x, int y);
  public void leftClick(int x, int y);
  
  public void keyTyped(KeyEvent k);
  public void keysHeld();
  
  public void react();
  public void step();
	public void draw(Graphics g);
}