package gui;

import graphics.Map;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tiles.BoardTile;

import logic.Logic;

public class MainPanel extends JPanel {
	private ArrayList<ArrayList<BoardTile>> tiles;
	private TilePanel tilepanel;
	public MainPanel() throws IOException{
		setLayout(new BorderLayout());
		tilepanel=new TilePanel(new Map("C:\\Users\\Melbster\\git\\Sokoban\\Sokoban\\src\\graphics\\test.txt").getTiles());
		tilepanel.setFocusable(true);
		add(tilepanel);
	}
	public static void main(String[] args) throws IOException {
		JFrame frame=new JFrame();
		frame.getContentPane().add(new MainPanel());
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
}