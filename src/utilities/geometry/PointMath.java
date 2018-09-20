//@author alieb
package utilities.geometry;

import java.awt.Point;
import java.util.List;

public class PointMath {
  public static double hypotenuse(float a, float b) {
    return Math.sqrt((a*a)+(b*b));
  }
  public static float findGravity(float distance, int size) {
    return size/distance;
  }
  public static float findDistance(FloatPoint a, FloatPoint b) {
    float closex = Math.abs(a.x-b.x);
    float closey = Math.abs(a.y-b.y);
    return (float)Math.sqrt((closex*closex)+(closey*closey));
  }
  public static float findRoundedDistance(FloatPoint a, FloatPoint b) {
    float closex = Math.abs(a.x-b.x);
    float closey = Math.abs(a.y-b.y);
    return Math.round((float)Math.sqrt((closex*closex)+(closey*closey)));
  }
  public static float findRoundedDistance(Point a, Point b) {
    float closex = Math.abs(a.x-b.x);
    float closey = Math.abs(a.y-b.y);
    return Math.round((float)Math.sqrt((closex*closex)+(closey*closey)));
  }

  public static FloatPoint findGroupCenter(List<FloatPoint> points) {
    float Xtotal=0;
    float Ytotal=0;
    for(FloatPoint point : points) {
      Xtotal+=point.x;
      Ytotal+=point.y;
    }
    return new FloatPoint(Xtotal/points.size(), Ytotal/points.size());
  }
  
  public static FloatPoint getSeparation(FloatPoint a, FloatPoint b) {
    return new FloatPoint((a.x-b.x)*-1f, (a.y-b.y)*-1f);
  }

  public static float absXDistance(FloatPoint a, FloatPoint b) {
    return Math.abs(a.x-b.x);
  }
  public static float absYDistance(FloatPoint a, FloatPoint b) {
    return Math.abs(a.y-b.y);
  }
  public static float XDistance(FloatPoint a, FloatPoint b) {
    return a.x-b.x;
  }
  public static float YDistance(FloatPoint a, FloatPoint b) {
    return a.y-b.y;
  }

  public static FloatPoint findMiddlePoint(FloatPoint a, FloatPoint b) {
    return new FloatPoint((a.x+b.x)/2, (a.y+b.y)/2);
  }
  
  public static float findSlope(float yDelta, float xDelta) {
    return yDelta/xDelta;
  }
  public static float findSlope(Point a1, Point a2) {
    if((a1.x-a2.x)==0) { // Ideally it should be infinity, but... Obviously that's not possible
      return 2140000000;
    } else if((a1.y-a2.y)==0) { // There is no slope
      return 0;
    } else {
      return (a1.y-a2.y)/(a1.x-a2.x);
    }
  }
  public static float findSlope(FloatPoint a1, FloatPoint a2) {
    if((a1.x-a2.x)==0) { // Ideally it should be infinity, but... Obviously that's not possible
      return 2140000000; // Consider using Float.POSITIVE_INFINITY?
    } else if((a1.y-a2.y)==0) { // There is no slope
      return 0;
    } else {
      return (a1.y-a2.y)/(a1.x-a2.x);
    }
  }
  public static float findSlope(float angle) {
    return (float)Math.tan(Math.toRadians(angle));
  }
  public static float findAngle(FloatPoint a, FloatPoint b) {
    return (float)Math.toDegrees(Math.atan2(b.y - a.y, b.x - a.x));
  }
  
  public static float findAngleOfReflection(float object, float surface) {
    float angleOfIncidence = surface-object;
    return surface+angleOfIncidence;
  }
  
  public static float findInvertedSlope(FloatPoint a1, FloatPoint a2) {
    return -1/findSlope(a1, a2);
  }
  
  public static boolean hasIntercept(FloatPoint a1, FloatPoint b1, FloatPoint a2, FloatPoint b2) {
    return (findSlope(a1, b1)!=findSlope(a2, b2));
  }
  public static boolean hasIntercept(Point a1, Point b1, Point a2, Point b2) {
    return (findSlope(a1, b1)!=findSlope(a2, b2));
  }
  
