package testing.partition.practico.ejercicio3;

import java.util.HashSet;
import java.util.Set;

public class IntersectionSet {

    public static Set intersection(Set s1, Set s2) {
        if (s1 == null || s2 == null) 
            throw new NullPointerException("Los conjuntos no pueden ser null");

        HashSet<Object> aux = new HashSet<>();

        for (Object o : s1) {
            if (s2.contains(o)) {
                aux.add(o);
            }
        }

        return aux;
    }

    public static String toStringSet(Set<?> set) {
        if (set == null) return "null";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;

        for (Object o : set) {
            if (!first) sb.append(",");
            sb.append(o);
            first = false;
        }

        sb.append("]");
        return sb.toString();
    }

}
