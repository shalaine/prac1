//test
public class ACSLBlockus {
	public static void main(String [] args){
		int inputRow = 0;
		int inputCol = 0;
		int blockRow = 0;
		int blockCol = 0;
		//String input="A1, 2, 1";
		//String input="C1, 2, 1";  //ABC
		//String input="G5, 2, 2";  //CD
		//String input="F4, 1, 2";  //AB
		//String input="D9, 1, 2";  //AB
		//String input="G6, 1, 1";  //CD
		//String input="G1, 2, 1";  //ABCD
		//String input="E7, 2, 1";  //ABCD
		//String input="J9, 1, 2";  //AB
		String input="J1, 1, 1";  //NONE
		
		String [] strArray=input.split(", ");
		switch (strArray[0].charAt(0)){
			case 'A':
				inputRow = 0;
				break;
			case 'B':
				inputRow = 1;
				break;
			case 'C':
				inputRow = 2;
				break;
			case 'D':
				inputRow = 3;
				break;
			case 'E':
				inputRow = 4;
				break;
			case 'F':
				inputRow = 5;
				break;
			case 'G':
				inputRow = 6;
				break;
			case 'H':
				inputRow = 7;
				break;
			case 'I':
				inputRow = 8;
				break;
			case 'J':
				inputRow = 9;
				break;
			default:
				inputRow = -1;	
		}
		inputCol = Character.getNumericValue(strArray[0].charAt(1));
		int cornerBlock = Integer.parseInt(strArray[1]);
		int linkBlock = Integer.parseInt(strArray[2]);
	
	    if (cornerBlock == 1){
	    	blockRow = inputRow;
	    	blockCol = inputCol - 1;
		    if (linkBlock == 1){
		    	//Piece A is not possible
		    	//Piece B is not possible
		    	//Piece C
		    	if ((blockCol - 2)>=0 && (blockRow - 2) >=0)
		    		System.out.println("C");
		    	//Piece D
		    	if ((blockCol - 2)>=0 && (blockRow - 3) >=0)
		    		System.out.println("D");
		    } else if (linkBlock ==2){
		    	//Piece A
		    	if (((blockCol - 2)>=0 && (blockRow +1) < 10) || ((blockCol - 2)>=0 && (blockRow -1) >=0))
		    		System.out.println("A");
		    	//Piece B
		    	if ((blockCol - 2)>=0 && (blockRow - 2) >=0)
		    		System.out.println("B");
		    	//Piece C is not possible
		    	//Piece D is not possible
		    }
	    } else if (cornerBlock == 2){
	    	blockRow = inputRow;
	    	blockCol = inputCol;
		    if (linkBlock == 1){
		    	//Piece A
		    	if (((blockCol + 2)<10 && (blockRow +1) < 10) || ((blockCol + 2)<10 && (blockRow -1) >=0))
		    		System.out.println("A");
		    	//Piece B
		    	if (((blockCol + 2)<10 && (blockRow +1) < 10) || ((blockCol + 2)<10 && (blockRow -2) >=0))
		    		System.out.println("B");
		    	//Piece C
		    	if ((blockCol +2)<10 && (blockRow - 2) >=0)
		    		System.out.println("C");
		    	//Piece D
		    	if ((blockCol +1)<10 && (blockRow - 3) >=0)
		    		System.out.println("D");
		    } else if (linkBlock ==2){
		    	//Piece A is not possible
		    	//Piece B is not possible
		    	//Piece C
		    	if (((blockCol + 3)<10 && (blockRow +2) < 10) || ((blockCol + 2)<10 && (blockRow -1) >0))
		    		System.out.println("C");
		    	//Piece D
		    	if (((blockCol + 2)<10 && (blockRow +2) < 10) || ((blockCol + 2)<10 && (blockRow -2) >0))
		    		System.out.println("D");
		    	
		    }		    
	    	
	   }
	 
	    
	}
}
