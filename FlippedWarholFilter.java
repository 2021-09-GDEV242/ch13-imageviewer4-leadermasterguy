import java.awt.Color;

/**
 * A flipped warhol filter.
 * 
 * @author Nicholas Trilone
 * @version 2021.11.29
 */
public class FlippedWarholFilter extends Filter
{
    /**
     * Constructor for objects of class FlippedWarholFilter.
     * @param name The name of the filter.
     */
    public FlippedWarholFilter(String name)
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
        
        //variables used to keep track of positions for reflections
        int x2 = 0;
        int y2 = 0;
        
        //topleft(normal)
        for(int y = 0; y < height/2; y++) {
            for(int x = 0; x < width/2; x++) {
                image.setPixel(x, y, image.getPixel(x*2,y*2));
            }
        }
        
        //topright(red+horiz mirror)
        for(int y = 0; y < height/2; y++) {
            x2=width/2;
            for(int x = width/2; x < width; x++) {
                //image.setPixel(x, y, image.getPixel(x-width/2,y));
                int red = image.getPixel(x2,y).getRed()*2;
                if(red>255){
                    red=255;
                }
                int green = image.getPixel(x2,y).getGreen();
                int blue = image.getPixel(x2,y).getBlue();
                image.setPixel(x, y, new Color(red,green,blue));
                x2--;
            }
        }
        
        //bottomleft(green+vert mirror)
        y2=height/2;
        for(int y = height/2; y < height; y++) {
            for(int x = 0; x < width/2; x++) {
                //image.setPixel(x, y, image.getPixel(x,y-height/2));
                int red = image.getPixel(x, y2).getRed();
                int green = image.getPixel(x, y2).getGreen()*2;
                if(green>255){
                    green=255;
                }
                int blue = image.getPixel(x, y2).getBlue();
                image.setPixel(x, y, new Color(red,green,blue));
                
            }
            y2--;
        }
        
        //bottomright(blue+horiz mirror+vert mirror)
        y2=height/2;
        for(int y = height/2; y < height; y++) {
            x2=width/2;
            for(int x = width/2; x < width; x++) {
                //image.setPixel(x, y, image.getPixel(x-width/2,y-height/2));
                int red = image.getPixel(x2,y2).getRed();
                int green = image.getPixel(x2,y2).getGreen();
                int blue = image.getPixel(x2,y2).getBlue()*2;
                if(blue>255){
                    blue=255;
                }
                image.setPixel(x, y, new Color(red,green,blue));
                x2--;
            }
            y2--;
        }
        }
    }