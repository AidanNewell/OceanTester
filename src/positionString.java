


public class positionString {
	public static void main(String args[]){
		String positions = "33 34 35 36 37 38 39 00 01 02 03 04 05 06 07 08 09 46 56 66 63 64 65 35 45 25";
		String nice = "new Position[] {";
		for(int i = 0; i<positions.length();i+=3){
			nice = nice + "p[" + positions.substring(i,i+1) + "][" +  positions.substring(i+1,i+2) + "]";
			if(i!=positions.length()-2){
				nice = nice +",";
			}
		}
		nice = nice+ "}";
		System.out.println(nice);
	}
}
