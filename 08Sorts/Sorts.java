import java.util.Arrays;
public class Sorts{

  public static String name(){
    return "01.Gondal.Adil"; 
  }

  public static void selectionSort(int[] data){
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
    public static void	move(int[] data, int oldindex,int newindex){
	int temp=data[oldindex];
	for (int i=oldindex;i>newindex;i--){
	    data[i]=data[i-1];
	}
	data[newindex]=temp;		 
    }

    public static void main(String[] args){
	int[] array= new int[100000];
	for (int i=0;i<1000;i++){
	    array[i]=(int)(Math.random()*10000);
	}
	int[] newarray={7,8,3,1,5,8,2};
	//System.out.println(Arrays.toString(array));
        insertionSort(array);
    	System.out.println(Arrays.toString(array));
    }
}
    
