package greg.science.circulatory;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Button {
	int x;
	int y;
	String label;
	boolean center;
	Rectangle rect;
	Color colour;
	boolean decoration;
	
	public Button(String label, int x, int y, boolean center, Color colour, boolean decoration){
		this.label = label;
		this.x =x;
		this.y =y;
		this.center = center;
		this.colour = colour;
		this.decoration = decoration;
		rect = new Rectangle(1,1,1,1);
	}
	
	public void draw(Graphics g, int width){
		Color old = g.getColor();
		FontMetrics fm = g.getFontMetrics();
		if(center) x = width/2 - fm.stringWidth(label)/2;
		rect.x = x-1;
		rect.y =  y-1;
		rect.width = fm.stringWidth(label)+2;
		rect.height = fm.getHeight() + 2;
		g.setColor(colour);
		g.drawString(label, x, y+fm.getHeight()-10);
		if(decoration) g.drawRect(rect.x, rect.y, (int)(rect.getWidth()), (int)(rect.getHeight()));
		g.setColor(old);
	}
	
	public boolean click(MouseEvent e){
		if(rect.contains(new Point(e.getX(), e.getY()-25))) return true;
		return false;
	}
}
