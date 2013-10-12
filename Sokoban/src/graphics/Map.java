package graphics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import tiles.BoardTile;
import tiles.OpenSpaceTile;
import tiles.PlayerTile;
import tiles.TargetTile;
import tiles.WallTile;

public class Map {
	private ArrayList<ArrayList<Character>> lines;
	private ArrayList<ArrayList<BoardTile>> tiles;
	
	public Map(String file) throws IOException{
		BufferedReader bf=new BufferedReader(new FileReader(new File(file)));
		String line="";

		ArrayList<String> characters=new ArrayList<String>();
		while((line=bf.readLine())!=null){
			characters.add(line);
		}
		bf.close();

		lines=new ArrayList<ArrayList<Character>>();
		tiles=new ArrayList<ArrayList<BoardTile>>();
		
		for(int i=0; i<characters.size(); i++){

			ArrayList<Character> c = new ArrayList<Character>();
			ArrayList<BoardTile> l = new ArrayList<BoardTile>();

			for(int j=0; j<characters.get(i).length(); j++){
				c.add(characters.get(i).charAt(j));
				l.add(tileType(characters.get(i).charAt(j)));
			}
			lines.add(c);
			tiles.add(l);
		}
	}
	
	/*
	 * returns the chars of the board
	 */
	public ArrayList<ArrayList<Character>> getLines(){
		return this.lines;
	}
	
	/*
	 * returns the BoardTile-objects in a nested ArrayList
	 */
	public ArrayList<ArrayList<BoardTile>> getTiles(){
		return this.tiles;
	}
	public void setTiles(){
		
		for(int i=0; i<lines.size(); i++){
			for(int j=0; j<lines.get(i).size(); j++){
				
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Map map=new Map("C:\\Users\\Melbster\\git\\Sokoban\\Sokoban\\src\\graphics\\test.txt");
		for(int i=0; i<map.getTiles().size(); i++){
			for(int j=0; j<map.getTiles().get(i).size(); j++){
				System.out.print(map.getTiles().get(i).get(j).getCharacter());
			}
			System.out.println();
		}
	}
	public static BoardTile tileType(char c){
		switch (c) {
		case '#':
			return new WallTile();
		case '@':
			return new PlayerTile();
		case '+':
			return new TargetTile();
		default:
			return new OpenSpaceTile();
		}
	}
}