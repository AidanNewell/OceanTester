import java.util.ArrayList;


public class OceanTestCase extends AssignmentTestCase{

	private Boat[] boats;
	private Position[] positions;
	private Ocean ocean;
	private GoodOcean goodOcean;
	private ArrayList<String> placedBoats;
	private ArrayList<String> shotsFired; 

	public OceanTestCase(Boat[] boats, Position[] positions)
	{
		System.arraycopy(boats, 0, this.boats, 0, boats.length);
		System.arraycopy(positions, 0, this.positions, 0, positions.length);
		placedBoats = new ArrayList<String>();
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
				placedBoats.add(currentBoat.direction().substring(0,1) + currentBoat.name().substring(0,1) + " "
						+ currentBoat.position().row() + " " + currentBoat.position().column());

			}catch(Exception e){
				oceanError = true;
			};
			try{
				goodOcean.placeBoat(currentBoat.name(),currentBoat.direction(),currentBoat.position());
			}catch(Exception e){goodOceanError = true;};
			if(oceanError != goodOceanError)
			{
				//error reporting
				System.out.print("Boats:");
				for(int i = 0; i<placedBoats.size(); i++){
					System.out.print(placedBoats.get(i));
					if(i != placedBoats.size()-1)
						System.out.print(", ");
				}
				return false;
			}
			oceanError = false;
			goodOceanError = false;
			//THIS IS NOT A MISTAKE COPY IT IS TO LOOK FOR GHOST BOATS ~DONE ME A SPOOK~
			try{
				ocean.placeBoat(currentBoat.name(),currentBoat.direction(),currentBoat.position());
			}catch(Exception e){oceanError = true;};
			try{
				goodOcean.placeBoat(currentBoat.name(),currentBoat.direction(),currentBoat.position());
			}catch(Exception e){goodOceanError = true;};
			if(oceanError != goodOceanError)
			{
				//error reporting
				System.out.println("This is a help");
				return false;
			}
			oceanError = false;
			goodOceanError = false;
		}
		//Now we fire the cannons and pull out the clipboards
		for(int x=0; x<positions.length;x++)
		{
			String shots = "Shots: ";
			ocean.shootAt(new Position(positions[x].rowIndex(),positions[x].columnIndex())); 
			shots = shots +  positions[x].rowIndex() + " " + positions[x].columnIndex() + ",";
			goodOcean.shootAt(new Position(positions[x].rowIndex(),positions[x].columnIndex()));
			if(ocean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())) != goodOcean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())))
			{
				//errorReportinggggg
				System.out.println(shots + "\nHit returns " + ocean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex()) 
				+ ", should return " + goodOcean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex()))));
				return false;
			}
			if(ocean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex())) != goodOcean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex())))
			{
				//errorReporting
						System.out.println(shots + "\nSunk returns " + ocean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex()) 
						+ ", should return " + goodOcean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex()))));
				return false;
			}
			if(ocean.allSunk() != goodOcean.allSunk())
			{
				//errorReporting
						System.out.println(shots + "\nAll sunk returns " + ocean.allSunk() + ", should return " + goodOcean.allSunk());
				return false;
			}
			if(goodOcean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())))
			{
				if(!(ocean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex())).equals(goodOcean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex())))))
				{
					//errorReporting
							System.out.println(shots + "\nBoat Name returns " + ocean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex())
							+ ", should return " + goodOcean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex()))));
					return false;
				}
				if(!(ocean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex())).equals(goodOcean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex())))))
				{
					//errorReporting
							System.out.println(shots + "\nBoat Initial returns " + ocean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex())
							+ ", should return " + goodOcean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex()))));
					return false;
				}
			}
		}
		return true;
	}


}
