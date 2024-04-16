/**
 * Fecha: clase cuyos objetos representan fechas calendarias, para el 
 * calendario gregoriano. Esta clase implementa una variedad de 
 * funcionalidades sobre fechas, como comparaciones, cómputos de días,
 * etc.
 * 
 * @author N. Aguirre 
 * @version 0.1
 */
public class Fecha
{
    // dia de la fecha
    private int dia;
    
    // mes de la fecha
    private int mes;
    
    // año de la fecha
    private int anho;

    /**
     * Constructor por defecto, para la clase fecha.
     * Crea como fecha por defecto la fecha inicial del 
     * calendario gregoriano (15/10/1582)
     */
    public Fecha()
    {
        dia = 15;
        mes = 10;
        anho = 1582;
    }

    /**
     * Constructor de la clase Fecha, que recibe la fecha a 
     * crear como parámetro. La fecha no puede ser previa
     * al 15/10/1582. Debe tenerse en cuenta la creación de
     * fechas válidas, en relación a número de días en los
     * meses, años bisiestos, etc.
     */
    public Fecha(int nuevoDia, int nuevoMes, int nuevoAnho)
    {
        // Implementar este constructor
        assert nuevoDia > 0 && nuevoDia <= 31;
        assert nuevoMes > 0 && nuevoMes <=12;
        assert nuevoAnho >= 1582;
        
        dia = nuevoDia;
        mes = nuevoMes;
        anho = nuevoAnho;
    }
    
    /**
     * Retorna el dia de la fecha
     */
    public int obtenerDia() {
        // Implementar este método, reemplazando la línea siguiente
        return dia;
    }
    
    /**
     * Retorna el mes de la fecha
     */
    public int obtenerMes() {
        // Implementar este método, reemplazando la línea siguiente
        System.out.println("Este mes tiene " + cantDias(mes) + " dias");
        return mes;
    }
    
    /**
     * Retorna el año de la fecha
     */
    public int obtenerAnho() {
        // Implementar este método, reemplazando la línea siguiente
        if(esBisiesto(anho))
        {System.out.println(anho + " es bisiesto");}
        else{System.out.println(anho + " no es bisiesto");}
        return anho;
    }
    
    /**
     * Cambia el día de la fecha. El nuevo día debe ser válido
     * para el mes y año actuales.
     */
    public void cambiarDia(int nuevoDia) {
        //Implementar este método
        dia = nuevoDia;
    }
    
    /**
     * Cambia el mes de la fecha. El nuevo mes debe ser válido
     * para el día y año actuales.
     */
    public void cambiarMes(int nuevoMes) {
        //Implementar este método
        mes = nuevoMes;
    }
    
    /**
     * Cambia el año de la fecha. El nuevo año debe ser válido
     * para el día y mes aactuales.
     */
    public void cambiarAnho(int nuevoAnho) {
        //Implementar este método
        anho = nuevoAnho;
    }
    
    /**
     * Chequea si la fecha es igual a otra fecha dada
     */
    public boolean equals(Fecha otraFecha) {
        // Implementar este método, reemplazando la línea siguiente 
        if(dia != otraFecha.obtenerDia())
        {
            return false;
        }else
        {
            return mes == otraFecha.obtenerMes() && anho == otraFecha.obtenerAnho();
        }
    }
    
    /**
     * Chequea si la fecha es anterior a otra fecha dada
     */
    public boolean esAnterior(Fecha otraFecha) {
        // Implementar este método, reemplazando la línea siguiente
        if (anho < otraFecha.obtenerAnho()) {
        return true;
    } else if (anho == otraFecha.obtenerAnho()) {
        if (mes < otraFecha.obtenerMes()) {
            return true;
        } else if (mes == otraFecha.obtenerMes()) {
            return dia < otraFecha.obtenerDia();
        }
    }
    return false;
    }
    
    /**
     * Computa distancia en días entre dos fechas.
     * El parámetro otraFecha debe corresponder a una fecha igual o 
     * posterior a la fecha del objeto.
     */
    public int distancia(Fecha otraFecha) {
        // Implementar este método, reemplazando la línea siguiente
        int distDias = 0;
        Fecha fechaTemp = new Fecha(dia, mes, anho);

        while (!fechaTemp.equals(otraFecha)){
        if (fechaTemp.dia < cantDias(fechaTemp.mes)) {
            fechaTemp.dia++;
        }else{
            fechaTemp.dia = 1;
            if (fechaTemp.mes < 12) {
                fechaTemp.mes++;
            }else{
                fechaTemp.mes = 1;
                fechaTemp.anho++;
            }
        }
            distDias++;
        }
        return distDias;
    }
    
    /**
     * Computa la cantidad de días de un mes dado. El parámetro
     * debe corresponder a un mes válido.
     */
    private int cantDias(int unMes) 
    {
        // Implementar este método, reemplazando la línea siguiente
        assert unMes > 0 && unMes <= 12;
        if(unMes == 2)
        {
            if (esBisiesto(anho)){return 29;}else {return 28;}
        }
        if(unMes == 1 || unMes == 3 || unMes == 5 || unMes == 7 || 
        unMes == 8 || unMes == 10 || unMes == 12)
        {
            return 31;
        }else{return 30;}
    }
    
    /**
     * Decide si un año dado es bisiesto o no. Un año es bisiesto
     * si es múltiplo de 4, salvo los múltiplos de 100 que no son 
     * múltiplos de 400.
     * El parámetro debe corresponder a un año válido.
     */
    private boolean esBisiesto(int unAnho) 
    {
        // Implementar este método, reemplazando la línea siguiente
        return unAnho % 4 == 0 && (unAnho % 100 != 0 || unAnho % 400 == 0);
    }
    
    public String toString()
    {
        // implementar este mètodo
        if(dia < 10 && mes < 10)
        {
            return "0" + dia + "/0" + mes + "/" + anho;
        }else{return dia + "/" + mes + "/" + anho;}
    }
}