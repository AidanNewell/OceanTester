


public class positionString {
	public static void main(String args[]){
		String positions = "09 19 29 39 49 59 69 79 89 99 08 18 28 38 48 58 68 78 88 98 07 17 27 37 47 57 67 77 87 97 06 16 26 36 46 56 66 67";
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
