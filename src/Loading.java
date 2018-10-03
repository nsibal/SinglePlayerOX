import javax.swing.JPanel;
import javax.swing.JWindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Loading extends JWindow {
	
	private JPanel panel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loading frame = new Loading();
		frame.setVisible(true);

	}
	
	public Loading() {
		panel = new JPanel();
		//setBounds(0, 0, 300, 300);
		setSize(300, 300);
		setLocationRelativeTo(null);
		setContentPane(panel);
		//setOpacity(0f);
		//setOpacity(0.0f);
		//this.setBackground(new Color(0, 0, 0, 0));
		
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setSize(32, 32);
		//label.setLo
		label.setIcon(new ImageIcon("/Users/sibalnirbhay/Downloads/abc.gif"));
		panel.add(label);
		//label.setOpaque(true);
		
	}

}
