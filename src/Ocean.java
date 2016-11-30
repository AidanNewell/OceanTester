
public class Ocean {
	private Boat[] boats = new Boat[5];
	private int totalBoats = 0;
	public void placeBoat(String boatName, String direction, Position pos) throws Exception{
		int startRow = pos.rowIndex();
		int startCol = pos.columnIndex();
		Boat newBoat = new Boat(boatName, pos, direction);
		int boatsize = newBoat.size();

		if(startRow<0 || startRow>9 || startCol<0 || startCol>9){ //checks it starts on board
			throw(new Exception());
		}
		if(newBoat.direction().equals("horizontal")){//checks it doesn't go off the board
			if(startCol + boatsize > 10){
				throw(new Exception());
			}
		}
		if(newBoat.direction().equals("vertical")){
			if(startRow + boatsize > 10){
				throw(new Exception());
			}
		}

		if(totalBoats!=0){
			Position[] newPositions = new Position[newBoat.size()]; //puts new boat's positions in newpositions
			newPositions[0] = pos;
			if(direction.equals("horizontal")){
				for(int i=1;i<newBoat.size();i++){
					newPositions[i] = new Position(startRow,startCol+i);
				}
			}
			if(direction.equals("vertical")){
				for(int i=1;i<newBoat.size();i++){
					newPositions[i] = new Position(startRow+i,startCol);
				}
			}
			for(int i=0;i<totalBoats;i++){  //checks overlapping 
				for(int j=0; j<newPositions.length;j++){
					if(boats[i].onBoat(newPositions[j]))
						throw(new Exception());
				}
			}
		}
		boats[totalBoats] = newBoat;
		totalBoats++;
	}
	public void placeAllBoats(){
		String[] boatNames = {"Aircraft Carrier","Battleship","Cruiser","Submarine","Destroyer"};
		String[] directions = {"horizontal","vertical"};
		int boatIndex = 0;
		while(boatIndex <5){
			int dIndex = (int) (2*Math.random()); 
			int posRow = (int) (10*Math.random());
			int posCol = (int) (10*Math.random());
			try{
				placeBoat(boatNames[boatIndex],directions[dIndex],new Position(posRow, posCol));
				boatIndex++;
			}
			catch(Exception ex){
			}
		}
	}
	public void shootAt(Position pos){
		for(int i=0;i<totalBoats;i++){
			if(boats[i].onBoat(pos))
				boats[i].hit(pos);
		}
	}
	public boolean hit(Position pos){
		for(int i=0;i<totalBoats;i++){
			if(boats[i].isHit(pos))
				return true;
		}
		return false;
	}
	public char boatInitial(Position pos){
		for(int i=0;i<totalBoats;i++){
			if(boats[i].onBoat(pos))
				return boats[i].abbreviation();
		}
		return 'U';
	}
	public String boatName(Position pos){
		for(int i=0;i<totalBoats;i++){
			if(boats[i].onBoat(pos))
				return boats[i].name();
		}
		return null;
	}
	public boolean sunk(Position pos){
		for(int i=0;i<totalBoats;i++){
			if(boats[i].onBoat(pos)){
				if(boats[i].sunk())
					return true;
			}
		}
		return false;
	}
	public boolean allSunk(){
		int sunkBoats = 0;
		for(int i=0;i<totalBoats;i++){
				if(boats[i].sunk())
					sunkBoats++;
		}
		if(sunkBoats==5)
			return true;
		return false;
	}
}
