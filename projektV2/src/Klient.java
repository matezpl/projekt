public class Klient {
    private String pesel;
    private String imie;
    private String nazwisko;

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
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
    public Klient(String pesel, String imie, String nazwisko){
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
