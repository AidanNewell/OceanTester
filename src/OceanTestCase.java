
public class OceanTestCase extends AssignmentTestCase{

	private Boat[] boats;
	private Position[] positions;
	private Ocean ocean;
	private GoodOcean goodOcean;

	public OceanTestCase(Boat[] boats, Position[] positions)
	{
		System.arraycopy(boats, 0, this.boats, 0, boats.length);
		System.arraycopy(positions, 0, this.positions, 0, positions.length);

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
			}catch(Exception e){oceanError = true;};
			try{
				goodOcean.placeBoat(currentBoat.name(),currentBoat.direction(),currentBoat.position());
			}catch(Exception e){goodOceanError = true;};
			if(oceanError != goodOceanError)
			{
				//Error reporting
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
				return false;
			}
			oceanError = false;
			goodOceanError = false;
		}
		//Now we fire the cannons and pull out the clipboards
		for(int x=0; x<positions.length;x++)
		{
			ocean.shootAt(new Position(positions[x].rowIndex(),positions[x].columnIndex())); 
			goodOcean.shootAt(new Position(positions[x].rowIndex(),positions[x].columnIndex()));
			if(ocean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())) != goodOcean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())))
			{
				//errorReportinggggg
				return false;
			}
			if(ocean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex()))) != goodOcean.sunk(new Position(positions[x].rowIndex(),positions[x].columnIndex())))
			{
				//errorReporting
				return false;
			}
			if(ocean.allSunk() != goodOcean.allSunk())
			{
				//errorReporting
				return false;
			}
			if(goodOcean.hit(new Position(positions[x].rowIndex(),positions[x].columnIndex())))
			{
				if(!(ocean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex())).equals(goodOcean.boatName(new Position(positions[x].rowIndex(),positions[x].columnIndex())))))
				{
					//errorReporting
					return false;
				}
				if(!(ocean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex())).equals(goodOcean.boatInitial(new Position(positions[x].rowIndex(),positions[x].columnIndex())))))
				{
					//errorReporting
					return false;
				}
			}
		}
		return true;
	}


}
