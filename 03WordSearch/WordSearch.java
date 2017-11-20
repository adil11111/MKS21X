import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.lang.Math;
public class WordSearch{
    private char[][]data;
    private Random randgen;
    private ArrayList<String>wordsToAdd;
    private ArrayList<String>wordsAdded;
    private int seed;
    private char[][]solution;


    public WordSearch(int rows,int cols,String filename){
	seed=(int)(Math.random()*100000);
	wordsToAdd=new ArrayList<String>();
        wordsAdded=new ArrayList<String>();
	randgen=new Random(seed);
	data=new char[rows][cols];
	solution=new char[rows][cols];
	for (int r=0;r<rows;r++){
	    for (int c=0;c<cols;c++){
		data[r][c]='_';
	    }
	}
        try{
      File f = new File(filename);//can combine
      Scanner in = new Scanner(f);//into one line
      while(in.hasNext()){
        String line = in.nextLine();
        wordsToAdd.add(line);}      
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      //e.printStackTrace();
      System.exit(1);
    }
	addAllWords();
}
      public WordSearch(int rows,int cols,String filename,int randSeed){
	this(rows,cols,filename);
       	randgen=new Random(randSeed);
	seed=randSeed;
	} 
 /*   public WordSearch(int rows,int cols,String filename,int randSeed){
	seed=randSeed;
	wordsToAdd=new ArrayList<String>();
        wordsAdded=new ArrayList<String>();
	randgen=new Random(randSeed);
	data=new char[rows][cols];
	solution=new char[rows][cols];
	for (int r=0;r<rows;r++){
	    for (int c=0;c<cols;c++){
		data[r][c]='_';
	    }
	}
        try{
      File f = new File(filename);//can combine
      Scanner in = new Scanner(f);//into one line
      while(in.hasNext()){
        String line = in.nextLine();
        wordsToAdd.add(line);}      
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      //e.printStackTrace();
      System.exit(1);
    }
	addAllWords();
}
*/

    public int getSeed(){
	return seed;
    }
    public String getWordsAdded(){
	return wordsAdded.toString();
    }
    public String getSolution(){
	return printer(solution);
    }
    public String getPuzzle(){
	return printer(data);
    }


    /**Set all values in the WordSearch to underscores'_'*/
        private void clear(){
	    for (int r=0;r<data.length;r++){
		for (int c=0;c<data[0].length;c++){
		    data[r][c]='_';
		}
	    }
	}

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
     public String toString(){
	 String gatherer="";
	 for (int i=0;i<data.length;i++){
	     for (int x=0;x<data[i].length;x++){
		gatherer+=data[i][x] + " ";
      }
         gatherer+="\n";
	 }
	 return gatherer +"Seed:" + getSeed() +"\n"+getWordsAdded();
     }
     public static String printer(char[][] array){
	 String gatherer="";
	 for (int i=0;i<array.length;i++){
	     for (int x=0;x<array[i].length;x++){
		gatherer+=array[i][x] + " ";
      }
         gatherer+="\n";
	 }
	 return gatherer;
     }
    public char[][] copy(char[][] array){
	char[][] result= new char[array.length][array[0].length];
	for (int r=0;r<array.length;r++){
	    for (int c=0;c<array[0].length;c++){
		result[r][c]=array[r][c];
	    }
	}
	return result;
    }

      public boolean addWordHorizontal(String word,int row, int col){
	   if (1==1){
	      for (int i=0;i<word.length();i++){
		  if (data[row][col+i]!='_' && data[row][col+i]!=word.charAt(i)){
		      return false;
		  }
		  else {
		      data[row][col+i]=word.charAt(i);
		  }
	      }
	      return true;
	  }
	  return false;
      }

