import java.util.*;
import java.io.*;

public class CarFueling {

    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numberOfStops = 0;

        int[] allStops = new int[stops.length + 2];
        allStops[0] = 0;
        allStops[stops.length + 1] = dist;

//        System.out.println("tank= "+ tank);
//        System.out.println("dist= "+ dist);

        // adding start and finish
        for(int i=1; i < allStops.length - 1; i++){
            allStops[i] = stops[i-1];
        }

        int current = 0;
        int previousStop = 0;
        int N = stops.length;
        while(current <= N){
            previousStop = current; // not sure about this one

//            System.out.println("allStops[i] = "+ allStops[current]);
//            System.out.println("current= "+ current);
//            System.out.println("previousStop= "+ previousStop);

            while((current <= N) && (allStops[current+1] - allStops[previousStop] <= tank)){
                current++;
            }

            if(current == previousStop){ // we haven't moved anywhere reachable within tank
                return -1;
            }

            if(current <= N){
                numberOfStops++;
            }

        }

        return numberOfStops;
    }

//    static int computeMinRefills(int dist, int tank, int[] stops) {
//        int numberOfStops = 0;
//
//        int[] allStops = new int[stops.length + 2];
//        allStops[0] = 0;
//        allStops[stops.length + 1] = dist;
//
////        System.out.println("tank= "+ tank);
////        System.out.println("dist= "+ dist);
//
//        // adding start and finish
//        for(int i=1; i < allStops.length - 1; i++){
//            allStops[i] = stops[i-1];
//        }
//
//        int current = tank;
//        int previousStop = 0;
//        for(int i=0; i < allStops.length; i++){
//
////            System.out.println("allStops[i] = "+ allStops[i]);
////            System.out.println("current= "+ current);
////            System.out.println("previousStop= "+ previousStop);
//
//            if(allStops[i] <= current){
//                previousStop = allStops[i];
//            }
//            else{
////                System.out.println("else (allStops[i] - previousStop)= "+ (allStops[i] - previousStop));
//
//                if( (allStops[i] - previousStop) <= tank){
//                    numberOfStops++;  // refuelling
//                    current += tank;
//                    previousStop = allStops[i];// TODO ???
//                }
//                else{
//                    return -1; // we ran out of fuel
//                }
//            }
//        }
//
//        return numberOfStops;
//    }

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
