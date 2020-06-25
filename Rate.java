package ExchangeCalculator;

/**
 * Created by Lukasz on 30/10/2019.
 */
public
class Rate {
    public String no;
    public String effectiveDate;
    public double mid;

    public
    Rate ( final String no, final String effectiveDate, final double mid ) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public
    String getNo () {
        return no;
    }

    public
    void setNo ( final String no ) {
        this.no = no;
    }

    public
    String getEffectiveDate () {
        return effectiveDate;
    }

    public
    void setEffectiveDate ( final String effectiveDate ) {
        this.effectiveDate = effectiveDate;
    }

    public
    double getMid () {
        return mid;
    }

    public
    void setMid ( final double mid ) {
        this.mid = mid;
    }
}
