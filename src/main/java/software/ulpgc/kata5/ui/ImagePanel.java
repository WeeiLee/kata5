package software.ulpgc.kata5.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {
    private final Image image;

    public ImagePanel(String imagePath) throws IOException {
        this.image = ImageIO.read(new URL(imagePath));
    }

    @Override
    public void paint(Graphics g) {
        clear(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    private void clear(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, getWidth(), getHeight());
    }
}
