public class Point3d extends Point2d{//трёхмерный класс точки
    private double zCoord;//координата Z
    public Point3d(double x, double y, double z){//Конструктор инициализации
        super(x, y);
        zCoord = z;
    }
    public Point3d(){//Конструктор по умолчанию
        this(0, 0, 0);
    }
    /*public double getX(){//Возвращение координаты X
        return xCoord;
    }

     */
    /*public double getY(){//Возвращение координаты Y
        return yCoord;
    }

     */
    public double getZ(){//Возвращение координаты Z
        return zCoord;
    }
    /*
    public void setX(double val)//Установка значения координаты X
    {
        xCoord = val;
    }
    public void setY(double val)//Установка значения координаты Y
    {
        yCoord = val;
    }
    */
    public void setZ(double val)//Установка значения координаты Z
    {
        zCoord = val;
    }
    public static boolean sameCoordinates(Point3d A, Point3d B)	//Сравнение координат двух точек
    {
        return((A.getX()==B.getX()) && (A.getY()==B.getY()) && (A.getZ()==B.getZ()));
    }
    public static double distanceTo(Point3d A, Point3d B){//Вычисление расстояния между двумя точками с точностью 2 знака после запятой
        double res = Math.sqrt((B.getX()- A.getX())*(B.getX()- A.getX())+(B.getY()- A.getY())*(B.getY()- A.getY())+(B.getZ()- A.getZ())*(B.getZ()- A.getZ()));
        res*=100;
        res = (int) res;
        return(res/100);
    }
}
