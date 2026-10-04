public class Main {
    //Calculate the base fare
    public static double calculateBaseFare(double km){
        if (km<1){
            return 100.00;
        }
        return 100.00 + ((km-1)*80.00);
    }
//Calculate the waiting charge
    public static double calculateWaitingCharge(int minutes){
       return minutes*5;
    }
//Check whether it's the nighttime
    public static boolean isNightTime(int hour){
        if (hour>=22 || hour<=5){
            return true;
        }
        return false;
    }
    //Calculate the surcharge
    public static double calculateNightSurcharge(double subtotal, int hour) {
       if (isNightTime(hour)){
           return  (subtotal/100*20);
       }
        return 0.00;
    }
    //Print function
    public static void printReceipt(double km, int minutes, int hour) {
        double baseFare = calculateBaseFare(km);
        double waitingCharge = calculateWaitingCharge(minutes);
        double subtotal = baseFare + waitingCharge;
        double nightSurcharge = calculateNightSurcharge(subtotal, hour);
        double total = subtotal + nightSurcharge;


        System.out.printf("Trip:%.2f km%n | Waiting: %d min%n | Hour: %02d:00%n ",km ,minutes, hour);
        System.out.printf("Base fare     : Rs. %.2f%n", baseFare);
        System.out.printf("Waiting charge: Rs. %.2f%n", waitingCharge);
        System.out.printf("Night surcharge: Rs. %.2f%n", nightSurcharge);
        System.out.printf("TOTAL :  Rs. %.2f%n", total);
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {
        printReceipt(0.8, 0, 14);
        printReceipt(5.5, 10, 9);
        printReceipt(12, 5, 23);
    }

}