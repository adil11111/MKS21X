import java.util.Iterator;
public class superArrayIterator implements Iterator<String>{
    private SuperArray data;
    private int current;
    public superArrayIterator(SuperArray data){
	current=0;
	this.data=data;
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
    public String next(){
		if (hasNext()){
	    current++;
	}
	else{
	    System.exit(0);
	}
	return data.get(current-1);
	}
    }
    public boolean hasNext(){
	return current< data.size();
    }
}
	
