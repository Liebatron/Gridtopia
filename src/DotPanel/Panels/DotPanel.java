package DotPanel.Panels;

import DotPanel.Keyboard.Keys;
import DotPanel.PanelController;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

/** @author alieb */
public class DotPanel extends JComponent {
  private PanelController controller;
  private Point screenSize;
  private List<MouseEvent> clicks = new ArrayList<>();
  private List<MouseEvent> pastClicks = new ArrayList<>();
  private List<KeyEvent> keyEvents = new ArrayList<>();
  private List<KeyEvent> pastKeyEvents = new ArrayList<>();
  private Point currentMouse = new Point(0,0);
  private Keys keys = new Keys();
  
  public DotPanel(Point screenSize) {
    super();
    setScreenSize(screenSize);
    setBounds(0, 0, getScreenSize().x, getScreenSize().y);
  }
  
  public void setController(PanelController controller) {
    this.controller = controller;
  }
  public PanelController getController() {
    return controller;
  }
  
  private void setScreenSize(Point screenSize) {
    this.screenSize=screenSize;
  }
  public Point getScreenSize() {
    return screenSize;
  }
  
  public Keys getKeys() {
    return keys;
  }
  
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(getScreenSize().x,getScreenSize().y);
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
  
  public void step() {
  }
  
  //Input handler methods to override:
  
  //Instantaneous events
  public void doKeyPress(KeyEvent k) {
    System.out.println("Key pressed: "+k.getKeyChar());
  }
  
  //Events which will be stored and later handled by an extension of DotPanel
  public void doKeyTyped(KeyEvent k) {
    System.out.println("Key typed: "+k.getKeyChar());
  }
  
  public void rightClick(int x, int y) {
    System.out.println("Unsupported right click at "+x+", "+y);
  }
  public void middleClick(int x, int y) {
    System.out.println("Unsupported middle click at "+x+", "+y);
  }
  public void leftClick(int x, int y) {
    System.out.println("Unsupported left click at "+x+", "+y);
  }

  //<editor-fold defaultstate="collapsed" desc="Keyboard Input Registration">
  public void addKeyboard() {
    addKeyListener(new KeyListener() {
      public void keyTyped(KeyEvent k) {
        keyEvents.add(k);
      }
      public void keyPressed(KeyEvent k) {
        keys.down(k.getKeyCode());
        doKeyPress(k);
      }
      public void keyReleased(KeyEvent k) {
        keys.up(k.getKeyCode());
      }
    });
  }
  
  public void processKeyEvents() {
    for(KeyEvent k : keyEvents) {
      doKeyTyped(k);
      pastKeyEvents.add(k);
    }
    keyEvents.removeAll(pastKeyEvents);
    pastKeyEvents.removeAll(pastKeyEvents);
  }
  //</editor-fold>
  
  //<editor-fold defaultstate="collapsed" desc="Mouse Input Registration">
  public void addMouseMotion() {
    addMouseMotionListener(new MouseMotionListener() {
      public void mouseDragged(MouseEvent me) {
        currentMouse = me.getPoint();
        //If you want to do something when the mouse is dragged, that set of instructions has to start here!
      }
      public void mouseMoved(MouseEvent me) {
        currentMouse = me.getPoint();
        //If you want to do something when the mouse moves, that set of instructions has to start here!
      }
    });
  }
  
  public void addMouse() {
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent mouse) {
        clicks.add(mouse);
      }
    });
  }
  
  public void processClicks() {
    if(clicks!=null && !clicks.isEmpty()) {
      for(MouseEvent e : clicks) {
        if((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
          rightClick(e.getX(), e.getY());
        } else if((e.getModifiers() & InputEvent.BUTTON2_MASK) != 0) {
          middleClick(e.getX(), e.getY());
        } else {
          leftClick(e.getX(), e.getY());
        }
        pastClicks.add(e);
      }
      clicks.removeAll(pastClicks);
      pastClicks.removeAll(pastClicks);
    }
  }
  //</editor-fold>
}