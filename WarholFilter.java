import java.awt.Color;

/**
 * A warhol filter.
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
        
        //topleft(normal)
        for(int y = 0; y < height/2; y++) {
            for(int x = 0; x < width/2; x++) {
                image.setPixel(x, y, image.getPixel(x*2,y*2));
            }
        }
        
        //topright(red)
        for(int y = 0; y < height/2; y++) {
            for(int x = width/2; x < width; x++) {
                //image.setPixel(x, y, image.getPixel(x-width/2,y));
                int red = image.getPixel(x-width/2,y).getRed()*2;
                if(red>255){
                    red=255;
                }
                int green = image.getPixel(x-width/2,y).getGreen();
                int blue = image.getPixel(x-width/2,y).getBlue();
                image.setPixel(x, y, new Color(red,green,blue));
            }
        }
        
        //bottomleft(green)
        for(int y = height/2; y < height; y++) {
            for(int x = 0; x < width/2; x++) {
                //image.setPixel(x, y, image.getPixel(x,y-height/2));
                int red = image.getPixel(x, y-height/2).getRed();
                int green = image.getPixel(x, y-height/2).getGreen()*2;
                if(green>255){
                    green=255;
                }
                int blue = image.getPixel(x, y-height/2).getBlue();
                image.setPixel(x, y, new Color(red,green,blue));
            }
        }
        
        //bottomright(blue)
        for(int y = height/2; y < height; y++) {
            for(int x = width/2; x < width; x++) {
                //image.setPixel(x, y, image.getPixel(x-width/2,y-height/2));
                int red = image.getPixel(x-width/2,y-height/2).getRed();
                int green = image.getPixel(x-width/2,y-height/2).getGreen();
                int blue = image.getPixel(x-width/2,y-height/2).getBlue()*2;
                if(blue>255){
                    blue=255;
                }
                image.setPixel(x, y, new Color(red,green,blue));
            }
        }
        }
    }