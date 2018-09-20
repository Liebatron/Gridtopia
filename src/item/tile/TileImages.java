package item.tile;

import utilities.graphics.ImageReader;
import java.awt.Image;
import java.util.Random;

/** @author alieb */
public class TileImages {
  private static final String TerrainFolder="Terrain/10/";
  
  private static Random random = new Random();
  private static final Image SURFACE_GRASS_1=ImageReader.getImage(TerrainFolder+"G1");
  private static final Image SURFACE_GRASS_2=ImageReader.getImage(TerrainFolder+"G2");
  private static final Image SURFACE_GRASS_3=ImageReader.getImage(TerrainFolder+"G3");
  private static final Image[] SURFACE_GRASS={SURFACE_GRASS_1, SURFACE_GRASS_2, SURFACE_GRASS_3};
  
  private static final Image SURFACE_RIVER_1=ImageReader.getImage(TerrainFolder+"River1");
  private static final Image SURFACE_RIVER_2=ImageReader.getImage(TerrainFolder+"River2");
  private static final Image[] SURFACE_RIVER={SURFACE_RIVER_1, SURFACE_RIVER_2};
  
  private static final Image SURFACE_LAKE_1=ImageReader.getImage(TerrainFolder+"Lake1");
  private static final Image SURFACE_LAKE_2=ImageReader.getImage(TerrainFolder+"Lake2");
  private static final Image[] SURFACE_LAKE={SURFACE_LAKE_1, SURFACE_LAKE_2};
  
  private static final Image WHITE=ImageReader.getImage(TerrainFolder+"White");
  
  public static Image getTerrainImage(String imgName) {
    return ImageReader.getImage(TerrainFolder+imgName);
  }
  public static Image getGrassTile() {
    return SURFACE_GRASS[random.nextInt(SURFACE_GRASS.length)];
  }
  public static Image getRiverTile() {
    return SURFACE_RIVER[random.nextInt(SURFACE_RIVER.length)];
  }
  public static Image getLakeTile() {
    return SURFACE_LAKE[random.nextInt(SURFACE_LAKE.length)];
  }
  public static Image getWhiteTile() {
    return WHITE;
  }
}
