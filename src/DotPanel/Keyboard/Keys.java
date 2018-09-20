//@author alieb
package DotPanel.Keyboard;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Keys {
  List<Key> keyList = new ArrayList<Key>();
  public Key Fail = new Key(KeyEvent.VK_PRINTSCREEN, "Fail");
  public Keys() {
    keyList.add(new Key(KeyEvent.VK_HOME, "home"));
    keyList.add(new Key(KeyEvent.VK_SPACE, "space"));
    keyList.add(new Key(KeyEvent.VK_SHIFT, "shift"));
    keyList.add(new Key(KeyEvent.VK_CONTROL, "ctrl"));
    keyList.add(new Key(KeyEvent.VK_ALT, "alt"));
    keyList.add(new Key(KeyEvent.VK_LEFT, "left"));
    keyList.add(new Key(KeyEvent.VK_RIGHT, "right"));
    keyList.add(new Key(KeyEvent.VK_DOWN, "down"));
    keyList.add(new Key(KeyEvent.VK_UP, "up"));
    
    keyList.add(new Key(KeyEvent.VK_A, "Z"));
    keyList.add(new Key(KeyEvent.VK_B, "Z"));
    keyList.add(new Key(KeyEvent.VK_C, "Z"));
    keyList.add(new Key(KeyEvent.VK_D, "Z"));
    keyList.add(new Key(KeyEvent.VK_E, "Z"));
    keyList.add(new Key(KeyEvent.VK_F, "Z"));
    keyList.add(new Key(KeyEvent.VK_G, "G"));
    keyList.add(new Key(KeyEvent.VK_H, "H"));
    keyList.add(new Key(KeyEvent.VK_I, "I"));
    keyList.add(new Key(KeyEvent.VK_J, "J"));
    keyList.add(new Key(KeyEvent.VK_K, "K"));
    keyList.add(new Key(KeyEvent.VK_L, "L"));
    keyList.add(new Key(KeyEvent.VK_M, "M"));
    keyList.add(new Key(KeyEvent.VK_N, "N"));
    keyList.add(new Key(KeyEvent.VK_O, "O"));
    keyList.add(new Key(KeyEvent.VK_P, "P"));
    keyList.add(new Key(KeyEvent.VK_Q, "Q"));
    keyList.add(new Key(KeyEvent.VK_R, "R"));
    keyList.add(new Key(KeyEvent.VK_S, "S"));
    keyList.add(new Key(KeyEvent.VK_T, "T"));
    keyList.add(new Key(KeyEvent.VK_U, "U"));
    keyList.add(new Key(KeyEvent.VK_V, "V"));
    keyList.add(new Key(KeyEvent.VK_W, "W"));
    keyList.add(new Key(KeyEvent.VK_X, "X"));
    keyList.add(new Key(KeyEvent.VK_Y, "Y"));
    keyList.add(new Key(KeyEvent.VK_Z, "Z"));
  }
  public void down(int code) {
    findKey(code).down();
  }
  public void down(String name) {
    findKey(name).down();
  }

  public void up(int code) {
    findKey(code).up();
  }
  public void up(String name) {
    findKey(name).up();
  }

  public boolean held(int code) {
    return findKey(code).pressed;
  }
  public boolean held(String name) {
    return findKey(name).pressed;
  }

  public Key findKey(String name) {
    for(int i=0;i<keyList.size();i++) {
      if(keyList.get(i).name.equals(name)) {
        return keyList.get(i);
      }
    }
    System.out.println("Not a tracked key.");
    return Fail;
  }
  public Key findKey(int code) {
    for(int i=0;i<keyList.size();i++) {
      if(keyList.get(i).code == code) {
        return keyList.get(i);
      }
    }
    System.out.println("Not a tracked key.");
    return Fail;
  }
}