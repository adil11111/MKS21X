import java.util.Iterator;
public class superArrayIterator implements Iterator<String>{
    private SuperArray[] data;
    private int current;
    public superArrayIterator(SuperArray[] data){
	current=0;
	this.data=data;
    }
    public String next(){
	return null;
    }
    public boolean hasNext(){
	return true;
    }
}
	
