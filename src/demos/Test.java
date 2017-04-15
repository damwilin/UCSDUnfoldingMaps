package demos;

/**
 * Created by Damian on 4/12/2017.
 */
public class Test {
    public static void main(String[] args) {

        int[] tab1 = {0, 5, 2, 6, 1};
        int swap = 0;
        for (int i = 0; i < tab1.length - 1; i++) {
            int currentLowest = i;
            for (int k = i; k < tab1.length; k++) {
                if (tab1[k] < tab1[currentLowest])
                    currentLowest = k;
            }
            if (tab1[i] != tab1[currentLowest]) {
                swap = tab1[i];
                tab1[i] = tab1[currentLowest];
                tab1[currentLowest] = swap;
            }
        }
        for (int i = 0; i < tab1.length; i++) {
            System.out.println(tab1[i]);
        }
    }
}
