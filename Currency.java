package ExchangeCalculator;

import java.util.List;

import static java.util.Arrays.*;

/**
 * Created by Lukasz on 25/10/2019.
 */
public
class Currency {

    public String table;
    public String currency;
    public String code;
    public List<Rate> rates;


    public
    Currency ( final String table, final String currency, final String code, final Rate[] rates ) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = asList(rates);
    }

    public
    String getTable () {
        return table;
    }

    public
    void setTable ( final String table ) {
        this.table = table;
    }

    public
    String getCurrency () {
        return currency;
    }

    public
    void setCurrency ( final String currency ) {
        this.currency = currency;
    }

    public
    String getCode () {
        return code;
    }

    public
    void setCode ( final String code ) {
        this.code = code;
    }

    public
    List<Rate> getRates () {
        return rates;
    }

    public
    void setRates ( final Rate[] rates ) {
        this.rates = asList(rates);
    }
}
