public class Book{
    private String author;
    private String title;
    private String ISBN;
    public Book(){
	author=null;
	title=null;
	ISBN=null;
    }
    public Book(String authorName, String titleName, String number){
	author=authorName;
	title=titleName;
	ISBN=number;
    }
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    }
    public void setAuthor(String newAuthor){
	author=newAuthor;
    }
    public void setTitle(String newTitle){
	title=newTitle;
    }
    public void setISBN(String newISBN){
	ISBN=newISBN;
    }	
    public String toString(){
	return "Title: " + title + " Author: " + author + " ISBN: " + ISBN;
    }
}
    
