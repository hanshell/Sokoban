package graphics;

import java.util.ArrayList;
/*
 * Class to hold Maps-objects
 */

import tiles.BoardTile;
public class Maps {
	
	private static ArrayList<Map> maps=new ArrayList<Map>();
	public static ArrayList<ArrayList<ArrayList<BoardTile>>> tileCollection;
	
	public static void addMap(Map map){
		maps.add(map);
	}
	public static ArrayList<Map> getMaps(){
		return maps;
	}

}
