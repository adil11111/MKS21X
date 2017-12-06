public class Barcode implements Comparable<Barcode>{
    private String zip;
    // private String[] codes;
    
    public Barcode(String zip){
	if (zipCheck(zip)){
	    this.zip=zip;
	}
    }
    public static boolean zipCheck(String zip){
	try{
	    if (zip.length()!=5){
		throw new IllegalArgumentException();
	    }
	    Integer.parseInt(zip);
	    return true;
	    
	}
	catch(NumberFormatException e){
	    throw new IllegalArgumentException();
	}
    }
	
    public int compareTo(Barcode other){
	return zip.compareTo(other.zip);
    }

    public static String toCode(String zip){
	String gatherer="|";
	if (zipCheck(zip)){
	    String newZip=zip + checkSum(zip);
	    String[] codes={ "||:::" , ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|","|::|:","|:|::"};
	    for (int i=0;i<newZip.length();i++){
		gatherer+=codes[Integer.parseInt(newZip.substring(i,i+1))];
	    }
	}
	return gatherer+ "|";
    }
    public static String checkSum(String zip){
	int sum=0;
	if (zipCheck(zip)){
	    for (int i=0;i<zip.length();i++){
		int x=Integer.parseInt(zip.substring(i,i+1));
		sum+=x;
	    }
	}
	return "" +(sum % 10);
    }
    public static String toZip(String code){
	String[] key={ "||:::" , ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|","|::|:","|:|::"};
	String gatherer="";
	if (code.length()!= 32 && code.charAt(0)!='|' && code.charAt(31)!='|'){
	    throw new IllegalArgumentException();
	}
	for (int c=1;c<code.length()-1;c+=5){
	    String temp=code.substring(c,c+5);
	    gatherer+= checkCode(temp);
	}
	if (!checkSum(gatherer.substring(0,5)).equals(gatherer.substring(5,6))){
	   throw new IllegalArgumentException();
	}
	return gatherer.substring(0,5);  

    }
    public static int checkCode(String code){
	String[] key={ "||:::" , ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|","|::|:","|:|::"};
	int index=0;
	while (!code.equals(key[index])){
		index++;
		if (index==10){
		    throw new IllegalArgumentException();
		}
	    }
	return index;
    }
    public String getCode(){
	return toCode(zip);
    }
    public String getZip(){
	return zip;
    }
    public String toString(){
	return getCode() + "(" + getZip() + ")";
    }	    
}
