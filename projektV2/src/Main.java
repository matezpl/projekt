import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Wprowadz wprowadz = new Wprowadz();
        ArrayList<Klient> klienci = new ArrayList();
        Scanner sa = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            sa = new Scanner(new File("src/klienci.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku klienci.txt");
            throw new RuntimeException(e);
        }
        while (sa.hasNextLine()){
            String dane[]=sa.nextLine().split(" ");
            klienci.add(new Klient(Long.parseLong(dane[0]),dane[1],dane[2]));
        }
        sa.close();
        ArrayList<PojazdyOsobowe> pojazdy_osobowe = new ArrayList();
        try {
            sa = new Scanner(new File("src/pojazdy_osobowe.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku pojazdy_osobowe.txt");
            throw new RuntimeException(e);
        }
        while (sa.hasNextLine()){
            String dane[]=sa.nextLine().split(" ");
            pojazdy_osobowe.add(new PojazdyOsobowe(dane[0],Double.parseDouble(dane[1]),Integer.parseInt(dane[2]),dane[3],Integer.parseInt(dane[4]),Integer.parseInt(dane[5])));
        }
        sa.close();
        ArrayList<PojazdyCiezarowe> pojazdy_ciezarowe = new ArrayList();
        try {
            sa = new Scanner(new File("src/pojazdy_ciezarowe.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku pojazdy_ciezarowe.txt");
            throw new RuntimeException(e);
        }
        while (sa.hasNextLine()){
            String dane[]=sa.nextLine().split(" ");
            pojazdy_ciezarowe.add(new PojazdyCiezarowe(dane[0],Double.parseDouble(dane[1]),Integer.parseInt(dane[2]),dane[3],Integer.parseInt(dane[4]),Integer.parseInt(dane[5])));
        }
        sa.close();
        ArrayList<Motocykle> motocykle = new ArrayList();
        try {
            sa = new Scanner(new File("src/motocykle.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku motocykle.txt");
            throw new RuntimeException(e);
        }
        while (sa.hasNextLine()){
            String dane[]=sa.nextLine().split(" ");
            motocykle.add(new Motocykle(dane[0],Double.parseDouble(dane[1]),Integer.parseInt(dane[2]),dane[3],Integer.parseInt(dane[4]),Integer.parseInt(dane[5])));
        }
        sa.close();
        ArrayList<Wypozyczenia> wypozyczenia = new ArrayList();
        try {
            sa = new Scanner(new File("src/wypozyczenia.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku wypozyczenia.txt");
            throw new RuntimeException(e);
        }
        while (sa.hasNextLine()){
            String dane[]=sa.nextLine().split(" ");
            wypozyczenia.add(new Wypozyczenia(Long.parseLong(dane[0]),dane[1],formatter.parse(dane[2]),Integer.parseInt(dane[3]),dane[4]));
        }
        sa.close();
        String opcja=null;
        while (!Objects.equals(opcja, "q")){
            System.out.println("1 - klienci\n2 - pojazdy\n3 - wypozyczenia\n4 - dostepnosc pojazdow\ns - zapisz\nq - wyjscie");
            opcja= wprowadz.wypisz_String();
            switch (opcja){
                case "1":
                    System.out.println("1 - dodaj klienta\n2 - usun klienta\n3 - wyszukaj klienta\n4 - przegladaj klientow");
                    int opcja2 = wprowadz.wypisz_int();
                    switch (opcja2){
                        case 1:
                            int i;
                            long pesel;
                            do {
                                i=0;
                                System.out.println("Podaj pesel klienta");
                                pesel = wprowadz.wypisz_long();
                                for (int j=0;j< klienci.size();j++){
                                    if (klienci.get(j).getPesel()==pesel){
                                        i=1;
                                    }
                                }
                                if (i==1){
                                    System.out.println("pesel musi byc unikalne");
                                }
                            }while (i!=0);
                            System.out.println("Podaj imie klienta");
                            String imie = wprowadz.wypisz_String();
                            System.out.println("Podaj nazwisko klienta");
                            String nazwisko = wprowadz.wypisz_String();
                            klienci.add(new Klient(pesel,imie,nazwisko));
                            break;
                        case 2:
                            System.out.println("Podaj pesel klienta, ktorego chcesz usunac");
                            long pesel2= wprowadz.wypisz_long();
                            for (int j=0;j< klienci.size();j++){
                                if (klienci.get(j).getPesel()==pesel2){
                                    klienci.remove(j);
                                    System.out.println("Usunieto klienta o nr pesel = "+pesel2);
                                }

                            }
                            break;
                        case 3:
                            System.out.println("1 - wyszukiwanie po nr pesel\n2 - wyszukiwanie po imieniu\n3 - wyszukiwanie po nazwisku");
                            int opcja3= wprowadz.wypisz_int();
                            switch (opcja3){
                                case 1:
                                    System.out.println("Podaj nr pesel klienta");
                                    long pesel3= wprowadz.wypisz_long();
                                    for (int j=0;j< klienci.size();j++){
                                        if (klienci.get(j).getPesel()==pesel3){
                                            System.out.println(klienci.get(j).getPesel()+" "+klienci.get(j).getImie()+" "+klienci.get(j).getNazwisko());
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Podaj imie klienta");
                                    String imie2= wprowadz.wypisz_String();
                                    for (int j=0;j< klienci.size();j++){
                                        if (klienci.get(j).getImie().toLowerCase().contains(imie2.toLowerCase())){
                                            System.out.println(klienci.get(j).getPesel()+" "+klienci.get(j).getImie()+" "+klienci.get(j).getNazwisko());
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Podaj nazwisko klienta");
                                    String nazwisko2= wprowadz.wypisz_String();
                                    for (int j=0;j< klienci.size();j++){
                                        if (klienci.get(j).getNazwisko().toLowerCase().contains(nazwisko2.toLowerCase())){
                                            System.out.println(klienci.get(j).getPesel()+" "+klienci.get(j).getImie()+" "+klienci.get(j).getNazwisko());
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Nieprawidlowa opcja");
                                    break;
                            }
                            break;
                        case 4:
                            for (int j=0;j< klienci.size();j++){
                                System.out.println(klienci.get(j).getPesel()+" "+klienci.get(j).getImie()+" "+klienci.get(j).getNazwisko());
                            }
                            break;
                        default:
                            System.out.println("Nieprawidlowa opcja");
                            break;
                    }
                    break;
                case "2":
                    System.out.println("1 - pojazdy osobowe\n2 - pojazdy ciezarowe\n3 - motocykle\n");
                    int opcja3= wprowadz.wypisz_int();
                    switch (opcja3){
                        case 1:
                            System.out.println("1 - dodaj pojazd osobowy\n2 - usun pojazd osobowy\n3 - wyszukaj pojazd osobowy\n4 - przegladaj pojazdy osobowe");
                            int opcja4= wprowadz.wypisz_int();
                            switch (opcja4) {
                                case 1:
                                    int k;
                                    String rejestarcja;
                                    do {
                                        k = 0;
                                        System.out.println("Podaj rejestracje pojazdu");
                                        rejestarcja = wprowadz.wypisz_String();
                                        for (int j = 0; j < pojazdy_osobowe.size(); j++) {
                                            if (pojazdy_osobowe.get(j).getRejestracja().toLowerCase().equals(rejestarcja.toLowerCase())) {
                                                k = 1;
                                            }
                                        }
                                        for (int j = 0; j < pojazdy_ciezarowe.size(); j++) {
                                            if (pojazdy_ciezarowe.get(j).getRejestracja().toLowerCase().equals(rejestarcja.toLowerCase())) {
                                                k = 1;
                                            }
                                        }
                                        for (int j = 0; j < motocykle.size(); j++) {
                                            if (motocykle.get(j).getRejestracja().toLowerCase().equals(rejestarcja.toLowerCase())) {
                                                k = 1;
                                            }
                                        }
                                        if (k == 1) {
                                            System.out.println("rejestracja musi byc unikalna");
                                        }
                                    } while (k != 0);
                                    System.out.println("Podaj spalanie pojazdu");
                                    double spalnie = wprowadz.wypisz_double();
                                    System.out.println("Podaj rok produkcji pojazdu");
                                    int rok_produkcji = wprowadz.wypisz_int();
                                    System.out.println("Podaj marke pojazdu");
                                    String marka = wprowadz.wypisz_String();
                                    System.out.println("Podaj ilosc drzwi pojazdu");
                                    int ilosc_drzwi = wprowadz.wypisz_int();
                                    System.out.println("Podaj ilosc miejsc pojazdu");
                                    int ilosc_miejsc = wprowadz.wypisz_int();
                                    pojazdy_osobowe.add(new PojazdyOsobowe(rejestarcja, spalnie, rok_produkcji, marka, ilosc_drzwi, ilosc_miejsc));
                                    break;
                                case 2:
                                    System.out.println("Podaj rejestracje pojazdu, ktorego chcesz usunac");
                                    String rejestracja2 = wprowadz.wypisz_String();
                                    for (int j = 0; j < pojazdy_osobowe.size(); j++) {
                                        if (pojazdy_osobowe.get(j).getRejestracja().toLowerCase().equals(rejestracja2.toLowerCase())) {
                                            pojazdy_osobowe.remove(j);
                                            System.out.println("Usunieto pojazd o nr rejestracji = " + rejestracja2);
                                        }

                                    }
                                    break;
                                case 3:
                                    System.out.println("1 - wyszukiwanie po nr rejestracji pojazdu\n2 - wyszukiwanie po nazwie marki pojazdu");
                                    int opcja5 = wprowadz.wypisz_int();
                                    switch (opcja5) {
                                        case 1:
                                            System.out.println("Podaj rejestarcje pojazdu");
                                            String rejestracja3 = wprowadz.wypisz_String();
                                            for (int j = 0; j < pojazdy_osobowe.size(); j++) {
                                                if (pojazdy_osobowe.get(j).getRejestracja().toLowerCase().contains(rejestracja3.toLowerCase())) {
                                                    System.out.println(pojazdy_osobowe.get(j).getRejestracja() + " " + pojazdy_osobowe.get(j).getSpalanie() + " " + pojazdy_osobowe.get(j).getRok_produkcji() + " " + pojazdy_osobowe.get(j).getMarka() + " " + pojazdy_osobowe.get(j).getIlosc_drzwi() + " " + pojazdy_osobowe.get(j).getIlosc_miejsc());
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Podaj marke pojazdu");
                                            String marka2 = wprowadz.wypisz_String();
                                            for (int j = 0; j < pojazdy_osobowe.size(); j++) {
                                                if (pojazdy_osobowe.get(j).getMarka().toLowerCase().contains(marka2.toLowerCase())) {
                                                    System.out.println(pojazdy_osobowe.get(j).getRejestracja() + " " + pojazdy_osobowe.get(j).getSpalanie() + " " + pojazdy_osobowe.get(j).getRok_produkcji() + " " + pojazdy_osobowe.get(j).getMarka() + " " + pojazdy_osobowe.get(j).getIlosc_drzwi() + " " + pojazdy_osobowe.get(j).getIlosc_miejsc());
                                                }
                                            }
                                            break;
                                        default:
                                            System.out.println("Nieprawidlowa opcja");
                                            break;
                                    }
                                    break;
                                case 4:
                                    for (int j = 0; j < pojazdy_osobowe.size(); j++) {
                                        System.out.println(pojazdy_osobowe.get(j).getRejestracja() + " " + pojazdy_osobowe.get(j).getSpalanie() + " " + pojazdy_osobowe.get(j).getRok_produkcji() + " " + pojazdy_osobowe.get(j).getMarka() + " " + pojazdy_osobowe.get(j).getIlosc_drzwi() + " " + pojazdy_osobowe.get(j).getIlosc_miejsc());
                                    }
                                    break;
                                default:
                                    System.out.println("Nieprawidlowa opcja");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("1 - dodaj pojazd ciezarowy\n2 - usun pojazd ciezarowy\n3 - wyszukaj pojazd ciezarowy\n4 - przegladaj pojazdy ciezarowe");
                            int opcja6= wprowadz.wypisz_int();
                            switch (opcja6) {
                                case 1:
                                    int k;
                                    String rejestarcja;
                                    do {
                                        k = 0;
                                        System.out.println("Podaj rejestracje pojazdu");
                                        rejestarcja = wprowadz.wypisz_String();
                                        for (int j = 0; j < pojazdy_osobowe.size(); j++) {
                                            if (pojazdy_osobowe.get(j).getRejestracja().toLowerCase().equals(rejestarcja.toLowerCase())) {
                                                k = 1;
                                            }
                                        }
                                        for (int j = 0; j < pojazdy_ciezarowe.size(); j++) {
                                            if (pojazdy_ciezarowe.get(j).getRejestracja().toLowerCase().equals(rejestarcja.toLowerCase())) {
                                                k = 1;
                                            }
                                        }
                                        for (int j = 0; j < motocykle.size(); j++) {
                                            if (motocykle.get(j).getRejestracja().toLowerCase().equals(rejestarcja.toLowerCase())) {
                                                k = 1;
                                            }
                                        }
                                        if (k == 1) {
                                            System.out.println("rejestracja musi byc unikalna");
                                        }
                                    } while (k != 0);
                                    System.out.println("Podaj spalanie pojazdu");
                                    double spalnie = wprowadz.wypisz_double();
                                    System.out.println("Podaj rok produkcji pojazdu");
                                    int rok_produkcji = wprowadz.wypisz_int();
                                    System.out.println("Podaj marke pojazdu");
                                    String marka = wprowadz.wypisz_String();
                                    System.out.println("Podaj maksymalny zaladunek pojazdu");
                                    int max_zal = wprowadz.wypisz_int();
                                    System.out.println("Podaj maksymalna predkosc pojazdu");
                                    int max_pr = wprowadz.wypisz_int();
                                    pojazdy_ciezarowe.add(new PojazdyCiezarowe(rejestarcja, spalnie, rok_produkcji, marka, max_zal, max_pr));
                                    break;
                                case 2:
                                    System.out.println("Podaj rejestracje pojazdu, ktorego chcesz usunac");
                                    String rejestracja2 = wprowadz.wypisz_String();
                                    for (int j = 0; j < pojazdy_ciezarowe.size(); j++) {
                                        if (pojazdy_ciezarowe.get(j).getRejestracja().toLowerCase().equals(rejestracja2.toLowerCase())) {
                                            pojazdy_ciezarowe.remove(j);
                                            System.out.println("Usunieto pojazd o nr rejestracji = " + rejestracja2);
                                        }

                                    }
                                    break;
                                case 3:
                                    System.out.println("1 - wyszukiwanie po nr rejestracji pojazdu\n2 - wyszukiwanie po nazwie marki pojazdu");
                                    int opcja5 = wprowadz.wypisz_int();
                                    switch (opcja5) {
                                        case 1:
                                            System.out.println("Podaj rejestarcje pojazdu");
                                            String rejestracja3 = wprowadz.wypisz_String();
                                            for (int j = 0; j < pojazdy_ciezarowe.size(); j++) {
                                                if (pojazdy_ciezarowe.get(j).getRejestracja().toLowerCase().contains(rejestracja3.toLowerCase())) {
                                                    System.out.println(pojazdy_ciezarowe.get(j).getRejestracja() + " " + pojazdy_ciezarowe.get(j).getSpalanie() + " " + pojazdy_ciezarowe.get(j).getRok_produkcji() + " " + pojazdy_ciezarowe.get(j).getMarka() + " " + pojazdy_ciezarowe.get(j).getMaksymalny_zaladunek() + " " + pojazdy_ciezarowe.get(j).getMaksymalna_predkosc());
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Podaj marke pojazdu");
                                            String marka2 = wprowadz.wypisz_String();
                                            for (int j = 0; j < pojazdy_ciezarowe.size(); j++) {
                                                if (pojazdy_ciezarowe.get(j).getMarka().toLowerCase().contains(marka2.toLowerCase())) {
                                                    System.out.println(pojazdy_ciezarowe.get(j).getRejestracja() + " " + pojazdy_ciezarowe.get(j).getSpalanie() + " " + pojazdy_ciezarowe.get(j).getRok_produkcji() + " " + pojazdy_ciezarowe.get(j).getMarka() + " " + pojazdy_ciezarowe.get(j).getMaksymalny_zaladunek() + " " + pojazdy_ciezarowe.get(j).getMaksymalna_predkosc());
                                                }
                                            }
                                            break;
                                        default:
                                            System.out.println("Nieprawidlowa opcja");
                                            break;
                                    }
                                    break;
                                case 4:
                                    for (int j = 0; j < pojazdy_ciezarowe.size(); j++) {
                                        System.out.println(pojazdy_ciezarowe.get(j).getRejestracja() + " " + pojazdy_ciezarowe.get(j).getSpalanie() + " " + pojazdy_ciezarowe.get(j).getRok_produkcji() + " " + pojazdy_ciezarowe.get(j).getMarka() + " " + pojazdy_ciezarowe.get(j).getMaksymalny_zaladunek() + " " + pojazdy_ciezarowe.get(j).getMaksymalna_predkosc());
                                    }
                                    break;
                                default:
                                    System.out.println("Nieprawidlowa opcja");
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("1 - dodaj motocykl\n2 - usun motocykl\n3 - wyszukaj motocykl\n4 - przegladaj motocykle");
                            int opcja7= wprowadz.wypisz_int();
                            switch (opcja7) {
                                case 1:
                                    int k;
                                    String rejestarcja;
                                    do {
                                        k = 0;
                                        System.out.println("Podaj rejestracje pojazdu");
                                        rejestarcja = wprowadz.wypisz_String();
                                        for (int j = 0; j < pojazdy_osobowe.size(); j++) {
                                            if (pojazdy_osobowe.get(j).getRejestracja().toLowerCase().equals(rejestarcja.toLowerCase())) {
                                                k = 1;
                                            }
                                        }
                                        for (int j = 0; j < pojazdy_ciezarowe.size(); j++) {
                                            if (pojazdy_ciezarowe.get(j).getRejestracja().toLowerCase().equals(rejestarcja.toLowerCase())) {
                                                k = 1;
                                            }
                                        }
                                        for (int j = 0; j < motocykle.size(); j++) {
                                            if (motocykle.get(j).getRejestracja().toLowerCase().equals(rejestarcja.toLowerCase())) {
                                                k = 1;
                                            }
                                        }
                                        if (k == 1) {
                                            System.out.println("rejestracja musi byc unikalna");
                                        }
                                    } while (k != 0);
                                    System.out.println("Podaj spalanie pojazdu");
                                    double spalnie = wprowadz.wypisz_double();
                                    System.out.println("Podaj rok produkcji pojazdu");
                                    int rok_produkcji = wprowadz.wypisz_int();
                                    System.out.println("Podaj marke pojazdu");
                                    String marka = wprowadz.wypisz_String();
                                    System.out.println("Podaj pojemnosc silnika pojazdu");
                                    int poj_sil = wprowadz.wypisz_int();
                                    System.out.println("Podaj pojemnosc baku pojazdu");
                                    int poj_bak = wprowadz.wypisz_int();
                                    motocykle.add(new Motocykle(rejestarcja, spalnie, rok_produkcji, marka, poj_sil, poj_bak));
                                    break;
                                case 2:
                                    System.out.println("Podaj rejestracje pojazdu, ktorego chcesz usunac");
                                    String rejestracja2 = wprowadz.wypisz_String();
                                    for (int j = 0; j < motocykle.size(); j++) {
                                        if (motocykle.get(j).getRejestracja().toLowerCase().equals(rejestracja2.toLowerCase())) {
                                            motocykle.remove(j);
                                            System.out.println("Usunieto pojazd o nr rejestracji = " + rejestracja2);
                                        }

                                    }
                                    break;
                                case 3:
                                    System.out.println("1 - wyszukiwanie po nr rejestracji pojazdu\n2 - wyszukiwanie po nazwie marki pojazdu");
                                    int opcja5 = wprowadz.wypisz_int();
                                    switch (opcja5) {
                                        case 1:
                                            System.out.println("Podaj rejestarcje pojazdu");
                                            String rejestracja3 = wprowadz.wypisz_String();
                                            for (int j = 0; j < motocykle.size(); j++) {
                                                if (motocykle.get(j).getRejestracja().toLowerCase().contains(rejestracja3.toLowerCase())) {
                                                    System.out.println(motocykle.get(j).getRejestracja()+" "+motocykle.get(j).getSpalanie()+" "+motocykle.get(j).getRok_produkcji()+" "+motocykle.get(j).getMarka()+" "+motocykle.get(j).getPojemnosc_silnika()+" "+motocykle.get(j).getPojemnosc_baku());
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Podaj marke pojazdu");
                                            String marka2 = wprowadz.wypisz_String();
                                            for (int j = 0; j < motocykle.size(); j++) {
                                                if (motocykle.get(j).getMarka().toLowerCase().contains(marka2.toLowerCase())) {
                                                    System.out.println(motocykle.get(j).getRejestracja()+" "+motocykle.get(j).getSpalanie()+" "+motocykle.get(j).getRok_produkcji()+" "+motocykle.get(j).getMarka()+" "+motocykle.get(j).getPojemnosc_silnika()+" "+motocykle.get(j).getPojemnosc_baku());
                                                }
                                            }
                                            break;
                                        default:
                                            System.out.println("Nieprawidlowa opcja");
                                            break;
                                    }
                                    break;
                                case 4:
                                    for (int j = 0; j < motocykle.size(); j++) {
                                        System.out.println(motocykle.get(j).getRejestracja()+" "+motocykle.get(j).getSpalanie()+" "+motocykle.get(j).getRok_produkcji()+" "+motocykle.get(j).getMarka()+" "+motocykle.get(j).getPojemnosc_silnika()+" "+motocykle.get(j).getPojemnosc_baku());
                                    }
                                    break;
                                default:
                                    System.out.println("Nieprawidlowa opcja");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Nieprawidlowa opcja");
                            break;



                    }
                    break;
                case "3":
                    System.out.println("1 - dodaj wypozyczenie\n2 - przegladaj wypozyczenia");
                    int opcja8=wprowadz.wypisz_int();
                    switch (opcja8){
                        case 1:
                            System.out.println("Podaj pesel klienta");
                            long pesel= wprowadz.wypisz_long();
                            System.out.println("Podaj rejestracje pojazdu");
                            String rejsetracja= wprowadz.wypisz_String();
                            System.out.println("Podaj okres wypozyczenia (dd-mm-rrrr)");
                            Scanner sz=new Scanner(System.in);
                            Date data_w=new SimpleDateFormat("dd-MM-yyyy").parse(sz.next());
                            System.out.println("Podaj przebieg pojazdu");
                            int przebieg= wprowadz.wypisz_int();
                            System.out.println("Podaj stan pojazdu (wypozyczony, zwrocony)");
                            String stan=sz.next();
                            wypozyczenia.add(new Wypozyczenia(pesel,rejsetracja,data_w,przebieg,stan));
                            break;
                        case 2:
                            for (int j = 0; j < wypozyczenia.size(); j++) {
                                System.out.println(wypozyczenia.get(j).getKlient_pesel()+" "+wypozyczenia.get(j).getRejestracja_pojazdu()+" "+wypozyczenia.get(j).getOkresSTR()+" "+wypozyczenia.get(j).getPrzebieg()+" "+wypozyczenia.get(j).getStan());
                            }
                            break;
                        default:
                            System.out.println("Nieprawidlowa opcja");
                            break;
                    }
                    break;
                case "4":
                    System.out.println("1 - pojazdy dostepne\n2 - pojazdy wypozyczone\n3 - pojazdy wypozyczone z zaleglym terminem zwrotu");
                    int opcja9=wprowadz.wypisz_int();
                    switch (opcja9){
                        case 1:
                            ArrayList<Wypozyczenia> wypozyczone = new ArrayList();
                            for (int j=0;j<pojazdy_osobowe.size();j++){
                                for (int k=0;k< wypozyczenia.size();k++){
                                    if (wypozyczenia.get(k).getStan().equals("wypozyczony") && pojazdy_osobowe.get(j).getRejestracja().equals(wypozyczenia.get(k).getRejestracja_pojazdu()) ){
                                        wypozyczone.add(new Wypozyczenia(wypozyczenia.get(k).getKlient_pesel(),wypozyczenia.get(k).getRejestracja_pojazdu(),wypozyczenia.get(k).getOkres(),wypozyczenia.get(k).getPrzebieg(),wypozyczenia.get(k).getStan()));
                                    }
                                }
                            }
                            for (int j=0;j<pojazdy_ciezarowe.size();j++){
                                for (int k=0;k< wypozyczenia.size();k++){
                                    if (wypozyczenia.get(k).getStan().equals("wypozyczony") && pojazdy_ciezarowe.get(j).getRejestracja().equals(wypozyczenia.get(k).getRejestracja_pojazdu()) ){
                                        wypozyczone.add(new Wypozyczenia(wypozyczenia.get(k).getKlient_pesel(),wypozyczenia.get(k).getRejestracja_pojazdu(),wypozyczenia.get(k).getOkres(),wypozyczenia.get(k).getPrzebieg(),wypozyczenia.get(k).getStan()));
                                    }
                                }
                            }
                            for (int j=0;j<motocykle.size();j++){
                                for (int k=0;k< wypozyczenia.size();k++){
                                    if (wypozyczenia.get(k).getStan().equals("wypozyczony") && motocykle.get(j).getRejestracja().equals(wypozyczenia.get(k).getRejestracja_pojazdu()) ){
                                        wypozyczone.add(new Wypozyczenia(wypozyczenia.get(k).getKlient_pesel(),wypozyczenia.get(k).getRejestracja_pojazdu(),wypozyczenia.get(k).getOkres(),wypozyczenia.get(k).getPrzebieg(),wypozyczenia.get(k).getStan()));
                                    }
                                }
                            }
                            for (int j=0;j<pojazdy_osobowe.size();j++){
                                int a=0;
                                for (int k=0;k<wypozyczone.size();k++){
                                    if (wypozyczone.get(k).getRejestracja_pojazdu().equals(pojazdy_osobowe.get(j).getRejestracja())){
                                        a=1;
                                    }
                                }
                                if(a==0){
                                    System.out.println(pojazdy_osobowe.get(j).getRejestracja()+" "+pojazdy_osobowe.get(j).getSpalanie()+" "+pojazdy_osobowe.get(j).getRok_produkcji()+" "+pojazdy_osobowe.get(j).getMarka()+" "+pojazdy_osobowe.get(j).getIlosc_drzwi()+" "+pojazdy_osobowe.get(j).getIlosc_miejsc());
                                }
                            }
                            for (int j=0;j<pojazdy_ciezarowe.size();j++){
                                int a=0;
                                for (int k=0;k<wypozyczone.size();k++){
                                    if (wypozyczone.get(k).getRejestracja_pojazdu().equals(pojazdy_ciezarowe.get(j).getRejestracja())){
                                        a=1;
                                    }
                                }
                                if(a==0){
                                    System.out.println(pojazdy_ciezarowe.get(j).getRejestracja()+" "+pojazdy_ciezarowe.get(j).getSpalanie()+" "+pojazdy_ciezarowe.get(j).getRok_produkcji()+" "+pojazdy_ciezarowe.get(j).getMarka()+" "+pojazdy_ciezarowe.get(j).getMaksymalny_zaladunek()+" "+pojazdy_ciezarowe.get(j).getMaksymalna_predkosc());
                                }
                            }
                            for (int j=0;j<motocykle.size();j++){
                                int a=0;
                                for (int k=0;k<wypozyczone.size();k++){
                                    if (wypozyczone.get(k).getRejestracja_pojazdu().equals(motocykle.get(j).getRejestracja())){
                                        a=1;
                                    }
                                }
                                if(a==0){
                                    System.out.println(motocykle.get(j).getRejestracja()+" "+motocykle.get(j).getSpalanie()+" "+motocykle.get(j).getRok_produkcji()+" "+motocykle.get(j).getMarka()+" "+motocykle.get(j).getPojemnosc_silnika()+" "+motocykle.get(j).getPojemnosc_baku());
                                }
                            }
                            break;
                        case 2:
                            for (int j=0;j<pojazdy_osobowe.size();j++){
                                for (int k=0;k< wypozyczenia.size();k++){
                                    if (wypozyczenia.get(k).getStan().equals("wypozyczony") && pojazdy_osobowe.get(j).getRejestracja().equals(wypozyczenia.get(k).getRejestracja_pojazdu()) ){
                                        System.out.println(pojazdy_osobowe.get(j).getRejestracja()+" "+pojazdy_osobowe.get(j).getSpalanie()+" "+pojazdy_osobowe.get(j).getRok_produkcji()+" "+pojazdy_osobowe.get(j).getMarka()+" "+pojazdy_osobowe.get(j).getIlosc_drzwi()+" "+pojazdy_osobowe.get(j).getIlosc_miejsc());
                                    }
                                }
                            }
                            for (int j=0;j<pojazdy_ciezarowe.size();j++){
                                for (int k=0;k< wypozyczenia.size();k++){
                                    if (wypozyczenia.get(k).getStan().equals("wypozyczony") && pojazdy_ciezarowe.get(j).getRejestracja().equals(wypozyczenia.get(k).getRejestracja_pojazdu()) ){
                                        System.out.println(pojazdy_ciezarowe.get(j).getRejestracja()+" "+pojazdy_ciezarowe.get(j).getSpalanie()+" "+pojazdy_ciezarowe.get(j).getRok_produkcji()+" "+pojazdy_ciezarowe.get(j).getMarka()+" "+pojazdy_ciezarowe.get(j).getMaksymalny_zaladunek()+" "+pojazdy_ciezarowe.get(j).getMaksymalna_predkosc());
                                    }
                                }
                            }
                            for (int j=0;j<motocykle.size();j++){
                                for (int k=0;k< wypozyczenia.size();k++){
                                    if (wypozyczenia.get(k).getStan().equals("wypozyczony") && motocykle.get(j).getRejestracja().equals(wypozyczenia.get(k).getRejestracja_pojazdu()) ){
                                        System.out.println(motocykle.get(j).getRejestracja()+" "+motocykle.get(j).getSpalanie()+" "+motocykle.get(j).getRok_produkcji()+" "+motocykle.get(j).getMarka()+" "+motocykle.get(j).getPojemnosc_silnika()+" "+motocykle.get(j).getPojemnosc_baku());
                                    }
                                }
                            }
                                break;
                        case 3:
                            Date d_data = formatter.parse(formatter.format(Calendar.getInstance().getTime()));
                            for (int j=0;j<wypozyczenia.size();j++){
                                if (wypozyczenia.get(j).getStan().equals("wypozyczony") && d_data.compareTo(wypozyczenia.get(j).getOkres())>0){
                                    System.out.println(wypozyczenia.get(j).getKlient_pesel()+" "+wypozyczenia.get(j).getRejestracja_pojazdu()+" "+wypozyczenia.get(j).getOkresSTR()+" "+wypozyczenia.get(j).getPrzebieg()+" "+wypozyczenia.get(j).getStan());
                                }
                            }
                            break;
                        default:
                            System.out.println("Nieprawidlowa opcja");
                            break;
                    }
                    break;
                case "s":
                    PrintWriter writer = new PrintWriter("src/klienci.txt");
                    for (int j=0;j< klienci.size();j++){
                        writer.println(klienci.get(j).getPesel()+" "+klienci.get(j).getImie()+" "+klienci.get(j).getNazwisko());
                    }
                    writer.close();
                    writer = new PrintWriter("src/pojazdy_osobowe.txt");
                    for (int j=0;j< pojazdy_osobowe.size();j++){
                        writer.println(pojazdy_osobowe.get(j).getRejestracja()+" "+pojazdy_osobowe.get(j).getSpalanie()+" "+pojazdy_osobowe.get(j).getRok_produkcji()+" "+pojazdy_osobowe.get(j).getMarka()+" "+pojazdy_osobowe.get(j).getIlosc_drzwi()+" "+pojazdy_osobowe.get(j).getIlosc_miejsc());
                    }
                    writer.close();
                    writer = new PrintWriter("src/pojazdy_ciezarowe.txt");
                    for (int j=0;j< pojazdy_ciezarowe.size();j++){
                        writer.println(pojazdy_ciezarowe.get(j).getRejestracja()+" "+pojazdy_ciezarowe.get(j).getSpalanie()+" "+pojazdy_ciezarowe.get(j).getRok_produkcji()+" "+pojazdy_ciezarowe.get(j).getMarka()+" "+pojazdy_ciezarowe.get(j).getMaksymalny_zaladunek()+" "+pojazdy_ciezarowe.get(j).getMaksymalna_predkosc());
                    }
                    writer.close();
                    writer = new PrintWriter("src/motocykle.txt");
                    for (int j=0;j< motocykle.size();j++){
                        writer.println(motocykle.get(j).getRejestracja()+" "+motocykle.get(j).getSpalanie()+" "+motocykle.get(j).getRok_produkcji()+" "+motocykle.get(j).getMarka()+" "+motocykle.get(j).getPojemnosc_silnika()+" "+motocykle.get(j).getPojemnosc_baku());
                    }
                    writer.close();
                    writer = new PrintWriter("src/wypozyczenia.txt");
                    for (int j=0;j< wypozyczenia.size();j++){
                        writer.println(wypozyczenia.get(j).getKlient_pesel()+" "+wypozyczenia.get(j).getRejestracja_pojazdu()+" "+wypozyczenia.get(j).getOkresSTR()+" "+wypozyczenia.get(j).getPrzebieg()+" "+wypozyczenia.get(j).getStan());
                    }
                    writer.close();
                    break;
                case "q":
                    break;
                default:
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }
        }
    }
}