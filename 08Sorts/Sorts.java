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
      for (int i=1;i<data.length;i++){
         int min=data[0];
         for (int current=0;current<i;current++){
            if (data[i]<data[current]){
            min =data[i];
            data[i]=data[current];
            data[current]=min;
	    }
         }
      }
   }
}
    
