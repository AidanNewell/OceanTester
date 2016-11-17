
public class OceanProblemFinder {

	/**
	 * @param args
	 */
	
	private  String[] directions = {"horizontal","vertical"};
	private  int acRow,acCol, acDir, bsRow,bsCol, bsDir;
	private boolean acGoodEx, acTestEx, bsGoodEx, bsTestEx;
	final static String BOAT1="Aircraft Carrier";
	final static String BOAT2="Battleship";
	
	public  String findProblem() {
		String problemFound = null;
		final int meterLength=20;
		for (int i=0;i<meterLength;i++)
			System.out.print("-");
		System.out.println("");
		bsGoodEx=false; bsTestEx=false;
		for (String acDir : directions){
			for (acRow=0;acRow<10 && problemFound==null;acRow++){
				System.out.print("=");
				for (String bsDir : directions){
					for (acCol=0;acCol<10 && problemFound==null;acCol++){
						for (bsRow=0;bsRow<10 && problemFound==null
						;bsRow++){
							for (bsCol=0;bsCol<10 && problemFound==null
							;bsCol++){
								acGoodEx=false; acTestEx=false;
								Ocean test = new Ocean();
								GoodOcean good = new GoodOcean();
								try{
									good.placeBoat(BOAT1
									, acDir, new Position(acRow,acCol));
								} catch (Exception ex){
									acGoodEx=true;
								}
								try{
									test.placeBoat(BOAT1
									, acDir, new Position(acRow,acCol));
								} catch (Exception ex){
									acTestEx=true;
								}
								if (acTestEx!=acGoodEx)
									problemFound=reportACProblem(acDir);
								else if (!acTestEx){
									bsTestEx=false;bsGoodEx=false;
									try{
										good.placeBoat(BOAT2
										, bsDir, new Position(bsRow,bsCol));
									} catch (Exception ex){
										bsGoodEx=true;
									}
									try{
										test.placeBoat(BOAT2
										, bsDir, new Position(bsRow,bsCol));
									} catch (Exception ex){
										bsTestEx=true;
									}
									if (bsTestEx!=bsGoodEx)
										problemFound=reportBSProblem(acDir,bsDir);
								}
							}
						}
					}
				}
			}
		}
		return problemFound;
	}
	
	private String reportACProblem(String acDir){
		String result=" Aircraft Carrier placed at ("+acRow+","
		+acCol+") should ";
		if (acGoodEx)
			result+="throw an exception";
		else
			result+="not throw an exception";
		return result;
	}
	
	private String reportBSProblem(String acDir, String bsDir){
		String result="Place a "+acDir+" Aircraft Carrier at ("
		+acRow+","+acCol+"), then place a "+bsDir+" Battleship at ("
		+bsRow+","+bsCol+"). Should ";
		if (bsGoodEx)
			result+="throw an exception";
		else
			result+="not throw an exception";
		return result;
	}
	
	public static void main(String[] args){
		OceanProblemFinder myFinder = new OceanProblemFinder();
		String problem = myFinder.findProblem();
		System.out.println(problem);
	}
}
