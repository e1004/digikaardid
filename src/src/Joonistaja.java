public class Joonistaja{

    public void väljastaVisiitkaart(int ruuduKülg, String tähis) {
        System.out.println(tähis.repeat(ruuduKülg));

        for (int i = 2; i < ruuduKülg; i++) {
            System.out.println(tähis + " ".repeat((ruuduKülg * 2) - 3) + tähis);
        }

        System.out.println(tähis.repeat(ruuduKülg));
    }



}
