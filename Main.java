package ExchangeCalculator;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Lukasz on 25/10/2019.
 */
public
class Main {
    public static
    void main ( String[] args ) throws IOException {

        String nbpJson = downloadExchangeRatesJson(); //string w formacie json
        System.out.println(nbpJson);//podgląd stringa w formacie json

        Gson gson = new Gson();
        //deserializacja jsona za pomocą bibilioteki Gson
        Currency eurCurrency = gson.fromJson(nbpJson, Currency.class);//wyciągamy z jsona dane do obiektu klasy Currency
        //Currency usdCurrency = gson.fromJson(nbpJson, Currency.class);

        double eurRateValue = eurCurrency.rates.get(0).mid; //euro
        //double usdRateValue = eurCurrency.rates.get(0).mid; //dolary

        Date date = new Date();
        String today =  date.toString();
        System.out.println(today);

        String table = eurCurrency.table;
        //System.out.println("Table: " + table + "\nFor " + today);
        System.out.println("For " + today + " for 1 EUR you’ll get " + eurRateValue + " PLN." );
        //System.out.println("For " + today + " for 1 USD you’ll get " + eurRateValue + " PLN." );

        //ile kupimy Euro za 100 PLN
        double euroAmount = 100/eurRateValue;
        //System.out.format("%.2f%n", euroAmount);//zaokrąglenie do dwóch miejsc po przecinku "%.2f", %n - nowa linia
        System.out.format("For 100 PLN You can buy: %.2f EUR.",euroAmount);



    }

    private static
    String downloadExchangeRatesJson () throws IOException {

            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/eur?{format=json/");
            //URL url2 = new URL("http://api.nbp.pl/api/exchangerates/rates/a/usd?{format=json/");
            //URL url3 = new URL("http://api.nbp.pl/api/exchangerates/rates/a/gbp?{format=json/");
            //URL url4 = new URL("http://api.nbp.pl/api/exchangerates/rates/a/chf?{format=json/");
            //List<URL> currencyRatesList = new ArrayList<>();//+

            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Chrome");
            try {
                InputStream inputStream = urlConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                StringBuilder jsonTextSb = new StringBuilder();
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    jsonTextSb.append(line);
                }

                return jsonTextSb.toString();

        } catch (IOException e) {
            System.err.println("Pobieranie kursów nie powiodło się");
            e.printStackTrace();

            return null;
        }

    }
}

