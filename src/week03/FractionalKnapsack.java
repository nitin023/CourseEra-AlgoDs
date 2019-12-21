package week03;

import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        Map<Double, List<Integer>> funcWeightPerValueAndWeightMap = new TreeMap<>(Collections.reverseOrder());

        int i;
        double unitWeightPerVal = 0;
        List<Integer>weightList ;
        for(i = 0 ; i< values.length ; i++)
        {
            unitWeightPerVal = (double) values[i]/weights[i];
            if(!funcWeightPerValueAndWeightMap.containsKey(unitWeightPerVal))
            {
                weightList = new ArrayList<>();
                weightList.add(weights[i]);
            }
            else
            {
                weightList = funcWeightPerValueAndWeightMap.get(unitWeightPerVal);
                weightList.add(weights[i]);
            }
            funcWeightPerValueAndWeightMap.put(unitWeightPerVal,weightList);
        }

        for(Map.Entry<Double, List<Integer>> funcPair : funcWeightPerValueAndWeightMap.entrySet())
        {
            unitWeightPerVal = funcPair.getKey();
            if(funcPair.getValue().size()==1)
            {
                if(capacity>=funcPair.getValue().get(0))
                {
                    capacity-= funcPair.getValue().get(0);
                    value+=unitWeightPerVal*(funcPair.getValue().get(0));
                }
                else
                {
                    value+=unitWeightPerVal*(capacity);
                    capacity = 0;
                }
            }
            else
            {
                weightList = funcPair.getValue();
                for(Integer weight : weightList)
                {
                    if(capacity >= weight)
                    {
                      capacity-=weight;
                      value+=unitWeightPerVal*weight;
                    }
                    else
                    {
                        value+=unitWeightPerVal * capacity;
                        capacity = 0;
                    }
                }
            }
            if(capacity==0)
            {
                break;
            }
        }
        value =  Math.round(value * 10000D) / 10000D;
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
