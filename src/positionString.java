


public class positionString {
	public static void main(String args[]){
		String positions = "04 05 06 07 08 09 38 39 59 58 57 56 55 90 91 92 93 94 95 96 97 98 73";
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
