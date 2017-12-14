import java.util.Arrays;
public class Sorts{

  public static String name(){
    return "01.Gondal.Adil"; 
  }

  public static void selectionSort(int[] data){
      if (data.length==0 || data.length==1){
	  return;
      }
      for (int i=0;i<data.length;i++){
         int min=data[i];
         for (int current=i;current<data.length;current++){
            if (data[current]<min){
               min=data[current];
               data[current]=data[i];
               data[i]=min;
            }
         }
      }
  }
   public static void insertionSort(int[] data){
       if (data.length==0 || data.length==1){
	  return;
      }
       int index=1;
       while(index<data.length){
	   int counter=index;
	   while(counter!=0 && data[index]<data[counter-1]){
	       counter--;
	   }
	   move(data,index,counter);
	   index++;
       }
   }
    public static void bubbleSort(int[] data){
	if (data.length==0 || data.length==1){
	  return;
      }
	int index=data.length-1;
	while(index>0){
	    int counter=0;
	    while(counter<index){
		if(data[counter]>data[counter+1]){
		    int temp=data[counter+1];
		    data[counter+1]=data[counter];
		    data[counter]=temp;
		}
		counter++;
	    }
	    index--;
	}
    }

    public static void	move(int[] data, int oldindex,int newindex){
	int temp=data[oldindex];
	for (int i=oldindex;i>newindex;i--){
	    data[i]=data[i-1];
	}
	data[newindex]=temp;		 
    }
    /*
    public static void main(String[] args){
	int[] array= new int[1000];
	int index=array.length-1;
	for (int i=0;i<1000;i++){
	    
	    array[i]=index;//(int)(Math.random()*10000);
	    index--;
	}
	int[] newarray={3,2};
	//System.out.println(Arrays.toString(array));
        bubbleSort(newarray);
    	System.out.println(Arrays.toString(newarray));
	}*/
}
