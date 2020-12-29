import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class FractalExplorer{
    private int displaySize;//размер квадратного экрана(его ширина и высота)
    private JImageDisplay display;
    private FractalGenerator generator;
    private Rectangle2D.Double range;
    public FractalExplorer(int size){
        displaySize = size;
        generator = new Mandelbrot();
        range = new Rectangle2D.Double();
        generator.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);
    }
    public void createAndShowGUI(){
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal Generator");
        frame.add(display, BorderLayout.CENTER);
        JButton button = new JButton("reset image");
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        ResetOnclick resetButton = new ResetOnclick();
        button.addActionListener(resetButton);
        MouseOnclick clickAction = new MouseOnclick();
        display.addMouseListener(clickAction);
    }
    private void drawFractal(){
        for(int i = 0;i<displaySize;i++){
            for(int j = 0;j<displaySize;j++){
                double xCoord = generator.getCoord(range.x, range.x+range.width, displaySize, i);
                double yCoord = generator.getCoord(range.y, range.y+range.height, displaySize, j);
                int iterationsNum = generator.numIterations(xCoord, yCoord);
                if(iterationsNum==-1){
                    display.drawPixel(i, j, 0);
                }else{
                    //display.drawPixel(i, j, iterationsNum);//RGB вариант
                    float hue = 0.7f + (float)iterationsNum/200f;//HSB вариант
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(i, j, rgbColor);
                }
            }
        }
        display.repaint();//обновление изображения в соответствии с обновлёнными ранее цветами пикселей
    }
    private class ResetOnclick implements ActionListener{//Обработка нажатия на кнопку

        @Override
        public void actionPerformed(ActionEvent e) {
            generator.getInitialRange(range);//сбрасываем диапозон к начальному
            drawFractal();//перерисовываем фрактал
        }
    }
    private class MouseOnclick extends MouseAdapter implements MouseListener{//Обработка нажатия мышкой
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            int x = e.getX();//позиция курсора мыши по X
            int y = e.getY();//позиция курсора мыши по Y
            double xCoord = generator.getCoord(range.x, range.x+range.width, displaySize, x);
            double yCoord = generator.getCoord(range.y, range.y+range.height, displaySize, y);
            generator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }
    public static void main(String [] args){
        FractalExplorer fractal = new FractalExplorer(800);
        fractal.createAndShowGUI();
        fractal.drawFractal();
    }
}
