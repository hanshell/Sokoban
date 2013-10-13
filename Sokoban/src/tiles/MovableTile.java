package tiles;

public class MovableTile extends BoardTile{
	public MovableTile(){
		super(false, true, '?');
	}
	@Override
	public String getFilePath() {
		return getFilePrefix()+"movable16x16.png";
	}
}