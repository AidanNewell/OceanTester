
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
		}
		for(int x=0; x<boats.length;x++)
		{
			Boat currentBoat = boats[x];
			try{
				ocean.placeBoat(currentBoat.name(),currentBoat.direction(),currentBoat.position());
			}catch(Exception e){};
			try{
				goodOcean.placeBoat(currentBoat.name(),currentBoat.direction(),currentBoat.position());
			}catch(Exception e){};
		}
	}
	

}
