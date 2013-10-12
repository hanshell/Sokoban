package gui;

import graphics.Map;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	public MainPanel() throws IOException{
		setLayout(new BorderLayout());
		add(new TilePanel(new Map("C:\\Users\\Melbster\\git\\Sokoban\\Sokoban\\src\\graphics\\test.txt")));
	}
	public static void main(String[] args) throws IOException {
		JFrame frame=new JFrame();
		frame.getContentPane().add(new MainPanel());
		frame.setResizable(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
