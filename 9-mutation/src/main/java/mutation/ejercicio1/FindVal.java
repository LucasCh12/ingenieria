package mutation.ejercicio1;

public class FindVal {

    /**
    * Find last index of element
    *
    * @param numbers array to search
    * @param val value to look for
    * @return last index of val in numbers; -1 if absent
    * @throws NullPointerException if numbers is null
    */
    public static int findVal(int numbers[], int val) {
        int findVal = -1;
        for (int i=0; i<numbers.length; i++) {
            if (numbers [i] == val)  findVal = i;
        }
        return (findVal);
    }

    public static int findValMutant(int numbers[], int val) {
        int findVal = -1;
        for (int i=(0+1); i<numbers.length; i++) {
            if (numbers [i] == val)  findVal = i;
        }
        return (findVal);
    }
}

    /*+
        A. Si es posible, dar entradas para el método que alcanzan el mutante.
        B. Si es posible, dar entradas que alcanzan al mutante pero no producen infección.

        C. Si es posible, dar entradas que producen infección pero no propagación.
        D. Si es posible, dar un test que mate al mutante.

        A. Las entradas que alcanzan al mutante serian todas las listas distintas de la lista vacia,
            ej: [5,2]. Son estas entradas porque si das lista vacia  numbers = [], numbers.length va a ser
            menor que i = 1, 1 < 0 ?, false no entro al for, osea no entro al mutante.

            Ej: val = 1, [1,2,3].
        
        B. Una entrada que alcanza al mutante pero no produzca infeccion seria que el elem
            buscado en la lista aparezca despues de la primera posicion, se alcanzaria al mutante
            (se ejecutaria el for), pero no haria infeccion porque si encontraria al elem en la lista,
            haciendo que el resultado del metodo sea verdadero y correcto.

            Ej: val = 1, [0,1].

        C. Un ejemplo en este caso de una entrada que produzca infeccion y no propagacion es imposible,
            ya que no hay forma del codigo de fixear esa "infeccion" y tratarla y que siempre de el valor esperado,
            osea seria que hubiera una parte del codigo donde se salve el resultado incorrecto hecho por la 
            infeccion, en este caso seria que el elem este en la primera posicion.
            
            Ej: val = 1, numbers = [1,2].

        D. Un test que mate al mutante seria el caso en donde sabiendo que por ej el elem si se encuentra
            en la lista, que al ejecutar el codigo el mutante de como resultado distinto al esperado,
            osea que diga que no se encuentra, en este caso seria haciendo que el val buscado en la lista
            este en la primera posicion de la misma, en donde se esperaria true porque si esta el elem,
            pero devolveria false el resultado.

            Ej: val = 1, numbers = [1,0]. Expected = true, actual = false.
        
     */