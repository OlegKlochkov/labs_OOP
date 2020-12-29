import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends javax.swing.JComponent {
    private BufferedImage displayedImage;
    public JImageDisplay(int width, int height){//Конструктор инициализации
        displayedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);//для отображения на экране всего изображения
    }

    @Override
    protected void paintComponent(Graphics g) {//Переопределяем метод paintComponent и рисуем изображение в компоненте
        super.paintComponent(g);
        g.drawImage(displayedImage, 0, 0, displayedImage.getWidth(), displayedImage.getHeight(), null);
    }
    public void clearImage(){//Очищаем изображение(меняем значение RGB пикселя на 0(чёрный цвет))
        int [] ZerosArray = new int[displayedImage.getHeight()*displayedImage.getWidth()];
        displayedImage.setRGB(0, 0, displayedImage.getWidth(), displayedImage.getHeight(), ZerosArray, 0, 1);
    }
    public void drawPixel(int x, int y, int rgbColor){//Меняем цвет пикселя
        displayedImage.setRGB(x, y, rgbColor);
    }
}
