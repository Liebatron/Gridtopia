package item.tile;

import DotPanel.PanelController;
import item.Item;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** @author alieb */
public class TileGrid {
  private Tile[][] tiles;
  private List<Item> contents = new ArrayList<>();
  
  private PanelController panelController;
  private Random random = new Random();
  private Point screenSize;
  private Point screenIndexSize;
  
  private static final int TileSize = 10;
  
  public TileGrid(Point screenSize) {
    this.screenSize = screenSize;
    this.screenIndexSize = getTileIndex(screenSize);
    tiles = new Tile[screenSize.x/TileSize][screenSize.y/TileSize];
    generateTileValues(screenSize.x/TileSize, screenSize.y/TileSize);
  }
  
  public TileGrid(int x, int y) {
    tiles = new Tile[x][y];
    this.screenSize = new Point(x,y);
    generateTileValues(x, y);
  }
  
  public void setPanelController(PanelController panelController) {
    this.panelController=panelController;
  }
  public PanelController getPanelController() {
    return panelController;
  }
  
  public Point getScreenSize() {
    return screenSize;
  }
  
  public List<Item> getTileContents() {
    return contents;
  }
  public static int getTileSize() {
    return TileSize;
  }
  
  private void generateTileValues(int x, int y) {
    for(int i=0;i<x;i++) {
      for(int j=0;j<y;j++) {
        Tile tile = new Tile(this, new Point(i*TileSize, j*TileSize), TileSize);
        tiles[i][j]=tile;
      }
    }
  }
  
  public Point getRandomPoint() {
    return new Point(random.nextInt(screenSize.x), random.nextInt(screenSize.y));
  }
  public Tile getRandomTile() {
    return getTile(getRandomPoint());
  }
  
  public Tile getTile(int x, int y) {
    Point tileIndex = getTileIndex(new Point(x, y));
    return getTileAtIndex(tileIndex.x, tileIndex.y);
  }
  public Tile getTile(Point point) {
    Point tileIndex = getTileIndex(point);
    return getTileAtIndex(tileIndex.x, tileIndex.y);
  }
  
  public Tile getLeftNeighbor(Tile tile) {
    return getLeftNeighbor(tile.getLocation().toPoint().x/10, tile.getLocation().toPoint().y/10);
  }
  public Tile getLeftNeighbor(Point index) {
    return getLeftNeighbor(index.x, index.y);
  }
  public Tile getLeftNeighbor(int x, int y) {
    Tile tile = getTileAtIndex(x-1, y);
    if(tile.getLocation().toPoint().x!=x) {
      return tile;
    } else {
      return null;
    }
  }
  public Tile getRightNeighbor(Tile tile) {
    return getRightNeighbor(tile.getLocation().toPoint().x/10, tile.getLocation().toPoint().y/10);
  }
  public Tile getRightNeighbor(Point index) {
    return getRightNeighbor(index.x, index.y);
  }
  public Tile getRightNeighbor(int x, int y) {
    Tile tile = getTileAtIndex(x+1, y);
    if(tile.getLocation().toPoint().x!=x) {
      return tile;
    } else {
      return null;
    }
  }
  public Tile getTopNeighbor(Tile tile) {
    return getTopNeighbor(tile.getLocation().toPoint().x/10, tile.getLocation().toPoint().y/10);
  }
  public Tile getTopNeighbor(Point index) {
    return getTopNeighbor(index.x, index.y);
  }
  public Tile getTopNeighbor(int x, int y) {
    Tile tile = getTileAtIndex(y+1, y);
    if(tile.getLocation().toPoint().y!=y) {
      return tile;
    } else {
      return null;
    }
  }
  public Tile getBottomNeighbor(Tile tile) {
    return getBottomNeighbor(tile.getLocation().toPoint().x/10, tile.getLocation().toPoint().y/10);
  }
  public Tile getBottomNeighbor(Point index) {
    return getBottomNeighbor(index.x, index.y);
  }
  public Tile getBottomNeighbor(int x, int y) {
    Tile tile = getTileAtIndex(y-1, y);
    if(tile.getLocation().toPoint().y!=y) {
      return tile;
    } else {
      return null;
    }
  }
  
  public Tile getTileAtIndex(int x, int y) {
    Point indexPoint = new Point(x, y);
    moveIndexOntoMap(indexPoint);
    return tiles[indexPoint.x][indexPoint.y];
  }
  
  public Point getTileIndex(Point point) {
    return new Point((point.x/TileSize), (point.y/TileSize));
  }
  
  public List<Tile> getAdjacentTiles(Point point) {
    return getAdjacentTilesAtIndex(getTileIndex(point));
  }
  
  public List<Tile> getAdjacentTilesAtIndex(Point index) {
    List<Tile> adjacentTiles = new ArrayList<Tile>();
    if(index.x<(screenSize.x/TileSize)-1) {
      adjacentTiles.add(getTileAtIndex(index.x+1,index.y));
    }
    if(index.y<(screenSize.y/TileSize)-1) {
      adjacentTiles.add(getTileAtIndex(index.x,index.y+1));
    }
    if(index.x>1) {
      adjacentTiles.add(getTileAtIndex(index.x-1,index.y));
    }
    if(index.y>1) {
      adjacentTiles.add(getTileAtIndex(index.x,index.y-1));
    }
    return adjacentTiles;
  }
  
  private void moveIndexOntoMap(Point point) {
    if(point.x>=screenIndexSize.x) {
      point.x=screenIndexSize.x-1;
    } else if(point.x<0) {
      point.x=0;
    }
    if(point.y>=screenIndexSize.y) {
      point.y=screenIndexSize.y-1;
    } else if(point.y<0) {
      point.y=0;
    }
  }
  
  private void drawTiles(Graphics g) {
    for(int i=0;i<tiles.length;i++) {
      Tile[] tileCol = tiles[i];
      for(int j=0;j<tileCol.length;j++) {
        tiles[i][j].draw(g);
      }
    }
  }
  
  public void draw(Graphics g) {
    drawTiles(g);
  }
}