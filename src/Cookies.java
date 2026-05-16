import javax.swing.*;

public class Cookies {
    private static int multiplier = 1;
    public static int cookiePrice = 5;
    public static int autoPrice = 10;
    public static int count = 0;
    public static int cookiesPerSecond = 0;

    public static Timer timer = new Timer(1000, e -> {
        count+=cookiesPerSecond;
    });

    // Increases the count by the multiplier.
    public static void add(){
        count+=multiplier;
    }

    // Decreases the count by the amount.
    public static void sell(int amount){
        count-=amount;
        if(count<0) count=0;
    }

    public static void upgradeClick(){
        if (Cookies.count < cookiePrice) return;
        multiplier++;
        Cookies.sell(cookiePrice);
        cookiePrice *= 2;
    }

    public static void upgradeAuto(){
        if (Cookies.count < autoPrice) return;
        cookiesPerSecond++;
        Cookies.sell(autoPrice);
        autoPrice *= 2;
    }

    public static String display(){
        return "Cookies: " + Cookies.count;
    }

    public static String getUpgradePrice(){
        return "Cookies Needed for Upgrade: " + cookiePrice;
    }

    public static String getAutoPrice(){
        return "Cookies Needed for Auto Click: " + autoPrice;
    }

    public static String getAutoRate(){
        return "Auto Click Rate: " + cookiesPerSecond;
    }
}
