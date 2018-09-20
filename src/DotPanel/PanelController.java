package DotPanel;

import item.control.AbstractController;
import DotPanel.Panels.DisplayPanel;
import item.tile.TileGrid;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/** @author alieb */
public class PanelController {
  private DisplayPanel display;
  private Timer timer = null;
  
  public PanelController() {
  }
  
  public void setDisplay(DisplayPanel display) {
    this.display=display;
    display.setController(this);
  }
  public DisplayPanel getDisplay() {
    return display;
  }
  
  public void prepareController(AbstractController controller) {
    TileGrid grid = new TileGrid(getDisplay().getScreenSize());
    grid.setPanelController(this);
    getDisplay().setItemController(controller);
    getDisplay().getItemController().setContainerPanel(getDisplay());
    getDisplay().getItemController().setGrid(grid);
  }
  public void startTimer() {
    timer = new Timer(20, new ActionListener() { //1000/20 = 50. So every 50 ticks is a second
      public void actionPerformed(ActionEvent e) {
        getDisplay().getItemController().react();
        getDisplay().heldKeys();
        getDisplay().processKeyEvents();
        getDisplay().processClicks();
        getDisplay().getItemController().step();
        getDisplay().repaint();
      }
    });
    timer.start();
  }
  
  public void saveImage() {
    try {
      BufferedImage screenshot = new BufferedImage(getDisplay().getScreenSize().x, getDisplay().getScreenSize().y, BufferedImage.TYPE_3BYTE_BGR);
      Graphics g = screenshot.getGraphics();
      getDisplay().paintComponent(g);
      String fileName = "Screenshots/"+new Date().getTime()+"Grid.png";
      ImageIO.write(screenshot, "PNG", new File(fileName));
      System.out.println("Saved Screenshot to "+fileName);
    } catch(IOException ex) {
      Logger.getLogger(DisplayPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}