package recursion;

public class PlaceTiles {

    public static int fetchWaysToPlaceTiles(int n, int m) {

        if (n == 0) return 1;

        if (n < m) return 1;

        if (n == m) return 2;

        int horizontal = fetchWaysToPlaceTiles(n - 1, m);
        int vertical = fetchWaysToPlaceTiles(n - m, m);

        return horizontal + vertical;
    }
}