      public boolean addWordVertical(String word,int row, int col){
	  if (word.length()+row<=data.length && row<data.length && row>=0 && col>=0 && col<data[0].length){
	      for (int i=0;i<word.length();i++){
		  if (data[row+i][col]!='_' && data[row+i][col]!=word.charAt(i)){
		      return false;
		  }
		  else {
		      data[row+i][col]=word.charAt(i);
		  }
	      }
	      return true;
	  }
	  return false;
      }
    public boolean addWordDiagonal(String word,int row, int col){
	if (word.length()+row<=data.length && word.length()+col<=data[0].length && row<data.length && row>=0 && col>=0 && col<data[0].length){
	      for (int i=0;i<word.length();i++){
		  if (data[row+i][col+i]!='_' && data[row+i][col+i]!=word.charAt(i)){
		      return false;
		  }
		  else {
		      data[row+i][col+i]=word.charAt(i);
		  }
	      }
	      return true;
	  }
	  return false;
      }

      public boolean wordFits(int row,int col,String word,int rowIncrement,int colIncrement){
	try{
	    if (row < 0 || col < 0 || row>=data.length || col>= data[row].length){
		return false;}
	    for (int i=0;i<word.length();i++){
		if (data[row][col]!='_' && data[row][col]!=word.charAt(i)){
			return false;}
		row+=rowIncrement;
		col+=colIncrement;
	    }
	} catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}
	catch(IndexOutOfBoundsException e){
	       return false;
	   }
	return true;
    }
    
       public boolean addWords(int row, int col, String word, int rowIncrement, int colIncrement){
	   char[][] copiedArray=copy(data);
	   int copiedRow=row;
	   int copiedCol=col;
	   if (rowIncrement == colIncrement && colIncrement ==0){
	       return false;
	   }
	   try{
	       if (wordFits(row,col,word,rowIncrement,colIncrement)){
		   for (int i=0;i<word.length();i++){
		       copiedArray[copiedRow][copiedCol]=word.charAt(i);
	       	       copiedRow+=rowIncrement;
	   	       copiedCol+=colIncrement;
		   }
		  for (int i=0;i<word.length();i++){
		       data[row][col]=word.charAt(i);
	       	       row+=rowIncrement;
	   	       col+=colIncrement;
		  }
		  wordsToAdd.remove(word);
		  wordsAdded.add(word);
		  //	  System.out.println(printer(data));
		return true;
	       }
	       //  System.out.println(printer(copiedArray));
	      return false;
	   }catch(ArrayIndexOutOfBoundsException e){
	       //  System.out.println(e);
	       // System.out.println(printer(copiedArray));
	       return false;
	   }
	   catch(IndexOutOfBoundsException e){
	       //   System.out.println(printer(copiedArray));
	       return false;
	   }
       }
    public boolean addAllWords(){
	int tried=0;
	while (tried<1000 && wordsToAdd.size()>0){
	    //System.out.println(tried);
	     	int row= randgen.nextInt(data.length);
        int col=randgen.nextInt(data[0].length);
        int rowIncrement=randgen.nextInt(3)-1;
	int colIncrement=randgen.nextInt(3)-1;
	String word=wordsToAdd.get(randgen.nextInt(wordsToAdd.size()));
	    addWords(row,col,word,rowIncrement,colIncrement);
	    tried++;
	}
	solution=copy(data);
	for (int r=0;r<data.length;r++){
		for (int c=0;c<data[0].length;c++){
		    if (data[r][c]=='_'){
			data[r][c]=(char)(randgen.nextInt(26)+97);
		    }
		}
	}
	return true;
    }

    public static void main(String[] args){
	/*	if(args.length<3){
	    System.out.println("Need at least three arguments:row, col, and textfile");
	}
	if (args.length==4){
	    WordSearch searcher=new WordSearch(Integer.valueOf(args[0]),Integer.valueOf(args[1]),args[2],Integer.valueOf(args[3]));
       	System.out.println(searcher.getSolution() +"Seed:" +searcher.getSeed());
	} */
	WordSearch searcher=new WordSearch(10,10,"Words.txt",39096);
       	System.out.println(searcher.getPuzzle() + searcher.getSeed());
	//	System.out.println(args.length);

	
    }
}
