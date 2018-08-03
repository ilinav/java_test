package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistancePointTest {

  @Test
  public void testArea(){
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 50);
    Point p3 = new Point(0, 20);
    Point p4 = new Point(0, 0);
    Point p5 = new Point(25, 11);
    Point p6 = new Point(23, 45);
    //Объявление координат для точек.

    Assert.assertEquals(p1.distanceMetod(p2), 50.0);
    Assert.assertEquals(p3.distanceMetod(p4), 20.0);
    Assert.assertEquals(p5.distanceMetod(p6), 34.058772731852805);
    Assert.assertEquals(p1.distanceMetod(p4), 0.0);
    Assert.assertEquals(p3.distanceMetod(p6), 33.97057550292606);

  }
}
