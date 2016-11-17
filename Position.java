//Kevin Judd
public class Position {
	private char row;
	private int col;
	private int rowIndex;
	
	Position(char r, int c){
		row = r;
		col = c;
		if(row=='A')
			rowIndex = 0;
		else if(row=='B')
			rowIndex = 1;
		else if(row=='C')
			rowIndex = 2;
		else if(row=='D')
			rowIndex = 3;
		else if(row=='E')
			rowIndex = 4;
		else if(row=='F')
			rowIndex = 5;
		else if(row=='G')
			rowIndex = 6;
		else if(row=='H')
			rowIndex = 7;
		else if(row=='I')
			rowIndex = 8;
		else
			rowIndex = 9;
	}
	
	Position(int r, int c){
		rowIndex = r;
		switch(r){
			case 0:
				row = 'A'; break;
			case 1:
				row = 'B'; break;
			case 2:
				row = 'C'; break;
			case 3:
				row = 'D'; break;
			case 4:
				row = 'E'; break;
			case 5:
				row = 'F'; break;
			case 6:
				row = 'G'; break;
			case 7:
				row = 'H'; break;
			case 8:
				row = 'I'; break;
			case 9:
				row = 'J'; 
			break;
		}
		col = c+1;
	}
	
	public char row(){
		return row;
	}
	
	public int column(){
		return col;
	}
	
	public String toString(){
		return row + "-" + col;
	}
	public int rowIndex(){
		return rowIndex;
	}
	public int columnIndex(){
		return col-1;
	}

}
