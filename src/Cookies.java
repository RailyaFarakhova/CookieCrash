public class Cookies {
    public static int count = 0;

    public Cookies(){

    }

    public static void add(int multiplier){
        if(multiplier == 0){
            count++;
        }else {
            count+=multiplier;
        }
    }

    public static void sell(int amount){
        count-=amount;
    }
}
