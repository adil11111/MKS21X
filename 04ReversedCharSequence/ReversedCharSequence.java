public class ReversedCharSequence implements CharSequence{
    private String sequence="";
    public ReversedCharSequence(String str){
	for (int i=str.length()-1;i>=0;i--){
	    sequence+=str.charAt(i);
	}
    }
    public char charAt(int index){
	return sequence.charAt(index);
    }
    public int length(){
	return sequence.length();
    }
    public CharSequence subSequence(int start,int end){
	return sequence.substring(start,end);
    }
    public String toString(){
	return sequence;
    }
}
