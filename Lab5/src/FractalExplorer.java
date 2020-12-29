import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        //frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ButtonOnClick resetButton = new ButtonOnClick();
        button.addActionListener(resetButton);
        MouseOnclick clickAction = new MouseOnclick();
        display.addMouseListener(clickAction);
        JComboBox comboBox = new JComboBox();
        FractalGenerator mandelbrot = new Mandelbrot();
        FractalGenerator tricorn = new Tricorn();
        FractalGenerator burningShip = new BurningShip();
        comboBox.addItem(mandelbrot);
        comboBox.addItem(tricorn);
        comboBox.addItem(burningShip);
        ButtonOnClick choiceButton = new ButtonOnClick();
        comboBox.addActionListener(choiceButton);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Fractal:");
        panel.add(label);
        panel.add(comboBox);
        frame.add(panel, BorderLayout.NORTH);
        JButton saveButton = new JButton("save image");
        ButtonOnClick clickToSave = new ButtonOnClick();
        saveButton.addActionListener(clickToSave);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(saveButton);
        buttonsPanel.add(button);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
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
                    float hue = 0.7f + (float)iterationsNum/200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(i, j, rgbColor);
                }
            }
        }
        display.repaint();//обновление изображения в соответствии с обновлёнными ранее цветами пикселей
    }
    private class ButtonOnClick implements ActionListener{//Обработка нажатия на кнопку

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JComboBox){
                JComboBox source = (JComboBox) e.getSource();
                generator = (FractalGenerator) source.getSelectedItem();
                generator.getInitialRange(range);
                drawFractal();
            }else if(e.getActionCommand().equals("reset image")){
                generator.getInitialRange(range);//сбрасываем диапозон к начальному
                drawFractal();//перерисовываем фрактал
            }else if(e.getActionCommand().equals("save image")){
                JFileChooser chooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("PNG images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                int userChoice = chooser.showSaveDialog(display);
                if(userChoice==JFileChooser.APPROVE_OPTION){
                    java.io.File file = chooser.getSelectedFile();
                    String fileName = file.toString();
                    try{
                        BufferedImage displayImage = display.getDisplayedImage();
                        javax.imageio.ImageIO.write(displayImage, "png", file);
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(display, exception.getMessage(), "Cannot save image", JOptionPane.ERROR_MESSAGE);
                    }
                }else return;
            }
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
