package mutation.ejercicio2;

public class SumVal {
    /**
    * Sum values in an array
    *
    * @param x array to sum
    * @return sum of values in x
    * @throws NullPointerException if x is null
    */
    public static int sum(int[] x) {
        int s = 0;
        for (int i=0; i < x.length; i++) {
            s = s + x[i];
            // s = s - x[i];
        }
        return s;
    }

    public static int sumMutant(int[] x) {
        int s = 0;
        for (int i=0; i < x.length; i++) {
            s = s - x[i];
        }
        return s;
    }

    /**
        A. Si es posible, dar entradas para el método que alcanzan el mutante.
        B. Si es posible, dar entradas que alcanzan al mutante pero no producen infección.
        C. Si es posible, dar entradas que producen infección pero no propagación.
        D. Si es posible, dar un test que mate al mutante.

        A. Una entrada que alcance al mutante seria cualquier lista de numeros que no sea la vacia, 
            ya que se encuentra dentro del for, y entras al for cuando el tamaño de la lista es menor 
            estricto que 0, osea tamañoLista > 0.
            
        Ej: [1,2,3,4].

        B. Una entrada que alcanze al mutante pero no produzca infeccion seria por ej una lista con todos 0,
            ya que sumar y restar 0 siempre da el mismo resultado, el mutante no infecta nada.

        Ej: [0,0,0,0]

        C. En este caso si hay infeccion hay si o si propagacion.

        D. Una entrada que mate al mutante seria cualquier lista que no sea como en el caso B., 
        ya que la suma y la resta siempre dan valores distintos en lista de num.

        Ej: [1,2,3,4], expected : 10, mutant: -8.

     */
}
