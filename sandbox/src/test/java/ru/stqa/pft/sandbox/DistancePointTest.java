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

    Point p = new Point(0,0);
    //Создания обьекта типа Point для наглядного вызова метода соответствующего класса. Передаем параметры (0, 0), так как объект должен получить любые 2 атрибута на вход

    Assert.assertEquals(p.distanceMetod(p1, p2), 50.0);
    Assert.assertEquals(p.distanceMetod(p3, p4), 20.0);
    Assert.assertEquals(p.distanceMetod(p5, p6), 34.058772731852805);
    Assert.assertEquals(p.distanceMetod(p1, p4), 0.0);
    Assert.assertEquals(p.distanceMetod(p3, p6), 33.97057550292606);

  }
}
