package testing.partition.practico.ejercicio2;

import java.util.List;

public class Ejercicio2 {
    
    @SuppressWarnings("rawtypes")
    public static int search(List list, Object element){
        if(list == null || element == null)  throw new NullPointerException("La lista o el elemento no pueden ser nulos");
        int i = 0;
        for(Object actualElement: list) {
           if(actualElement.equals(element)) {
            return i;
           }
           i++;
        }
        return -1;

    }
    
}
