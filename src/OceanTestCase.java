import java.util.ArrayList;


public class OceanTestCase extends AssignmentTestCase{

	private Boat[] boats;
	private Position[] positions;
	private Ocean ocean;
	private GoodOcean goodOcean;
	private ArrayList<String> placedBoats;

	public OceanTestCase(Boat[] boatArray, Position[] positionArray)
	{
		if(boatArray == null)
		{
			boats = null;
		}
		else
		{
			boats = new Boat[boatArray.length];
			System.arraycopy(boatArray, 0, boats, 0, boatArray.length);
		}
		if(positionArray == null)
		{
			positions = null;
		}
		else
		{
			positions = new Position[positionArray.length];
			System.arraycopy(positionArray, 0, positions, 0, positionArray.length);
		}
		placedBoats = new ArrayList<String>();
		ocean = new Ocean();
		goodOcean = new GoodOcean();
	}

	protected boolean runTestCase()
	{
		OceanProblemFinder problemFinder = new OceanProblemFinder();
		boolean oceanError = false;
		boolean goodOceanError = false;
		if(boats == null || boats.length == 0)
		{
			problemFinder.findProblem();
			//TODO: Use return value for error reporting
			return false;
		}
		for(int x=0; x<boats.length;x++)
		{
			Boat currentBoat = boats[x];
			try{
				ocean.placeBoat(currentBoat.name(),currentBoat.direction(),currentBoat.position());
				placedBoats.add(currentBoat.direction().substring(0,1) + currentBoat.name().substring(0,1)
						+ currentBoat.position().row() + currentBoat.position().column());
			}catch(Exception e){
				oceanError = true;
			}
			try{
				goodOcean.placeBoat(currentBoat.name(),currentBoat.direction(),currentBoat.position());
			}catch(Exception e){goodOceanError = true;};
			if(oceanError != goodOceanError)
			{
				//error reporting
				printBoatError();
				System.out.println("The boat " + currentBoat.abbreviation() + currentBoat.direction().substring(0,1) + currentBoat.position() + " "  + ((oceanError) ? "was not placed when it should have been." : "was placed when it should not have been."));
				return false;
			}
			oceanError = false;
			goodOceanError = false;
		}
		//Now we fire the cannons and pull out the clipboards
		String shots = "Shots: ";
		for(int x=0; x<positions.length;x++)
		{
			ocean.shootAt(new Position(positions[x].rowIndex(),positions[x].columnIndex())); 
			shots = shots +  positions[x].rowIndex() + positions[x].columnIndex() + ", ";
			goodOcean.shootAt(new Position(positions[x].rowIndex(),positions[x].columnIndex()));
			if(ocean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())) != goodOcean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())))
			{
				//errorReportinggggg
				printBoatError();
				System.out.println(shots + "\nHit returns " + ocean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex()))
						+ ", should return " + goodOcean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())));
				return false;
			}
			if(ocean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex())) != goodOcean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex())))
			{
				//errorReporting
				printBoatError();
				System.out.println(shots + "\nSunk returns " + ocean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex())) 
						+ ", should return " + goodOcean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex())));
				return false;
			}
			if(ocean.allSunk() != goodOcean.allSunk())
			{
				//errorReporting
				printBoatError();
				System.out.println(shots + "\nAll sunk returns " + ocean.allSunk() + ", should return " + goodOcean.allSunk());
				return false;
			}
			if(goodOcean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())))
			{
				if(!(ocean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex())).equals(goodOcean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex())))))
				{
					//errorReporting
					printBoatError();
					System.out.println(shots + "\nBoat Name returns " + ocean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex()))
							+ ", should return " + goodOcean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex())));
					return false;
				}
				if(!(ocean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex()))==(goodOcean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex())))))
				{
					//errorReporting
					printBoatError();
					System.out.println(shots + "\nBoat Initial returns " + ocean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex()))
							+ ", should return " + goodOcean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex())));
					return false;
				}
			}
		}
		return true;
	}
	
	private void printBoatError()
	{
		System.out.print("Boats: ");
		for(int i = 0; i<placedBoats.size(); i++){
			System.out.print(placedBoats.get(i));
			if(i != placedBoats.size()-1)
				System.out.print(", ");
		}
		System.out.println();
	}


}
