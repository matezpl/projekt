import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Wypozyczenia {
    private long klient_pesel;
    private String rejestracja_pojazdu;
    private Date okres;
    private int przebieg;
    private String stan;

    public long getKlient_pesel() {
        return klient_pesel;
    }

    public void setKlient_pesel(long klient_pesel) {
        this.klient_pesel = klient_pesel;
    }

    public Date getOkres() {
        return okres;
    }
    public String getOkresSTR(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return formatter.format(okres);
    }

    public void setOkres(Date okres) {
        this.okres = okres;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public String getRejestracja_pojazdu() {
        return rejestracja_pojazdu;
    }

    public void setRejestracja_pojazdu(String rejestracja_pojazdu) {
        this.rejestracja_pojazdu = rejestracja_pojazdu;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public Wypozyczenia(long klient_pesel, String rejestracja_pojazdu, Date okres, int przebieg, String stan) {
        this.klient_pesel = klient_pesel;
        this.rejestracja_pojazdu = rejestracja_pojazdu;
        this.okres = okres;
        this.przebieg = przebieg;
        this.stan = stan;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return "Wypozyczenia{" +
                "klient_pesel=" + klient_pesel +
                ", rejestracja_pojazdu='" + rejestracja_pojazdu + '\'' +
                ", okres=" + formatter.format(okres) +
                ", przebieg=" + przebieg +
                ", stan='" + stan + '\'' +
                '}';
    }
}
