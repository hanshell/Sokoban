package tiles;

public class OpenSpaceTile extends BoardTile{
	public OpenSpaceTile(){
		super(true, false, ' ');
	}
	public String getFilePath() {
		return getFilePrefix()+"blank16x16.png";
	}

}