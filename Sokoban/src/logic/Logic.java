package logic;

import java.io.IOException;
import java.util.ArrayList;

import tiles.BoardTile;
import tiles.OpenSpaceTile;
import tiles.PlayerOnTargetTile;
import tiles.PlayerTile;
import tiles.TargetTile;

import graphics.GameFiles;
import graphics.Map;
import graphics.Maps;

public class Logic {
	private int px;
	private int py;
	private ArrayList<ArrayList<BoardTile>> tiles;
	
	public Logic(ArrayList<ArrayList<BoardTile>> tiles){
		this.tiles=tiles;
//		Maps.tileCollection.add(tiles);
		findPlayerCoordinates();
	}
	public void doMove(int dx, int dy){
		if(validMove(dx, dy) && !isPlayerOnTarget()){
			px+=dx;
			py+=dy;
			setCell(px, py, new PlayerTile());
			setCell(px-dx, py-dy, new OpenSpaceTile());
//			Maps.tileCollection.add(tiles);
		}
		else if(moveOnTarget(dx, dy)){
			px+=dx;
			py+=dy;
			setCell(px, py, new PlayerOnTargetTile());
			setCell(px-dx, py-dy, new OpenSpaceTile());
		}
		else if(isPlayerOnTarget() && validMove(dx, dy)){
			px+=dx;
			py+=dy;
			setCell(px, py, new PlayerTile());
			setCell(px-dx, py-dy, new TargetTile());
		}
		else
			System.out.println("Invalid move");
	}
	public void findPlayerCoordinates(){
		boolean stop=false;
		for(int i=0; i<tiles.size(); i++){
			for(int j=0; j<tiles.get(i).size(); j++){
				if(tiles.get(i).get(j).getCharacter()=='@'){
					py=i;
					px=j;
					stop=true;
					break;
				}
			}
			if(stop==true) break;
		}
	}
	public boolean moveOnTarget(int dx, int dy){
		return tiles.get(py+dy).get(px+dx).getCharacter()=='+';
	}
	public boolean isPlayerOnTarget(){
		return tiles.get(py).get(px).getCharacter()=='*';
	}
	public boolean validMove(int dx, int dy){
		return tiles.get(py+dy).get(px+dx).getCanMoveOn();
	}
	public void setCell(int x, int y, BoardTile tile){
		tiles.get(y).set(x, tile);
	}
	public void moveUp(){
		doMove(0, -1);
	}
	public void moveDown(){
		doMove(0, 1);
	}
	public void moveLeft(){
		doMove(-1, 0);
	}
	public void moveRight(){
		doMove(1, 0);
	}
	public int getpX(){
		return px;
	}
	public int getpY(){
		return py;
	}
	public ArrayList<ArrayList<BoardTile>> getTiles(){
		return tiles;
	}
}
