public class ReferenceBook extends LibraryBook{
    private String collection;
    public ReferenceBook(String authorName, String titleName, String number,String callNumber, String collection){
	super(authorName,titleName,number,callNumber);
	this.collection=collection;
    }
    public String getCollection(){
	return collection;
    }
    public void setCollection(String newCollection){
	collection=newCollection;
    }
    public void checkout(String patron, String due){
	throw new UnsupportedOperationException();
    }
    public void returned(){
	throw new UnsupportedOperationException();
    }
    public String circulationStatus(){
	return "non-circulating reference book";
    }
    public String toString(){
	return super.toString()+ "Collection: " + collection;
    }
}
