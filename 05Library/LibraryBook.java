abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String authorName, String titleName, String number,String callNumber){
	super(authorName,titleName,number);
	this.callNumber=callNumber;
    }
    /* public static void main(String[] args){
	LibraryBook boop=new LibraryBook ("Rowling"," Harry"," 12345","caller");
	System.out.println(boop.callNumber);
	}*/
    public String getCallNumber(){
	return callNumber;
    }
    public void setCallNumber(String callNumber){
	this.callNumber=callNumber;
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    public int compareTo(LibraryBook otherBook){
	return callNumber.compareTo(otherBook.getCallNumber());
    }
    public String toString(){
	return super.toString()+ " Circulation Status: " + circulationStatus() + " Call Number: " + callNumber;
    }
}
