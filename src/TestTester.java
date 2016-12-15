
public class TestTester {
	public static void main (String args[]){
		OceanTester test = new OceanTester();
		AssignmentTestCase[] testsss = test.getCases();
		for(int x=0; x<testsss.length;x++)
		{
			if(!(testsss[x].runTestCase()))
				System.exit(1);
		}
		System.exit(0);
	}
}
