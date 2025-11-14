public class ParticionEntradas {
    /**
    * Valida si una contraseña cumple con los requisitos de seguridad
    * @param password la contraseña a validar
    * @return true si la contraseña es válida, false en caso contrario
    * Requisitos: longitud >= 8, contiene al menos un número, 
    * contiene al menos una mayúscula, contiene al menos un carácter especial
    */
    public boolean validarPassword(String password){
        return false;
    }

    /** 
     * Tarea: Define las características y bloques para el espacio de entradas y aplica los criterios:

     * Each Choice Coverage (1)
     * Base Choice Coverage (usa una contraseña válida como base) (2)
     * Calcula cuántos tests necesitarías para All Combinations Coverage (3)
     * 
     * Para este ejericio particion de entradas podria hacerse sobre las caracteristicas que pide:
     * 
     * C1: longitud contraseña:
     *  Bloque 1: Longitud <8.
     *  Bloque 3: Longitud >=8.
     * 
     * C2: Numeros contenidos:
     *  Bloque 1: 0.
     *  Bloque 2: >=1.
     * 
     * C3: Mayusculas contenidas:
     *  Bloque 1: 0.
     *  Bloque 3: >=1.
     * 
     * C4: Caracteres especiales contenidos:
     *  Bloque 1: 0.
     *  Bloque 3: >=1.
     * 
     * 1) ECC: Se tienen que cubrir todos los bloques al menos una vez:
     *      Test1: Longitud Contraseña = 0, Numeros contenidos = 0, Mayusculas = 0, Caracteres especiales = 0.
     *          Ej: "".
     * 
     *      Test2: Longitud Contraseña = <8, Numeros contenidos = 1, Mayusculas = 1, Caracteres especiales = 1.
     *          Ej: Hola1*.
     *  
     * 2) Base choice coverage: Dado caso base, tengo que intercambiar por cada caracteristica fijando los otros del
     *      Caso base.
     * 
     *      Caso base: Longitud Contraseña = 9 (>=8), Numeros contenidos = 3, Mayusculas = 1, Caracteres especiales = 1;
     *          Ej: Lucas123*
     *  
     *      Test1: Longitud contraseña = 7 (<8), Numeros contenidos = 3, Mayusculas = 1, Caracteres especiales = 1;
     *          Ej: Luc123*
     *      
     *      Test2: Longitud contraseña = 0, Numeros contenidos = 3, Mayusculas = 1, Caracteres especiales = 1;
     *          Ej: Imposible porque no puede haber 3 numeros, una mayuscula, y un caracter especial si la long 
     *          de la contraseña es 0.
     *      
     *      Test3: Longitud Contraseña = 9 (>=8), Numeros contenidos = 1, Mayusculas = 1, Caracteres especiales = 1.
     *          Ej: Elcielo1*. 
     * 
     *      Test4: Longitud Contraseña = 9 (>=8), Numeros contenidos = 0, Mayusculas = 1, Caracteres especiales = 1;
     *          Ej: Elcielos*
     * 
     *      Test5: Longitud Contraseña = 9 (>=8), Numeros contenidos = 3, Mayusculas = >1, Caracteres especiales = 1;
     *          Ej: ELcie123*
     * 
     *      Test6: Longitud Contraseña = 9 (>=8), Numeros contenidos = 3, Mayusculas = 0, Caracteres especiales = 1;
     *          Ej: elcie123*
     *      
     *      Test7: Longitud Contraseña = 9 (>=8), Numeros contenidos = 3, Mayusculas = 1, Caracteres especiales = 0;
     *          Ej: Norol123a
     * 
     *      Test8: Longitud Contraseña = 9 (>=8), Numeros contenidos = 3, Mayusculas = 1, Caracteres especiales = >1;
     *          Ej: Elpe569*?
     *  
     * 3) Se necesitarian 2*2*2*2 casos de prueba para cubrir el AcoC.
     *      
     */

    /**
     * Determina si una fecha es válida
     * @param dia el día del mes
     * @param mes el mes del año (1-12)
     * @param año el año
     * @return true si la fecha es válida
     */
    public boolean esFechaValida(int dia, int mes, int año){ return false;}

    /**
     *  Características propuestas:

        C1: Tipo de mes (Bloques: 31 días, 30 días, febrero)
        C2: Año bisiesto (Bloques: bisiesto, no bisiesto)
        C3: Día del mes (Bloques: <1, 1-28, 29, 30, 31, >31)
        Tarea:

        Identifica problemas en la partición
        Corrige las características para cumplir con completitud y no solapamiento
        Aplica Pair-Wise Coverage
     */

    /**
     * Problemas de solapamiento:
     *  1) El mes que tiene 31 dias tambien tiene 30 dias, se chocaria ahi.
     *  2) >31 en dias del mes tmb entrarian absolutamente todos los anteriores.
     *  3) <1 en dias del mes incluye a todos los demas posteriores.
     *  4) Los dias del mes se podrian agrupar por meses con 31, meses con 30, y febrero y los invalidos.
     * 
     * Problemas completitud:
     *  1) Faltarian campos incorrectos en cada uno de ellos o el caso de que los campos sean null o vacio, o campo negativo en
     *      dias del mes.
     *  2) El campo de años se podria cambiar a 1< y >=1 como en el calendario comun.
     *  3) Faltarian los tipo de mes de 28 dias, y 29 en caso de bisiesto.
     */


     /**
     * Procesa un pago con tarjeta de crédito
     * @param numeroTarjeta número de la tarjeta
     * @param monto monto del pago
     * @param fechaExpiracion fecha de expiración
     * @param codigoSeguridad código de seguridad
     * @return true si el pago fue exitoso
     * @throws PaymentException si hay errores en el pago
     */
    public boolean procesarPago(String numeroTarjeta, double monto, String fechaExpiracion, String codigoSeguridad){ return true;}

    /*+
     * Tarea:
        Identifica características para validación de tarjeta
        Considera estados como: tarjeta válida, expirada, fondos insuficientes, etc.
        Aplica Multiple Base Choice Coverage
     */
    
    /**
     * 1)_ Particion entradas:
     *      C1: numeroDeTarjeta:
     *          Bloque1: Invalido (no corresponde a una tarjeta real)
     *          Bloque3: Valido
     *          Bloque4: Vacio/Null
     * 
     *      C2: monto:
     *          Bloque1: Invalido (negativo)
     *          BLoque2: 0
     *          BLoque3: 1>=.
     *          Bloque4: Vacio/Null
     *     
     *      C3: fechaExpiracion:
     *          Bloque1: Ya expirada (valida)
     *          Bloque2: No expirada (valida)
     *          Bloque3: Vacio/Null
     *          Bloque4: Invalida (fecha incorrecta)
     * 
     *      C4: codigoSeguridad:
     *          Bloque1: Vacio/null
     *          Bloque2: Valido (corresponde al numero de tarjeta)
     *          Bloque3: invalido (no corresponde al numero de tarjeta)
     * 
     *      C5: Condicion de tarjeta:
     *          Bloque1: Tarjeta bloqueada
     *          Bloque2: Tarjeta no bloqueada
     *         
     */
}   


