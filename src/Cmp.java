import java.util.Comparator;

class shu {
    int x;
}

public class Cmp implements Comparator<shu> {
    public int compare(shu a, shu b) {
        if (a.x < b.x) {
            return 1;
        } else if (a.x == b.x) {
            return 0;
        } else {
            return -1;
        }
    }
}
