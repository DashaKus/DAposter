package Logic;

import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Poster {
    private String main_color ;
    private String Heading;
    private int size;
    private ArrayList<String> words = new ArrayList<>();
    private BufferedImage image;

    public Poster(String main_color1, String Heading1,int size1 ,ArrayList<String> words1 ) {
        this.main_color = main_color1;
        this.Heading= Heading1;
        this.size=size1;
        this.words=words1;
    }

    public String getMain_color() {
        return main_color;
    }

    public void setMain_color(String main_color) {
        this.main_color = main_color;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addText (int align, int shape, int placement ) throws IOException {
        File backround = new File("/image/sample.jpg");
        BufferedImage read = ImageIO.read(backround);
        Graphics text = read.getGraphics();
        //text.setFont(Roboto);
        //text.setColor(main_color);
        text.drawString(Heading,align, placement);
        text.dispose();
        ImageIO.write(read, "jpg", new File("/image/newimage.jpg"));
    }

}
