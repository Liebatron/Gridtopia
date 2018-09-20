package gridtopia;

import DotPanel.PanelFactory;
import item.control.ColorController;
import item.control.SimpleController;

/**@author alieb*/
public class Gridtopia {
  public static void main(String[] args) {
    PanelFactory.createGrid(new SimpleController(), 15, 10);
  }
}