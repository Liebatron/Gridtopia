package item.control;

import item.Clock;
import java.awt.Point;
import java.util.Random;

/** @author alieb */
public class SimpleController extends AbstractController {
  protected Random random = new Random();
  private Clock clock = new Clock(this);

  public Point getRandomPoint() {
    return new Point(random.nextInt(getGrid().getScreenSize().x), random.nextInt(getGrid().getScreenSize().y));
  }
  
  public void setClock(Clock clock) {
    this.clock=clock;
  }
  public Clock getClock() {
    return clock;
  }
  
  public void step() {
    getClock().tick();
  }
}