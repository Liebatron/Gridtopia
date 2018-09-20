package DotPanel.Panels;

import item.control.AbstractController;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

public class DisplayPanel extends DotPanel {
  private AbstractController gridController;

  public DisplayPanel(Point screenSize) {
    super(screenSize);
  }
  
  public void setItemController(AbstractController gridController) {
    this.gridController=gridController;
    gridController.setKeys(getKeys());
  }
  public AbstractController getItemController() {
    return gridController;
  }
  
  //Perform actions which depend on held keys
  public void heldKeys() {
    getItemController().keysHeld();
  }
  
  //For events which need to occur instantaneously
  public void doKeyPress(KeyEvent k) {
    if(k.getKeyCode()==KeyEvent.VK_P) {
      getController().saveImage();
    }
  }
  //For keys whose effect will occur on the next frame
  public void doKeyTyped(KeyEvent k) {
    getItemController().keyTyped(k);
  }
  
  public void rightClick(int x, int y) {
    getItemController().rightClick(x, y); // Right click
  }
  public void middleClick(int x, int y) {
    getItemController().middleClick(x, y);// Middle click
  }
  public void leftClick(int x, int y) {
    getItemController().leftClick(x, y);  // Left click
  }
  
  @Override
  public void paintComponent(Graphics g) {
    try {
      getItemController().draw(g);
    } catch(NullPointerException e) {
      e.printStackTrace();
    }
  }
}