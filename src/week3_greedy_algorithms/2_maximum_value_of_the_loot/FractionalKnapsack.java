import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class FractionalKnapsack {

//    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
//        double value = 0;
//
//        Map<Double, Integer> valueWeightMap = new HashMap<>();
//
//        double[] valuesPerWeight = new double[weights.length];
//        for (int i = 0; i < weights.length; i++) {
//            double valuePerWeight =  ((double)values[i] )/((double) weights[i]);
//            valueWeightMap.put(valuePerWeight, weights[i]); // TODO could be a problem here using double as key
//
////            System.out.println("weights[i] = " + weights[i]);
////            System.out.println("values[i] = " + values[i]);
////            System.out.println("valuePerWeight = " + valuePerWeight);
//
//            valuesPerWeight[i] = valuePerWeight;
//        }
//        Arrays.sort(valuesPerWeight);
////        Arrays.sort(valuesPerWeight, (o1, o2) -> o2 - o1);
//
//        double remainingCapacity = capacity;
//        int valuesPerWeightIndex = weights.length - 1;
//        while(remainingCapacity > 0 && valuesPerWeightIndex >= 0){
////            System.out.println("remainingCapacity = " + remainingCapacity);
//
//            double valuePerWeight = valuesPerWeight[valuesPerWeightIndex];
//            double weight = (double)valueWeightMap.get(valuePerWeight);
//            double amount = valuePerWeight * weight;
////
////            System.out.println("valuePerWeight = " + valuePerWeight);
////            System.out.println("amount = " + amount);
////            System.out.println("weight = " + weight);
//
//            valuesPerWeightIndex--;
//
//            if(remainingCapacity >= weight){
//                value += amount;
//                remainingCapacity -= weight;
//            }
//            else{
////                double fraction =  remainingCapacity / weight;
////                return valuePerWeight * fraction;
//                return valuePerWeight * remainingCapacity;
//            }
//        }
//
//
//        return value;
//    }


    static class Triple {
        double valuePerWeight;
        double weight;
        double value;

        Triple(double valuePerWeight,
               double weight, double value){
            this.valuePerWeight = valuePerWeight;
            this.weight = weight;
            this.value = value;
        }
    }

    private static double getOptimalValue(int capacity, double[] values, double[] weights) {
        double value = 0;

        List<Triple> valuesPerWeight = new ArrayList<>(weights.length);
        for (int i = 0; i < weights.length; i++) {
            double valuePerWeight =  values[i] /weights[i];

//            System.out.println("weights[i] = " + weights[i]);
//            System.out.println("values[i] = " + values[i]);
//            System.out.println("valuePerWeight = " + valuePerWeight);

            valuesPerWeight.add(new Triple(valuePerWeight, weights[i], values[i]));
        }
        Collections.sort(valuesPerWeight, (o1, o2) -> -Double.compare(o1.valuePerWeight, o2.valuePerWeight));
//        Arrays.sort(valuesPerWeight, (o1, o2) -> o2 - o1);

        double remainingCapacity = capacity;
        int valuesPerWeightIndex = 0;
        while(remainingCapacity > 0 && valuesPerWeightIndex < weights.length){
//            System.out.println("remainingCapacity = " + remainingCapacity);

            Triple tuple = valuesPerWeight.get(valuesPerWeightIndex);
            double valuePerWeight = tuple.valuePerWeight;
            double weight = tuple.weight;
            double amount = valuePerWeight * weight;
//
//            System.out.println("valuePerWeight = " + valuePerWeight);
//            System.out.println("amount = " + amount);
//            System.out.println("weight = " + weight);

            valuesPerWeightIndex++;

            if(remainingCapacity >= weight){
                value += amount;
                remainingCapacity -= weight;
            }
            else{
                double fraction =  remainingCapacity / weight;
                value += fraction * tuple.value;

                return value;
//                return valuePerWeight * remainingCapacity; // TODO looks like this was the issue with case 6
            }
        }


        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();

//        System.out.println("n = " + n);
//        System.out.println("capacity = " + capacity);

        double[] values = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
