package DotPanel;

import DotPanel.Panels.DisplayPanel;
import item.control.AbstractController;
import java.awt.Color;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class PanelFactory {
  public PanelFactory() {
  }
  
  public static void createGrid(AbstractController gridController, int gridx, int gridy) {
    PanelController panelController = new PanelController();
    panelController.setDisplay(getDisplayPanel(new Point(gridx*10, gridy*10)));
    JFrame f = new JFrame("");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(panelController.getDisplay(), 0);
    f.pack();
    panelController.prepareController(gridController);
    gridController.start();
    f.setVisible(true);
    panelController.startTimer();
  }
  
  private static DisplayPanel getDisplayPanel(Point mapSize) {
    DisplayPanel display = new DisplayPanel(mapSize);
    display.setFocusable(true);
    display.requestFocusInWindow();
    display.setOpaque(false);
    display.setBorder(BorderFactory.createLineBorder(Color.black));
    display.addMouse();
    display.addMouseMotion();
    display.addKeyboard();
    return display;
  }
}