package testing.partition.practico.ejercicio1;

import java.util.ArrayList;

public class Ejercicio1 {

    public static boolean listIsAscendent(ArrayList<Integer> list){
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static boolean listIsDescendent(ArrayList<Integer> list){
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) < list.get(i+1)){
                return false;
            }
        }
        return true;
    }

}
