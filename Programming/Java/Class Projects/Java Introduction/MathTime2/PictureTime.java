import sacco.*;
public class PictureTime
{
    public static void negative()
    {
        Picture myPic = Picture.loadFromJar("Sacco.png");
        Pixel[][] pixel = myPic.getPixelArray();
        Pixel[][] newPix = new Pixel[pixel.length][pixel[0].length];
        for (int row = 0; row<pixel.length; row++)
        {
            for (int col = 0; col<pixel[0].length; col++)
            {
                int redNeg = 255 - pixel[row][col].getRed();
                int greenNeg = 255 - pixel[row][col].getGreen();
                int blueNeg = 255 - pixel[row][col].getBlue();
                newPix[row][col] = new Pixel(redNeg, greenNeg, blueNeg);                
            }
        }
        Picture newPic = new Picture(newPix);
        newPic.display();
    }

    public static void mirrorImage()
    {
        Picture myPic = Picture.loadFromJar("Sacco.png");
        Pixel[][] pixel = myPic.getPixelArray();
        Pixel[][] newPix = new Pixel[pixel.length][pixel[0].length];
        for (int row = 0; row<pixel.length; row++)
        {
            for (int col = 0; col<pixel[0].length; col++)
            {
                newPix[row][col] = pixel[row][(pixel[0].length-1)-col];
            }
        }
        Picture newPic = new Picture(newPix);
        newPic.display();
    }

    public static void threshold(int threshold)
    {
        Picture myPic = Picture.loadFromJar("Sacco.png");
        Pixel[][] pixel = myPic.getPixelArray();
        Pixel[][] newPix = new Pixel[pixel.length][pixel[0].length]; 
        for (int row = 0; row<pixel.length; row++)
        {
            for (int col = 0; col<pixel[0].length; col++)
            {
                int redNeg = pixel[row][col].getRed();
                int greenNeg = pixel[row][col].getGreen();
                int blueNeg = pixel[row][col].getBlue();
                int average = (redNeg + greenNeg + blueNeg) / 3;
                if (average < threshold)
                    newPix[row][col] = new Pixel(0,0,0);
                else
                    newPix[row][col] = new Pixel(255,255,255);
            }
        }     
        Picture newPic = new Picture(newPix);
        newPic.display();
    }

    public static void sepiaTone()
    {
        Picture myPic = Picture.loadFromJar("Sacco.png");
        Pixel[][] pixel = myPic.getPixelArray();
        Pixel[][] newPix = new Pixel[pixel.length][pixel[0].length];
        for (int row = 0; row<pixel.length; row++)
        {
            for (int col = 0; col<pixel[0].length; col++)
            {
                int red = (int)(0.393*(pixel[row][col].getRed()) + 0.769*(pixel[row][col].getGreen()) + 0.189*(pixel[row][col].getBlue()));
                int green = (int)(0.349*(pixel[row][col].getRed()) + 0.686*(pixel[row][col].getGreen()) + 0.168*(pixel[row][col].getBlue()));
                int blue = (int)(0.272*(pixel[row][col].getRed()) + 0.534*(pixel[row][col].getGreen()) + 0.131*(pixel[row][col].getBlue()));
                if (red>255)
                    red=255;
                if (green>255)
                    green=255;
                if (blue>255)
                    blue=255;
                newPix[row][col] = new Pixel(red,green,blue);
            }
        }     
        Picture newPic = new Picture(newPix);
        newPic.display();
    }

    public static void blur()
    {
        Picture myPic = Picture.loadFromJar("Sacco.png");
        Pixel[][] pixel = myPic.getPixelArray();
        Pixel[][] newPix = new Pixel[pixel.length][pixel[0].length];
        for (int row = 0; row<pixel.length;row++)
        {
            for (int col = 0; col<pixel[0].length; col++)
            {
                int r = 0;
                int g = 0;
                int b = 0;
                // Averaging Colors

                for (int r1 = row-1; r1<row+2; r1++)
                {
                    for (int c = col-1; c<col+2; c++)
                    {
                        if (r1>=0&&r1<pixel.length&&c>=0&&c<pixel[0].length)
                        {
                            Pixel origPixel = pixel[r1][c];
                            r+=origPixel.getRed();
                            g+=origPixel.getGreen();
                            b+=origPixel.getBlue();
                        }
                    }
                }
                newPix[row][col] = new Pixel(r/9,g/9,b/9);
            }
        }
        Picture newPic = new Picture(newPix);
        newPic.display();
    }

    public static void secret()
    {
        int x = 0;
        while (x<2)
        {
            x++;
            Picture myPic = Picture.loadFromJar("Sacco.png");
            Pixel[][] pixel = myPic.getPixelArray();
            Pixel[][] newPix = new Pixel[pixel.length][pixel[0].length];
            for (int row = 0; row<pixel.length;row++)
            {
                for (int col = 0; col<pixel[0].length; col++)
                {
                    if ( (pixel[row][col].getRed()%2) == 1 )
                    {
                        int r = (int)(x*col*Math.random());
                        int g = (int)(x*row*Math.random());
                        int b = (int)(255*(1/x));
                        if (r>255)
                            r=255;
                        if (g>255)
                            g=255;
                        if (b>255)
                            b=255;
                        newPix[row][col] = new Pixel(r,g,b);
                    }
                    else
                    {
                        newPix[row][col] = new Pixel(0,0,0);
                    }
                }
            }
            Picture newPic = new Picture(newPix);
            newPic.display();
        }
    }
}