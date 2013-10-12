package gui;

import graphics.Map;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class TilePanel extends JPanel{	
	public TilePanel(Map map){
		setLayout(new GridLayout(map.getLines().size(), map.getLines().get(0).size()));
		
	}
}