/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;
/**
 * Constructor de la clase Animal.
 * 
 * Creamos un nuevo objeto Animal con un código identificativo, fecha de nacimiento,
 * sexo y peso.
 * 
 * Validaciones sobre los parámetros:
 * - El código debe tener exactamente 5 caracteres que sean dígitos (0-9) o letras minúsculas (a-z)
 * - El sexo debe ser 'M' (hembra) o 'H' (macho)
 * - El peso debe ser un valor positivo mayor que cero
 * - La fecha de nacimiento debe estar en formato ISO-8601 (yyyy-MM-dd) válido
 * 
 * Si algún parámetro no cumple estas condiciones, se lanza una excepción IllegalArgumentException
 * 
 * @param codigo el código identificativo del animal, compuesto por 5 caracteres alfanuméricos en minúscula
 * @param fechaNacimiento la fecha de nacimiento del animal en formato "yyyy-MM-dd"
 * @param sexo el sexo del animal, 'M' para hembra o 'H' para macho
 * @param peso el peso del animal en kilogramos, debe ser mayor que 0
 * @throws IllegalArgumentException si el código no cumple el patrón, el sexo es incorrecto,
 *         el peso no es positivo o la fecha no tiene un formato válido
 */
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }
    
/**
 * Obtienemos el código identificativo del animal.
 * 
 * @return el código del animal (5 caracteres alfanuméricos en minúscula)
 */
    public String getCodigo() {
        return codigo;
    }
    
/**
 * Establecemos el código identificativo del animal.
 * <p>
 * Valida que el código tenga exactamente 5 caracteres que sean dígitos (0-9)
 * o letras minúsculas (a-z).
 * 
 * @param codigo el nuevo código del animal
 * @throws IllegalArgumentException si el código no cumple el patrón de 5 caracteres alfanuméricos en minúscula
 */
    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    /**
 * Obtienemos la fecha de nacimiento del animal.
 * 
 * @return la fecha de nacimiento como objeto LocalDate
 */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
 * Establecemos la fecha de nacimiento del animal.
 * <p>
 * Valida que la fecha esté en formato ISO-8601 (yyyy-MM-dd) y sea una fecha válida.
 * 
 * @param fechaNacimiento la nueva fecha de nacimiento en formato "yyyy-MM-dd"
 * @throws IllegalArgumentException si la fecha no tiene un formato válido
 */
    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }

    /**
 * Obtienemos el sexo del animal.
 * 
 * @return 'M' para hembra, 'H' para macho
 */
    public char getSexo() {
        return sexo;
    }

    /**
 * Establecemos el sexo del animal.
 * <p>
 * Valida que el sexo sea 'M' (hembra) o 'H' (macho).
 * 
 * @param sexo el nuevo sexo del animal
 * @throws IllegalArgumentException si el sexo no es 'M' ni 'H'
 */
    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    /**
 * Obtienemos el peso del animal en kilogramos.
 * 
 * @return el peso del animal (mayor que 0)
 */
    public double getPeso() {
        return peso;
    }

    /**
 * Establecemos el peso del animal en kilogramos.
 * <p>
 * Valida que el peso sea un valor positivo mayor que cero.
 * 
 * @param peso el nuevo peso del animal
 * @throws IllegalArgumentException si el peso no es positivo
 */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    /**
 * Calculamos el código hash del animal basado en sus atributos.
 * <p>
 * Implementación generada por NetBeans que utiliza todos los campos:
 * código, fecha de nacimiento, sexo y peso.
 * 
 * @return el código hash del objeto Animal
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    /**
 * Comparamos este animal con otro objeto para determinar si son iguales.
 * <p>
 * Dos animales se consideran iguales si tienen el mismo código,
 * fecha de nacimiento, sexo y peso.
 * 
 * @param obj el objeto a comparar
 * @return true si los objetos son iguales, false en caso contrario
 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    /**
 * Devuelve información completa del animal.
 * <p>
 * Incluye todos los atributos: código, fecha de nacimiento, sexo y peso.
 * 
 * @return una cadena con la información completa del animal
 */
    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }

    /**
 * Hace que el animal emita su sonido característico del mismo.
 * <p>
 * Método abstracto que debe ser implementado por cada subclase
 * (Perro, Gato, etc.) para producir el sonido específico de esa especie.
 * 
 * @return una cadena con el sonido que hace el animal
 */
    public abstract String hacerSonido();

    /**
 * Hace que el animal se alegre.
 * <p>
 * Método abstracto que debe ser implementado por cada subclase
 * para definir cómo expresa la alegría cada especie.
 * 
 * @return una cadena con la expresión de alegría del animal
 */
    public abstract String alegrarse();

    /**
 * Hace que el animal se enfade y muestre una reacción de ataque.
 * <p>
 * Método abstracto que debe ser implementado por cada subclase
 * para definir cómo reacciona cada especie cuando se enfada.
 * 
 * @return una cadena con la reacción de enfado del animal
 */
    public abstract String enfadarse();

    /**
 * Indicamos qué tipo de animal es.
 * <p>
 * Método abstracto que debe ser implementado por cada subclase
 * para devolver el nombre de la especie (ej: "Perro", "Gato").
 * 
 * @return una cadena con el nombre de la especie del animal
 */
    public abstract String queSoy();

}
