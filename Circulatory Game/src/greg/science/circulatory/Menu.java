package greg.science.circulatory;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {
	
	Button play = new Button("Play", 0, 100, true, Color.BLACK);
	String title = "Circulatory Game";
	
	public Menu(){
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.BLACK);
		g.drawString(title, 640/2 - g.getFontMetrics().stringWidth(title)/2, 50);
		play.draw(g, 640);
	}
}
