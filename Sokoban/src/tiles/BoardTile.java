package tiles;
/*
 * The purpose of this abstract class is to group similar
 * characteristics of different BoardTile-objects
 */
public abstract class BoardTile {
	protected boolean canMoveOn;
	protected boolean canMove;
	protected char character;
	private final String fileprefix="C:\\Users\\Melbster\\git\\Sokoban\\Sokoban\\src\\ImageIcons\\";
	
	public BoardTile(boolean canMoveOn, boolean canMove, char character){
		this.canMoveOn=canMoveOn;
		this.canMove=canMove;
		this.character=character;
	}
	public boolean getCanMoveOn(){
		return canMoveOn;
	}
	public boolean getCanMove(){
		return canMove;
	}
	public char getCharacter(){
		return character;
	}
	protected String getFilePrefix(){
		return fileprefix;
	}
	public abstract String getFilePath();
}