import java.awt.Color;

/**
 * An image filter to display the red channel.
 * 
 * @author Nicholas Trilone
 * @version 2021.11.29
 */
public class BChannelFilter extends Filter
{
    /**
     * Constructor for objects of class BChannelFilter.
     * @param name The name of the filter.
     */
    public BChannelFilter(String name)
    {
        super(name);
    }
    //getRed()
    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int blue = image.getPixel(x, y).getBlue();
                image.setPixel(x, y, new Color(blue,blue,blue));
            }
        }
    }

}