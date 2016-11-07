package greg.science.circulatory;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Menu {
	
	Button play = new Button("Play", 0, 100, true, Color.BLACK, true);
	Button infoButton = new Button("Info", 0, 175, true, Color.BLACK, true);
	String title = "Circulatory Game";
	boolean infoState = false;
	Info info = new Info();
	
	public Menu(){
		
	}
	
	public void draw(Graphics g){
		if(!infoState){
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.fillRect(0, 0, 1000, 1000);
			g.setColor(Color.BLACK);
			g.drawString(title, 640/2 - g.getFontMetrics().stringWidth(title)/2, 50);
			play.draw(g, 640);
			infoButton.draw(g, 640);
		}
		else info.draw(g);
	}
	
	public void mouseClick(MouseEvent e){
		System.out.println(infoState);
		if(infoState) info.click(e);
		else if(infoState = infoButton.click(e)){
			infoState = true;
			info.page = 1;
		}
		if(info.page < 1) infoState = false;
	}
}
