
public class TestTester {
	public static void main (String args[]){
		OceanTester test = new OceanTester();
		AssignmentTestCase[] testsss = test.getCases();
		for(int x=0; x<testsss.length;x++)
		{
			try{
			testsss[x].runTestCase();
			}catch(Exception e){System.out.println(x);e.printStackTrace();}
		}
		System.exit(0);
	}
}
