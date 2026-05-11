public class Cookies {
    public static int count = 0;

    // Increases the count by the multiplier.
    public static void add(int multiplier){
        count+=multiplier;
    }

    // Decreases the count by the amount.
    public static void sell(int amount){
        count-=amount;
        if(count<0) count=0;
    }
}
