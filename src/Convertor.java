import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Convertor {
    private final static TreeMap<Integer, String> map = new TreeMap<>();

     static {
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");
    }
    public static int romanToInt(String romanNumber){
        int output=0;

        Map<String, Integer> map=new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        if (romanNumber.length()==0){
            return 0;
        }
        if (romanNumber.length()==1) return map.get(String.valueOf(romanNumber.charAt(0)));

                for(int i = 0;i<(romanNumber.length()-1);i++){
                    if(map.get(String.valueOf(romanNumber.charAt(i)))>=
                            map.get(String.valueOf(romanNumber.charAt(i+1)))){
                        output = output + map.get(String.valueOf(romanNumber.charAt(i)));
                    }else{
                        output = output - map.get(String.valueOf(romanNumber.charAt(i)));
                    }

                }
                output = output + map.get(String.valueOf(romanNumber.charAt(romanNumber.length()-1)));
                return output;
            }
            public static String intToRoman(int number){
        int I=map.floorKey(number);
        if (number == I){
            return map.get(number);
        }
        return map.get(I) + intToRoman(number-I);

    }

}



