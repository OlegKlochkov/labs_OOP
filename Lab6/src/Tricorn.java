import java.awt.geom.Rectangle2D;

public class Tricorn extends FractalGenerator{

    @Override
    public void getInitialRange(Rectangle2D.Double range) {//Устанавливает начальный диапозон фрактала
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }

    public static final int MAX_ITERATIONS = 2000;

    @Override
    public int numIterations(double x, double y) {//Реализует итеративную функцию для фрактала Tricorn
        int iterationNum = 0;
        double real = 0;
        double imaginary = 0;
        while (iterationNum<MAX_ITERATIONS && real*real+imaginary*imaginary<4){
            double plhReal = real*real-imaginary*imaginary+x;
            double plhImaginary = -2*real*imaginary+y;
            real = plhReal;
            imaginary = plhImaginary;
            iterationNum++;
        }
        if(iterationNum==MAX_ITERATIONS){
            return -1;
        }else{
            return iterationNum;
        }
    }
    @Override
    public String toString() {
        return "Tricorn";
    }
}