  public static FloatPoint findIntercept(FloatPoint a1, FloatPoint a2, FloatPoint b1, FloatPoint b2) {
    float slope1=findSlope(a1, a2); // Get slopes
    float slope2=findSlope(b1, b2);
    float yIntercept1=a1.y-(slope1*a1.x); // Get Y Intercepts
    float yIntercept2=b1.y-(slope2*b1.x);
    float slopeLeft = slope1-slope2; // Subtract all "x" from the right side of the equation
    float XAtIntercept = yIntercept2-yIntercept1; // Subtract left Y intercept from right Y intercept
    XAtIntercept=XAtIntercept*(1/slopeLeft); // Multiply right y intercept by # necessary to multiply left slope by to get 1
    float YAtIntercept =(slope1*XAtIntercept)+yIntercept1;  // Get Y at Intercept by finding X of one of original lines where X is at intercept point
    return new FloatPoint(XAtIntercept, YAtIntercept);
  }
  public static FloatPoint findIntercept(FloatPoint a1, float slope1, FloatPoint b1, float slope2) {
    float yIntercept1=a1.y-(slope1*a1.x); // Get Y Intercepts
    float yIntercept2=b1.y-(slope2*b1.x);
    float slopeLeft = slope1-slope2; // Subtract all "x" from the right side of the equation
    float XAtIntercept = yIntercept2-yIntercept1; // Subtract left Y intercept from right Y intercept
    XAtIntercept=XAtIntercept*(1/slopeLeft); // Multiply right y intercept by # necessary to multiply left slope by to get 1
    float YAtIntercept =(slope1*XAtIntercept)+yIntercept1;  // Get Y at Intercept by finding X of one of original lines where X is at intercept point
    return new FloatPoint(XAtIntercept, YAtIntercept);
  }
  
  public static FloatPoint findIntercept(Point a1, Point a2, Point b1, Point b2) {
    return findIntercept(new FloatPoint(a1), new FloatPoint(a2), new FloatPoint(b1), new FloatPoint(b2));
  }
  
  public static boolean segmentsIntersect(FloatPoint a1, FloatPoint b1, FloatPoint a2, FloatPoint b2) {
    float slope1=findSlope(a1, a2); // Get slopes 173, 316 - 171, 82
    float slope2=findSlope(b1, b2); //            173, 315 - 171, 81
    float yIntercept1=a1.y-(slope1*a1.x); // Get Y Intercepts
    float yIntercept2=b1.y-(slope2*b1.x);
    float slopeLeft = slope1-slope2; // Subtract all "x" from the right side of the equation
    boolean intersect = false;
    if(slopeLeft!=0) {
      float XAtIntercept = yIntercept2-yIntercept1; // Subtract left Y intercept from right Y intercept
      XAtIntercept=XAtIntercept*(1/slopeLeft); // Multiply right y intercept by # necessary to multiply left slope by to get 1
      float YAtIntercept =(slope1*XAtIntercept)+yIntercept1;  // Get Y at Intercept by finding X of one of original lines where X is at intercept point
      if(YAtIntercept==0f && XAtIntercept==0f) {
        intersect = true;
      }
    }
    return intersect;
  }
  public static boolean segmentsIntersect(Point a1, Point a2, Point b1, Point b2) {
    return segmentsIntersect(new FloatPoint(a1), new FloatPoint(a2), new FloatPoint(b1), new FloatPoint(b2));
  }
  
  public static boolean isInsideBox(FloatPoint a, FloatPoint b, FloatPoint c) {
    if((c.x>a.x && c.x<b.x)) {
      if((c.y>a.y && c.y<b.y)) {
        return true;
      }
    }
    return false;
  }
  
  // Finds the centroid of a circle which intersects with 3 points
  public static FloatPoint findCentroid(FloatPoint a, FloatPoint b, FloatPoint c) {
    // Take two line segments which share a point
    // Get the midway points
    // Get the inverted slopes on both sides
    // Get the center of the circle
    return PointMath.findIntercept(
            PointMath.findMiddlePoint(a, b), PointMath.findInvertedSlope(a, b), 
            PointMath.findMiddlePoint(a, c), PointMath.findInvertedSlope(a, c));
  }
}