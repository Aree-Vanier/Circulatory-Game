package greg.science.circulatory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Info {
	
	Button back = new Button("Back", 2, 10, false, Color.BLACK, false);
	Button next = new Button("Next", 600, 10, false, Color.BLACK, false);
	int page = 1;
	BufferedImage[] images = new BufferedImage[11];
	
	public Info(){
		for(int i = 1; i < images.length + 1; i++){
			try {
				images[i-1] = ImageIO.read(Info.class.getResourceAsStream("/greg/science/circulatory/res/info/"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 1000);
		g.drawImage(images[page-1], 640/2 - images[page-1].getWidth()/2, -25, null);
		back.draw(g, 640);
		if(page < images.length-1) next.draw(g, 640);
	}

	public void click(MouseEvent e){
		if(back.click(e)) page --;
		if(next.click(e)) page ++;
		if(page == images.length) page = images.length-1;
	}
}
