package tiles;

public class MovableOnTargetTile extends BoardTile{
	public MovableOnTargetTile(){
		super(false, true, '%');
	}
	@Override
	public String getFilePath(){
		return getFilePrefix()+"movable_on_target16x16.png";
	}

}
