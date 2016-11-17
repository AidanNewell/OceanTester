//Shania Lin	Pd. 2 (Computer #27)
//File name: midterm/AssignmentTester/AssignmentTester/AssignmentTestCase.java
//Date: December 18, 2003
//Description: 	superclass for each test case

public abstract class AssignmentTestCase{
	protected String result;
	protected abstract boolean runTestCase();
	public boolean runTest()
	{
//		try{
			boolean trueResult=runTestCase();
			if(result.equals(null)){ result="";}
			return trueResult;
//		}catch(Exception e){
//                        result+="[Exception!]";
//			return false;
//		}		
	}
	public String getResult(){ return result;}
}
	