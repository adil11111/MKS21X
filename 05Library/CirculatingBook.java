public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;
    public CirculatingBook(String authorName, String titleName, String number,String callNumber){
	super(authorName,titleName,number,callNumber);
	currentHolder=null;
	dueDate=null;
    }
    public String getDueDate(){
	return dueDate;
    }
    public void setDueDate(String dueDate){
	this.dueDate=dueDate;
    }
    public String getCurrentHolder(){
	return currentHolder;
    }
    public void setCurrentHolder(String currentHolder){
	this.currentHolder=currentHolder;
    }
    public void checkout(String patron, String due){
	currentHolder=patron;
	dueDate=due;
    }
    public void returned(){
	currentHolder=null;
	dueDate=null;
    }
    public String circulationStatus(){
	if (currentHolder!=null){
	    return "CurrentHolder: " + currentHolder+ " Due Date: " + dueDate;
    }
	else{
	    return "book available on shelves";
	}
    }
    public String toString(){
	if (currentHolder!=null){
	    return super.toString() + "CurrentHolder: " + currentHolder+ " Due Date: " + dueDate;
	}
	else{
	    return super.toString();
	}
    }
}
