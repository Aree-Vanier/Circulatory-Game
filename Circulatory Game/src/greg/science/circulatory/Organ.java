package greg.science.circulatory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Organ {
	/**The highest possible number for a circulatory organ to have*/
	public final int MAX_GOOD_TYPE = 2;
	/**The number of images to choose from*/
	private final int IMAGE_COUNT = 4;
	int type;
    BufferedImage image;
    Random random;
    int x;
    int y;
    Rectangle rect;
    int lifeTime;
    //Main organs are heart, blood vessels, blood, and lungs: http://www.newhealthadvisor.com/Circulatory-System-Organs.html
    
    public Organ(int x, int y, int lifeTime){
    	this.lifeTime = lifeTime;
        random = new Random();
        type = random.nextInt(IMAGE_COUNT)+1;
        try {
			image = ImageIO.read(Organ.class.getResourceAsStream("/greg/science/circulatory/res/"+type+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        this.x = random.nextInt(640-image.getWidth());
        this.y = random.nextInt(640-image.getHeight());
        System.out.println(image.getWidth());
        rect = new Rectangle(this.x, this.y, (int)(image.getWidth()), (int)(image.getHeight()));
    }
    
    public void draw(Graphics g){
    	rect.x = x;
    	rect.y = y;
    	rect.width = image.getWidth();
    	rect.height = image.getHeight();
        g.drawImage(image, x, y, null);
        g.setColor(Color.RED);
        g.drawRect(x, y, (int)(rect.getWidth()), (int)(rect.getHeight()));
        lifeTime --;
    }
    
    public boolean checkClick(MouseEvent e){
//    	System.out.println(e.getX()+"\t"+e.getY() + "\n" + x +"\t"+y+"\t"+image.getWidth()+"\t"+image.getHeight());
    	if(e.getX()>x && e.getY()-25>y && e.getX() < x+image.getWidth() && e.getY()-25 < y+image.getHeight()){
    		return(true);
    	}
    	return(false);
    }
    
}
