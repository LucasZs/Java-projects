import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Filter extends Frame
{
	BufferedImage image;
	boolean firstPaint = true;
	Insets insets;
	Image offscreen;
	Graphics og;
	
	public Filter(BufferedImage image)
	{
		this.image = image;
		setLayout(null);
		setBounds(0, 0, 1000, 1000);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public int[] doFilter(int[] data)
	{
		int[] result = new int[(data.length)];
		for (int i = 0; i < result.length; i++) {
			result[i] = data[i] & 0x00ff00;
		}
		return result;
	}
	
	public void invalidate()
	{
		offscreen = null;
		og = null;
	}
	
	public void paint(Graphics g)
	{
		if (firstPaint)
		{
			firstPaint = false;
			insets = getInsets();
			repaint();
		}
		if (offscreen == null)
		{
			offscreen = createImage(getSize().width, getSize().height);
			og = offscreen.getGraphics();
			BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
			bi.getGraphics().drawImage(image, 0, 0, null);
			int[] data = ((DataBufferInt)bi.getRaster().getDataBuffer()).getData();
			int[] filtered = doFilter(data);
			System.arraycopy(filtered, 0, data, 0, filtered.length);
			og.drawImage(bi, 0, 0, null);
		}
		g.drawImage(offscreen, insets.left, insets.top, null);
	}
	
	public static void main(String[] args)
	{
		File file = new File("c:\\ZsLP.jpg");
		try
		{
			BufferedImage image = ImageIO.read(file);
			new Filter(image);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
