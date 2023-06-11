class PojazdyOsobowe extends Pojazdy {
    private int ilosc_drzwi;
    private int ilosc_miejsc;

    public int getIlosc_drzwi() {
        return ilosc_drzwi;
    }

    public void setIlosc_drzwi(int ilosc_drzwi) {
        this.ilosc_drzwi = ilosc_drzwi;
    }

    public int getIlosc_miejsc() {
        return ilosc_miejsc;
    }

    public void setIlosc_miejsc(int ilosc_miejsc) {
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public PojazdyOsobowe(String rejestracja, double spalanie, int rok_produkcji, String marka,int ilosc_drzwi, int ilosc_miejsc) {
        this.rejestracja = rejestracja;
        this.spalanie = spalanie;
        this.rok_produkcji = rok_produkcji;
        this.marka = marka;
        this.ilosc_drzwi = ilosc_drzwi;
        this.ilosc_miejsc = ilosc_miejsc;
    }

    @Override
    public String toString() {
        return "PojazdyOsobowe{" +
                ", rejestracja='" + rejestracja + '\'' +
                ", spalanie=" + spalanie +
                ", rok_produkcji=" + rok_produkcji +
                ", marka='" + marka + '\'' +
                "ilosc_drzwi=" + ilosc_drzwi +
                ", ilosc_miejsc=" + ilosc_miejsc +
                '}';
    }
}
