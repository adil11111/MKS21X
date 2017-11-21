public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
	data=new String[10];
	size=0;
    }
    public SuperArray(int startingCapacity){
	data=new String[startingCapacity];
	size=0;
    }
    public String toString(){
         String gatherer="[";
         for (int i=0;i<data.length;i++){
            if (i==(data.length-1)){
               gatherer+=data[i];
               i+=1;
            }
            else{
            gatherer+=data[i]+", ";
            }
         }
                 gatherer+="]";
                 return gatherer;
   }
   public void clear(){
      for (int i=0;i<size;i++){
         data[i]=null;
      }
      size=0;
   }
    public int size(){
	return size;
    }
    public boolean isEmpty(){
	if(size==0){
	    return true;}
	return false;
    }
    public boolean add(String element){
	if (size==data.length){
	    resize();
	}
	data[size]=element;
	size++;
	return true;
    }
    public String get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    return data[index];
	}
    }
    public String set(int index,String element){
       	String temp="";
	if (index < 0 || index >= size()){
	   throw new IndexOutOfBoundsException();
	}
	else{
	    temp=data[index];
	    data[index]=element;
	}
	return temp;
    }
     private void resize(){
	String[] temp=new String[size];
	for (int i=0;i<size;i++){
	    temp[i]=data[i];
	}
	data=new String[size*2+1];
	for (int i=0;i<size;i++){
	    data[i]=temp[i];
	}
    }
    public boolean contains(String element){
	for (int i=0;i<size;i++){
	    if (data[i].equals(element)){
		return true;
	    }
	}
	return false;
    }
    public int indexOf(String target){
	for (int i=0;i<size;i++){
	    if (data[i].equals(target)){
		return i;
	    }
	}
	return -1;
    }
        public int lastIndexOf(String target){
	for (int i=size-1;i>0;i--){
	    if (data[i].equals(target)){
		return i;
	    }
	}
	return -1;
    }
    public void	add(int index, String element){
	if (index < 0 || index > size()){
	   throw new IndexOutOfBoundsException();
	}
	if (size==data.length){
	    resize();
	}
	else{
	    for (int mover=size-1;mover>=index;mover--){
		data[mover+1]=data[mover];
	    }
	}
	data[index]=element;
	size++;
    }
    public String remove(int index){
       	String temp="";
	if (index < 0 || index >= size()){
	   throw new IndexOutOfBoundsException();
	}
	else{
	    temp=data[index];
		for (int mover=index;mover<size;mover++){
		    data[mover]=data[mover+1];
		}
	}
	size--;
	return temp;
    }
     public boolean remove(String element){
	 if (contains(element)){
	     int index=indexOf(element);
	     remove(index);
	     return true;
	 }
	 return false;
     }
}
