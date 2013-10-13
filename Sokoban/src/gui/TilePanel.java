package gui;

import graphics.Map;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Logic;

import tiles.BoardTile;
import tiles.OpenSpaceTile;

public class TilePanel extends JPanel{
	private ArrayList<ArrayList<BoardTile>> tiles;
	private Logic logic;
	
	public TilePanel(ArrayList<ArrayList<BoardTile>> tiles){
		setLayout(new GridLayout(tiles.size(), tiles.get(0).size()));

		this.tiles=tiles;
		paint(tiles);
		
		logic=new Logic(tiles);
		
		this.addKeyListener(new MovePlayer());
	}
	public void paint(ArrayList<ArrayList<BoardTile>> tiles){
		
		for(int i=0; i<tiles.size(); i++){
			for(int j=0; j<tiles.get(0).size(); j++){
				BufferedImage img=null;
				try{
					img=ImageIO.read(new File(tiles.get(i).get(j).getFilePath()));
				}
				catch (Exception e) {
					System.err.println("Error: Couldn't read image "+tiles.get(i).get(j).getCharacter());
					// TODO: handle exception
				}
				Image resizedImage=img.getScaledInstance(32, 32, Image.SCALE_DEFAULT);
				
				this.add(new JLabel(new ImageIcon(resizedImage)));
			}
		}
	}
	public void printTiles(){
		for(int i=0; i<tiles.size(); i++){
			for(int j=0; j<tiles.get(i).size(); j++){
				System.out.print(tiles.get(i).get(j).getCharacter());
			}
			System.out.println();
		}
		System.out.println("\n\n");
	}
	private class MovePlayer implements KeyListener{
		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()==KeyEvent.VK_UP)
				logic.moveUp();
			if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
				logic.moveDown();
			if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
				logic.moveLeft();
			if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
				logic.moveRight();
			removeAll();
			paint(tiles);
			revalidate();
		}
		@Override
		public void keyReleased(KeyEvent arg0) {

		}
		@Override
		public void keyTyped(KeyEvent arg0) {

			// TODO Auto-generated method stub
		}
		
	}
}