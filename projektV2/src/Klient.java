public class Klient {
    private long pesel;
    private String imie;
    private String nazwisko;

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public Klient(long pesel, String imie, String nazwisko){
        this.pesel = pesel;
        this.imie=imie;
        this.nazwisko=nazwisko;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "pesel=" + pesel +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
