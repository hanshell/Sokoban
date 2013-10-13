package tiles;

public class PlayerOnTargetTile extends BoardTile{
	public PlayerOnTargetTile(){
		super(true, false, '*');
	}
	@Override
	public String getFilePath() {
		return getFilePrefix()+"mover_on_target16x16.png";
	}
}
