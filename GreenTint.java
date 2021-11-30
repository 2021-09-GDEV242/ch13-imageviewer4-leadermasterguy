import java.awt.Color;

/**
 * An image filter to tint it green.
 * 
 * @author Nicholas Trilone
 * @version 2021.11.29
 */
public class GreenTint extends Filter
{
    /**
     * Constructor for objects of class GreenTint.
     * @param name The name of the filter.
     */
    public GreenTint(String name)
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
                int green = image.getPixel(x, y).getGreen()*2;
                if(green>255){
                    green=255;
                }
                int blue = image.getPixel(x, y).getBlue();
                image.setPixel(x, y, new Color(red,green,blue));
            }
        }
    }

}