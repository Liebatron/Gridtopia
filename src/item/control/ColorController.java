package item.control;

import item.Box;
import item.tile.Tile;
import java.awt.Point;

/** @author alieb */
public class ColorController extends SimpleController {
  public void leftClick(int x, int y) {
    Tile tile = getGrid().getTile(new Point(x, y));
    if(tile.getContent()==null) {
      tile.setContent(new Box());
    } else {
      tile.setContent(null);
    }
  }
}
