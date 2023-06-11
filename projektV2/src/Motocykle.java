class Motocykle extends Pojazdy {
    public int pojemnosc_silnika;
    public int pojemnosc_baku;

    public int getPojemnosc_silnika() {
        return pojemnosc_silnika;
    }

    public void setPojemnosc_silnika(int pojemnosc_silnika) {
        this.pojemnosc_silnika = pojemnosc_silnika;
    }

    public int getPojemnosc_baku() {
        return pojemnosc_baku;
    }

    public void setPojemnosc_baku(int pojemnosc_baku) {
        this.pojemnosc_baku = pojemnosc_baku;
    }

    public Motocykle(String rejestracja, double spalanie, int rok_produkcji, String marka,int pojemnosc_silnika, int pojemnosc_baku) {
        this.rejestracja = rejestracja;
        this.spalanie = spalanie;
        this.rok_produkcji = rok_produkcji;
        this.marka = marka;
        this.pojemnosc_silnika = pojemnosc_silnika;
        this.pojemnosc_baku = pojemnosc_baku;
    }

    @Override
    public String toString() {
        return "Motocykle{" +
                ", rejestracja='" + rejestracja + '\'' +
                ", spalanie=" + spalanie +
                ", rok_produkcji=" + rok_produkcji +
                ", marka='" + marka + '\'' +
                "pojemnosc_silnika=" + pojemnosc_silnika +
                ", pojemnosc_baku=" + pojemnosc_baku +

                '}';
    }
}
