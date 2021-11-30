import java.awt.Color;

/**
 * An image filter to display the green channel.
 * 
 * @author Nicholas Trilone
 * @version 2021.11.29
 */
public class GChannelFilter extends Filter
{
    /**
     * Constructor for objects of class RChannelFilter.
     * @param name The name of the filter.
     */
    public GChannelFilter(String name)
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
                int green = image.getPixel(x, y).getGreen();
                image.setPixel(x, y, new Color(green,green,green));
            }
        }
    }

}