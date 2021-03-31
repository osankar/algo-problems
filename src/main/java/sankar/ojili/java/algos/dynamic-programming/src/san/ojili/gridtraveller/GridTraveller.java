package san.ojili.gridtraveller;

import java.util.HashMap;
import java.util.Map;
/**
 * NUmber of paths to travel left top cell to right bottom cell
 */
public class GridTraveller {
    public static void main(String[] args) {
        long numPaths = numberOfPaths(3,3, new HashMap<>());
        System.out.printf("Paths: %d \n", numPaths);

        numPaths = numberOfPathsTabular(3,3);
        System.out.printf("Paths: %d", numPaths);
    }

    static Long numberOfPaths(int rows, int columns, Map<String, Long> memo) {
        if(rows ==1 && columns == 1) {
            return 1L;
        }
        if(rows ==0 || columns == 0) {
            return 0L;
        }
        String rcKey = String.format("%s::%s", rows, columns);
        if (memo.get(rcKey) != null) {
            return memo.get(rcKey);
        }
        String crKey = String.format("%s::%s", columns, rows);
        long numberOfPaths =  numberOfPaths(rows-1, columns, memo) + numberOfPaths(rows, columns-1, memo);
        memo.put(rcKey, numberOfPaths);
        memo.put(crKey, numberOfPaths);
        return numberOfPaths;
    }

    static long numberOfPathsTabular(int rows, int columns) {
        if(rows == 0 || columns == 0) {
            return 0L;
        }

        long[][] table = new long[rows+1][columns+1];
        table[1][1] = 1;
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=columns; j++) {
                if(i+1 <= rows) {
                    table[i+1][j] = table[i+1][j]+table[i][j];
                }
                if(j+1 <= columns) {
                    table[i][j+1] = table[i][j+1]+table[i][j];
                }
            }
        }

        return table[rows][columns];
    }
}
