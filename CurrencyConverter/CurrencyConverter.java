import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class CurrencyConverter {

    private static final String API_KEY = "d590265e4acb43b3885dacbb7013be04";
    private static final String API_URL = "https://openexchangerates.org/api/latest.json?app_id=" + API_KEY;

    private static String getCurrencySymbol(String currencyCode) {
        switch (currencyCode) {
            case "USD":
                return "$";
            case "EUR":
                return "€";
            case "INR":
                return "₹";
            default:
                return "";
        }
    }

        public static void main(String[] args) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                Scanner scanner = new Scanner(System.in);
                System.err.println("****          WELCOME TO CURRENCY CONVERTER          ****");
                while (true) {
                    // Take user input for conversion
                    System.out.print("Enter Source currency code (E.g: USD): ");
                    String fromCurrency = reader.readLine().toUpperCase();
                    System.out.print("Enter Target currency code (E.g: EUR): ");
                    String toCurrency = reader.readLine().toUpperCase();
                    System.out.print("Enter Amount to convert: ");
                    double amount = Double.parseDouble(reader.readLine());
    
                    JSONObject exchangeRates = fetchExchangeRates();
    
                    String toCurrencySymbol = getCurrencySymbol(toCurrency);

                    double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency, exchangeRates);

                    System.out.println(amount + " " + fromCurrency + " = " +""+toCurrencySymbol+convertedAmount + " " + toCurrency);
    
                    System.out.print("Do you want to continue? (yes/no): ");
                    String continueChoice = scanner.nextLine().toLowerCase();
                    if (!continueChoice.equals("yes")) {
                        System.out.println("****    Thank you for using the currency converter. Have a great day!    ****");
                        break;
                    }
                }
                scanner.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    
    private static JSONObject fetchExchangeRates() throws IOException {
        @SuppressWarnings("deprecation")
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        // System.err.println(response.toString());
        return new JSONObject(response.toString());
    }

    private static double convertCurrency(double amount, String fromCurrency, String toCurrency, JSONObject exchangeRates) {
        double fromRate = exchangeRates.getJSONObject("rates").getDouble(fromCurrency);
        double toRate = exchangeRates.getJSONObject("rates").getDouble(toCurrency);
        return (amount / fromRate) * toRate;
    }
}
