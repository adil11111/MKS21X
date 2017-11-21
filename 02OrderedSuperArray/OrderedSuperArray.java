public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int capacity){
	super(capacity);
    }
    public OrderedSuperArray(String[] ary){
	super();
	for (int i=0;i<ary.length;i++){
	    add(ary[i]);
	}
    }
    public String set(int index,String element){
	throw new UnsupportedOperationException();
    }
    public int indexOfBinary(String element){
      int start=0;
      int end=size()-1;
      int middle=(start+end)/2;
      while (!get(middle).equals(element)){
	  if (element.compareTo(get(middle))>0){
            start=middle;
      }
         else{
            end=middle;
         }
         middle=(start+end)/2;
         if (middle==start){
            middle+=1;
         }
         if (middle==end){
            middle-=1;
         }
      }
      while(middle>=0 && get(middle).equals(element)){
         middle-=1;
      }
            return middle+1;
   }
    public int lastIndexOfBinary(String element){
      int start=0;
      int end=size()-1;
      int middle=(start+end)/2;
      while (!get(middle).equals(element)){
	  if (element.compareTo(get(middle))>0){
            start=middle;
      }
         else{
            end=middle;
         }
         middle=(start+end)/2;
         if (middle==start){
            middle+=1;
         }
         if (middle==end){
            middle-=1;
         }
      }
      while(middle<size() && get(middle).equals(element)){
         middle+=1;
      }
            return middle-1;
   }
    public void add(int index, String value){
	add(value);
    }
 public boolean add(String value){
	if (size()==0){
	    super.add(value);
	    return true;
	}
	int index=0;
	while (index<size() && get(index).compareTo(value)<=0){
	    index+=1;
	}
	super.add(index,value);
	return true;
    }
    private int findIndexBinary(String element){
      int start=0;
      int end=size()-1;
      int middle=(start+end)/2;
      while (start+1!=end){
	  if (element.compareTo(get(middle))>0){
            start=middle;
      }
         else{
            end=middle;
         }
         middle=(start+end)/2;
      }
      if (element.compareTo(get(middle+1))>0){
         return middle+2;
       }
      if (element.compareTo(get(middle))<0){
         return middle;
       }
       else{
          return middle+1;
       }
    }
}
