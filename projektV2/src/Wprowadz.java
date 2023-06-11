import java.util.InputMismatchException;
import java.util.Scanner;

public class Wprowadz {
    public int wypisz_int(){
        int zmienna = -4087;
        do{
            Scanner sa=new Scanner(System.in);
            try {
                zmienna = sa.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Niepoprawnie podana wartosc, sprobuj ponownie");
                sa.nextLine();
            }
        }while (zmienna==-4087);
        return zmienna;
    }
    public double wypisz_double(){
        double zmienna = -7954.873;
        do{
            Scanner sa=new Scanner(System.in);
            try {
                zmienna = sa.nextDouble();
            }
            catch (InputMismatchException e){
                System.out.println("Niepoprawnie podana wartosc, sprobuj ponownie (Oddziel czesc dziesietna za pomoca przecinka)");
                sa.nextLine();
            }
        }while (zmienna==-7954.873);
        return zmienna;
    }
    public long wypisz_long(){
        long zmienna =-594783;
        do{
            Scanner sa=new Scanner(System.in);
            try {
                zmienna = sa.nextLong();
            }
            catch (InputMismatchException e){
                System.out.println("Niepoprawnie podana wartosc, sprobuj ponownie");
                sa.nextLine();
            }
        }while (zmienna==-594783);
        return zmienna;
    }
    public String wypisz_String(){
        String zmienna = null;
        do{
            Scanner sa=new Scanner(System.in);
            try {
                zmienna = sa.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Niepoprawnie podana wartosc, sprobuj ponownie");
                sa.nextLine();
            }
        }while (zmienna==null);
        return zmienna;
    }
}
