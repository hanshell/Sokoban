package gui;

import graphics.Map;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tiles.OpenSpaceTile;

public class TilePanel extends JPanel{
	public TilePanel(Map map){
		setLayout(new GridLayout(map.getTiles().size(), map.getTiles().get(0).size()));
		
		for(int i=0; i<map.getTiles().size(); i++){
			for(int j=0; j<map.getTiles().get(0).size(); j++){
				BufferedImage img=null;
				try{
					img=ImageIO.read(new File(Map.tileType(map.getTiles().get(i).get(j).getCharacter()).getFilePath()));
				}
				catch (Exception e) {
					System.err.println("Error: Couldn't read image");
					// TODO: handle exception
				}
				Image resizedImage=img.getScaledInstance(32, 32, Image.SCALE_DEFAULT);
				
				this.add(new JLabel(new ImageIcon(resizedImage)));
			}
		}
	}
}