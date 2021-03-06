import java.awt.Color;

/**
 * An image filter to display the red channel.
 * 
 * @author Nicholas Trilone
 * @version 2021.11.29
 */
public class RChannelFilter extends Filter
{
    /**
     * Constructor for objects of class RChannelFilter.
     * @param name The name of the filter.
     */
    public RChannelFilter(String name)
    {
        super(name);
    }
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
                int red = image.getPixel(x, y).getRed();
                image.setPixel(x, y, new Color(red,red,red));
            }
        }
    }

}