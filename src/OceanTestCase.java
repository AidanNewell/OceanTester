
public class OceanTestCase extends AssignmentTestCase{
	private Boat[] boats;
	private Position[] positions;
	private OceanProblemFinder problemFinder;
	private Ocean ocean;
	private GoodOcean goodOcean;
	public OceanTestCase(Boat[] boats, Position[] positions){
		this.boats = boats;
		this.positions = positions;
		problemFinder = new OceanProblemFinder();
		ocean = new Ocean();
		goodOcean = new GoodOcean();
	}
	protected boolean runTestCase() {
		if(boats == null || boats.length == 0){
			if(problemFinder.findProblem() != null)
				System.out.println(problemFinder.findProblem());
		}
		boolean goodOceanErrorH;
		boolean oceanErrorH;
		boolean goodOceanErrorV;
		boolean oceanErrorV;
		for(int i = 0; i<boats.length;i++){
			goodOceanErrorH = false;
			oceanErrorH = false;
			goodOceanErrorV = false;
			oceanErrorV = false;
			try{ // places horizontal
				ocean.placeBoat(boats[i].name(), "horizontal",positions[i]);
			}catch (Exception e){
				oceanErrorH = true;
			}
			try{
				goodOcean.placeBoat(boats[i].name(), "horizontal",positions[i]);
			}catch (Exception e){
				goodOceanErrorH = true;
			}
			try{ //places vertical
				ocean.placeBoat(boats[i].name(), "vertical", positions[i]);
			}catch (Exception e){
				oceanErrorV = true;
			}
			try{
				goodOcean.placeBoat(boats[i].name(), "vertical", positions[i]);
			}catch (Exception e){
				goodOceanErrorV = true;
			}
			if(oceanErrorH != goodOceanErrorH || oceanErrorV != goodOceanErrorV){
				for(int j = 0; j<i; j++){
					
				}
				break;
			}
			
		}
		return false;
	}

}
