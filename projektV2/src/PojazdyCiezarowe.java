class PojazdyCiezarowe extends Pojazdy {
    private int maksymalny_zaladunek;
    private int maksymalna_predkosc;

    public int getMaksymalny_zaladunek() {
        return maksymalny_zaladunek;
    }

    public void setMaksymalny_zaladunek(int maksymalny_zaladunek) {
        this.maksymalny_zaladunek = maksymalny_zaladunek;
    }

    public int getMaksymalna_predkosc() {
        return maksymalna_predkosc;
    }

    public void setMaksymalna_predkosc(int maksymalna_predkosc) {
        this.maksymalna_predkosc = maksymalna_predkosc;
    }

    public PojazdyCiezarowe(String rejestracja, double spalanie, int rok_produkcji, String marka,int maksymalny_zaladunek, int maksymalna_predkosc) {
        this.rejestracja = rejestracja;
        this.spalanie = spalanie;
        this.rok_produkcji = rok_produkcji;
        this.marka = marka;
        this.maksymalny_zaladunek = maksymalny_zaladunek;
        this.maksymalna_predkosc = maksymalna_predkosc;
    }

    @Override
    public String toString() {
        return "PojazdyCiezarowe{" +
                ", rejestracja='" + rejestracja + '\'' +
                ", spalanie=" + spalanie +
                ", rok_produkcji=" + rok_produkcji +
                ", marka='" + marka + '\'' +
                "maksymalny_zaladunek=" + maksymalny_zaladunek +
                ", maksymalna_predkosc=" + maksymalna_predkosc +
                '}';
    }
}
