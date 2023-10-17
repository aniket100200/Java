import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = sc.next().charAt(0);
      }
    }
    sc.close();
    solveSudoku(board);
    if (isValidSudoku(board)) System.out.println(
      "correct"
    ); else System.out.println("incorrect");
  }

  public static boolean solveSudoku(char[][] board)
	{
	   //let's do the Traversal..

		for(int i=0;i<board.length;i++)
		{

			for(int j=0;j<board.length;j++)
			{
				if(board[i][j]=='.')
				{
					//let's try to fill the or char from 1 to 9..

					for(char ch='1';ch<='9';ch++)
					{
						if(isValid(ch,i,j,board))
						{
							board[i][j]=ch;
							if(solveSudoku(board))return true;

							//let's back track..
							board[i][j]='.';
							
						}
					}

					return false;
				}
			}
		}
		
		return true;
  }

	public static boolean isValid(char ch,int row,int col,char[][]board)
	{
		//I'll have to chekc in the 1] row .. 2] Col  3] 3X3 submatrix..

		for(int i=0;i<board.length;i++)
		{
			//row
			if(board[row][i]==ch)return false;

			//col
			if(board[i][col]==ch)return false;

			//3X3 Submatrix..
			if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch)return false;
		}

		return true;
	}


	public static boolean isValidSudoku(char[][]board)
	{
		for(int row=0;row<8;row+=3)
		{
			for(int col=0;col<8;col+=3)
			{
				if(!validate(row,col,row+2,col+2,board))return false;
			}
		}

		

		for(char[]b:board)
		{
			Set<Character>set=new HashSet<>();
			for(char ch:b){
				if(ch!='.' && set.contains(ch))return false;
				else set.add(ch);
			}
		}

		
		for(int j=0;j<9;j++){
			Set<Character>set=new HashSet<>();
			for(int i=0;i<9;i++){
				if(board[i][j]!='.' && set.contains(board[i][j]))return false;
				else set.add(board[i][j]);
			}
		}
		return true;
	}

	public static boolean validate(int x1,int y1,int x2,int y2,char[][]board)
	{

		Set<Character>set=new HashSet<>();
		for(int i=x1;i<=x2;i++){
			for(int j=y1;j<=y2;j++){
				set.add(board[i][j]);
			}
		}

		for(char ch='1';ch<='9';ch++)if(set.contains(ch)==false)return false;
		return true;
	}

}

