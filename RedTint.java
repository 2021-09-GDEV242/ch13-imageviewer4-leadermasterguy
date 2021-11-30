import java.awt.Color;

/**
 * An image filter to tint it red.
 * 
 * @author Nicholas Trilone
 * @version 2021.11.29
 */
public class RedTint extends Filter
{
    /**
     * Constructor for objects of class RedTint.
     * @param name The name of the filter.
     */
    public RedTint(String name)
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
                int red = image.getPixel(x, y).getRed()*2;
                if(red>255){
                    red=255;
                }
                int green = image.getPixel(x, y).getGreen();
                int blue = image.getPixel(x, y).getBlue();
                image.setPixel(x, y, new Color(red,green,blue));
            }
        }
    }

}