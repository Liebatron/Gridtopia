package item.control;

import DotPanel.Keyboard.K;
import DotPanel.Keyboard.Keys;
import DotPanel.Panels.DisplayPanel;
import java.awt.Graphics;
import java.awt.Point;
import item.tile.TileGrid;
import java.awt.event.KeyEvent;
public abstract class AbstractController implements GridController {
  private DisplayPanel containerPanel;
  private TileGrid grid;
  private Keys keys;
  
  public AbstractController() {
  }
  
  public void start() {
  }
  
  public void setContainerPanel(DisplayPanel panel) {
    this.containerPanel=panel;
  }
  public DisplayPanel getContainerPanel() {
    return containerPanel;
  }
  
  public void setGrid(TileGrid grid) {
    this.grid=grid;
  }
  public TileGrid getGrid() {
    return grid;
  }
  
  public void setKeys(Keys keys) {
    this.keys=keys;
  }
  public Keys getKeys() {
    return keys;
  }
  
  public void middleClick(int x, int y) {
    Point click = new Point(x, y);
    //Perform an action in response to a middle click
  }
  public void rightClick(int x, int y) {
    Point click = new Point(x, y);
    //Perform an action in response to a right click
  }
  public void leftClick(int x, int y) {
    Point click = new Point(x, y);
    //Perform an action in response to a left click
  }
  
  public void keyTyped(KeyEvent k) {
    if(k.getKeyChar()==' ') {
      //Space was typed
    }
  }
  
  public void keysHeld() {
    //Respond to any keyholds being performed
    if(keys.held(K.SPACE)) {
      //Space is being held
    }
  }
  
  public void react() {
    //Calculate any reactions that tracked objects will have, but do not advance through time
    
    //For example, if a 'Person' object is standing in lava, set the person's
    //temperature to a billion degrees, but don't *kill* the person yet
    
    //Or, if a person sees a cake, change the person's momentum so they are
    //moving towards the cake, but don't actually *move* them yet.

    //The actual change in state should happen when "step" is called
  }
  
  public void step() {
    //Do the things which will progress tracked objects to the next frame
  }
  
	public void draw(Graphics g) {
    //Draw the next frame
    getGrid().draw(g);
  }
}