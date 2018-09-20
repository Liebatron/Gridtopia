//@author alieb
package item;

import item.control.AbstractController;
import java.awt.Graphics;

public class Clock extends Item {
  private int seconds=0;
  private int ticks=0;
  private AbstractController controller;
  
  public Clock(AbstractController controller) {
    setController(controller);
  }
  
  public void setController(AbstractController controller) {
    this.controller=controller;
  }
  public AbstractController getController() {
    return controller;
  }
  
  public void tick() {
    ticks++;
  }
  public int getTicks() {
    return ticks;
  }
  public void resetTicks() {
    ticks=0;
  }
  
  public void tickSeconds() {
    seconds++;
  }
  public int getSeconds() {
    return seconds;
  }
  
  public void step() {
    tick();
    if(getTicks()==50) {
      tickSeconds();
      resetTicks();
    }
  }
  
  public void draw(Graphics g) {
    //If you want to draw or print the time, do it here!
  }
}