package ru.stqa.pft.sandbox;

public class Task2 {

  public static void main(String[] args){

    Point p1 = new Point(20, 1);
    Point p2 = new Point(10, 50);
    //Объявление координат для точек p1 и p2

    Point p = new Point(0,0);
    //Создания обьекта типа Point для наглядного вызова метода соответствующего класса. Передаем параметры (0, 0), так как объект должен получить любые 2 атрибута на вход

    System.out.println("Расстояние между точками p1 и p2 на плоскости с координатами (" + p1.x + ", " + p1.y + ") и (" + p2.x + ", " + p2.y + ") = " + distance(p1, p2));

    System.out.println("Расстояние между точками p1 и p2 на плоскости с координатами (" + p1.x + ", " + p1.y + ") и (" + p2.x + ", " + p2.y + ") = " + p.distanceMetod(p1, p2));

  }

  public static double distance(Point p1, Point p2){
    return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
  }
}
