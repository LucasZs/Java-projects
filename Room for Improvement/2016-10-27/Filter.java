import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Filter extends Frame {
    BufferedImage image;
    boolean firstPaint = true;
    Insets insets;
    Image offscreen;
    Graphics og;
    public Filter(BufferedImage image) {
        this.image = image;
        setLayout(null);
        setBounds(0, 0, 1000, 1000);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
    /*
     * int red = (rgb >> 16) & 0xff; int green = (rgb >> 8) & 0xff; int blue =
     * rgb & 0xff;
     * 
     * int luminance = (red+green+blue)/3 int greyRgb = (luminance<<16) |
     * (luminance<<8) | luminance;
     */
    public int[] doFilter(int[] data) {
        int[] result = new int[data.length];
        for (int i = 0; i < result.length; i++) {
            int red = (data[i] >> 16) & 0xff;
            int green = (data[i] >> 8) & 0xff;
            int blue = data[i] & 0xff;
              
            int luminance = (red + green + blue) / 3;
            int greyRGB = (luminance << 16) | (luminance << 8) | luminance;
            result[i] = greyRGB;
            
        }
        return result;
    }
    static final int[][] DIRECTIONS= new int[][]{
        {-1,-1},{0,-1},{1,-1},
        {-1,0},{0,0},{1,0},
        {-1,1},{0,1},{1,1}
    };
    public BufferedImage doFilter(BufferedImage data) {
        BufferedImage bi = new BufferedImage(data.getWidth(), data.getHeight(), data.getType());
        bi.getGraphics().drawImage(data, 0, 0, null);
        for (int y = 1; y < bi.getHeight() - 1; y++) {
            for (int x = 1; x < bi.getWidth() - 1; x++) {
                int sum = 0;
                for (int[] dir : DIRECTIONS) {
                    int di = x + dir[0];
                    int dj = y + dir[1];
                    int rgb = bi.getRGB(di, dj);
                    int red = (rgb >> 16) & 0xff;
                    int green = (rgb >> 8) & 0xff;
                    int blue = rgb & 0xff;
                    int luminance = (red + green + blue) / 3;
                    sum += luminance;
                }
                sum /= DIRECTIONS.length;
                int greyRGB = (sum << 16) | (sum << 8) | sum;
                bi.setRGB(x, y, greyRGB);
            }
        }
        return bi;
    }
    public void invalidate() {
        offscreen = null;
        og = null;
    }
    public void paint(Graphics g) {
        if (firstPaint) {
            firstPaint = false;
            insets = getInsets();
            repaint();
        }
        if (offscreen == null) {
            offscreen = createImage(getSize().width, getSize().height);
            og = offscreen.getGraphics();
            BufferedImage bi = doFilter(image);
            bi = doFilter(bi);
            // BufferedImage bi = new BufferedImage(image.getWidth(),
            // image.getHeight(), BufferedImage.TYPE_INT_RGB);
            // bi.getGraphics().drawImage(image, 0, 0, null);
            // int[] data = ((DataBufferInt)
            // bi.getRaster().getDataBuffer()).getData();
            // int[] filtered = doFilter(data);
            // System.arraycopy(filtered, 0, data, 0, filtered.length);
            og.drawImage(bi, 0, 0, null);
        }
        g.drawImage(offscreen, insets.left, insets.top, null);
    }
    public static void main(String[] args) {
        File file = new File("c:\\ZsLP.jpg");
        try {
            BufferedImage image = ImageIO.read(file);
            new Filter(image);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}