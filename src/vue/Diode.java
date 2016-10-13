package vue;

import java.awt.*;

import javax.swing.*;

public class Diode extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Color color;

	public Diode() {
		super();
		this.color = Color.black;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public void paintComponent(Graphics gc) {
		gc.setColor(Color.BLACK);
		gc.fillOval(0, 0, this.getWidth(), this.getHeight());
		gc.setColor(this.color);
		gc.fillOval(2, 2, this.getWidth()-4, this.getHeight()-4);
	}
}
