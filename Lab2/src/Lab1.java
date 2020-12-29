import java.util.Scanner;

public class Lab1 extends Point3d{
    public static void main(String [] args){//Основной метод, в котором происходит ввод данных и вызов других методов
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координаты первой точки(x, y, z)");//ввод координат первой точки
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();
        Point3d firstPoint = new Point3d(x, y, z);//инициализация объекта класса Point3d с введ. координатами
        System.out.println("Введите координаты второй точки(x, y, z)");//ввод координат второй точки
        x = sc.nextDouble();
        y = sc.nextDouble();
        z = sc.nextDouble();
        Point3d secondPoint = new Point3d(x, y, z);//инициализация объекта класса Point3d с введ. координатами
        System.out.println("Введите координаты третьей точки(x, y, z)");//ввод координат третьей точки
        x = sc.nextDouble();
        y = sc.nextDouble();
        z = sc.nextDouble();
        Point3d thirdPoint = new Point3d(x, y, z);//инициализация объекта класса Point3d с введ. координатами
        if(!sameCoordinates(firstPoint, secondPoint) && !sameCoordinates(secondPoint, thirdPoint) && !sameCoordinates(firstPoint, thirdPoint)){//проверка на равенство значений всех трёх объектов Point3d
            System.out.println(computeArea(firstPoint, secondPoint, thirdPoint));
        }else{
            if(sameCoordinates(firstPoint, secondPoint) && sameCoordinates(secondPoint, thirdPoint)){
                System.out.println("У всех трёх точек одинаковые координаты");
            }else {
                if (sameCoordinates(firstPoint, secondPoint)) {
                    System.out.println("У первой и второй точек одинаковые координаты");
                } else {
                    if (sameCoordinates(secondPoint, thirdPoint)) {
                        System.out.println("У второй и третьей точек одинаковые координаты");
                    } else {
                        if (sameCoordinates(firstPoint, thirdPoint)) {
                            System.out.println("У первой и третьей точек одинаковые координаты");
                        }
                    }
                }
            }
        }
    }
    public static double computeArea(Point3d A, Point3d B, Point3d C){//Вычисление площади треугольника, образованного тремя точками
        double a = distanceTo(A, B);
        double b = distanceTo(A, C);
        double c = distanceTo(B, C);
        double p = (a+b+c)/2;
        return(Math.sqrt(p*(p-a)*(p-b)*(p-c)));
    }
}
