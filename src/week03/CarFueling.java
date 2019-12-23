package week03;

import java.util.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int maxPossibleDistanceInOneFill = 0;
        int actualDistancePossible = 0;
        int stopIndex = 0;
        int stopCnt = 0,i;
        Set<Integer>indexExplored = new HashSet<>();

        while (stopIndex < stops.length || actualDistancePossible < dist)
        {
            maxPossibleDistanceInOneFill = actualDistancePossible + tank;

            actualDistancePossible = maxPossibleDistanceInOneFill;
            if(actualDistancePossible >= dist)
            {
                return stopCnt;
            }

                for(i = stopIndex ; i <stops.length ; i++)
                {
                    if( i>0 && stops[i] > actualDistancePossible)
                    {
                        stopIndex = i - 1;
                        if(indexExplored.contains(stopIndex))
                        {
                            return -1;
                        }
                        if(actualDistancePossible < stops[stopIndex])
                        {
                            return -1;
                        }
                        actualDistancePossible = stops[stopIndex];
                        indexExplored.add(stopIndex);
                        stopCnt++;
                        break;
                    }
                }
                if(i==stops.length)
                {
                    actualDistancePossible = stops[i-1];
                    stopCnt++;
                    stopIndex = i+1;
                    maxPossibleDistanceInOneFill = actualDistancePossible + tank;
                    actualDistancePossible = maxPossibleDistanceInOneFill;
                }
            if(dist<=maxPossibleDistanceInOneFill)
            {
                return stopCnt ;
            }
            if(stopIndex > stops.length && dist > maxPossibleDistanceInOneFill)
            {
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
