import java.awt.Color;

/**
 * An image filter to display the red channel.
 * 
 * @author Nicholas Trilone
 * @version 2021.11.29
 */
public class WarholFilter extends Filter
{
    /**
     * Constructor for objects of class WarholFilter.
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
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
        
        //topleft
        for(int y = 0; y < height/2; y++) {
            for(int x = 0; x < width/2; x++) {
                image.setPixel(x, y, image.getPixel(x*2,y*2));
            }
        }
        
        //topright
        for(int y = 0; y < height/2; y++) {
            for(int x = width/2; x < width; x++) {
                image.setPixel(x, y, image.getPixel(x-width/2,y));
            }
        }
        }
    }