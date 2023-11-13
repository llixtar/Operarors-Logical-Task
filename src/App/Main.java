package App;

public class Main {

    static double[] productPrices;
    static String[] weekDays;
    static double price;
    static int shiftPrice;
    static double currShiftPrice;
    static double averagePrice;
    private static final String CURRENCY = "EUR";
    private static final int COUNT_DAYS = 7;

    public static void main(String[] args) {

        productPrices = new double[COUNT_DAYS];
        weekDays = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        price = 100;
        shiftPrice = 20;
        averagePrice = 0;

        for (int i = 0; i < COUNT_DAYS; i++) {

            currShiftPrice = (shiftPrice / 2) - (Math.random() * shiftPrice);//+-10 від 100
            productPrices[i] = price + currShiftPrice;
            averagePrice += productPrices[i];

            if (i == 0)
                System.out.printf("%n*** LAST WEEK'S PRICES ***%n%s: %.2f %s%n", weekDays[i], productPrices[i], CURRENCY);
            else if (i == (COUNT_DAYS - 1)) {
                averagePrice = averagePrice / COUNT_DAYS;
                System.out.printf("%s: %.2f %s%n-------------------------%nAVERAGE PRICE: %.2f %s%n-------------------------%n",
                        weekDays[i], productPrices[i], CURRENCY, averagePrice, CURRENCY);

            } else
                System.out.printf("%s: %.2f %s%n", weekDays[i], productPrices[i], CURRENCY);
        }

        //Сортування
        for (int i = 0; i < COUNT_DAYS; i++) {
            for (int j = 1; j < (COUNT_DAYS - i); j++) {
                if (productPrices[j - 1] > productPrices[j]) {
                    double currPrice = productPrices[j - 1];
                    productPrices[j - 1] = productPrices[j];
                    productPrices[j] = currPrice;

                    //відсортуємо дні тижня
                    String day = weekDays[j - 1];
                    weekDays[j - 1] = weekDays[j];
                    weekDays[j] = day;
                }
            }
        }
        //вивід відсортованної ціни
        for (int i = 0; i < COUNT_DAYS; i++) {
            if (i == 0)
                System.out.printf("%n*** SORTED PRICES ***%n%s: %.2f %s%n", weekDays[i], productPrices[i], CURRENCY);
            else
                System.out.printf("%s: %.2f %s%n", weekDays[i], productPrices[i], CURRENCY);
        }

        System.out.printf("======================================================" +
                        "%nThe lowest price %.2f %s was recorded on %s" +
                        "%nThe highest price %.2f %s was recorded on %s" +
                        "%n======================================================%n",
                productPrices[0], CURRENCY, weekDays[0], productPrices[COUNT_DAYS - 1], CURRENCY, weekDays[COUNT_DAYS - 1]);
    }
}
