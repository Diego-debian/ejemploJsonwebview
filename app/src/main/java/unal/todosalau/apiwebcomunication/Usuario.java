package unal.todosalau.apiwebcomunication;

import java.util.List;

public class Usuario {
    private String nombre;
    private int edad;
    private Direccion direccion;
    private List<String> telefonos;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public static class Direccion {
        private String calle;
        private int numero;
        private String ciudad;

        public String getCalle() {
            return calle;
        }

        public int getNumero() {
            return numero;
        }

        public String getCiudad() {
            return ciudad;
        }

        @Override
        public String toString() {
            return calle + " " + numero + ", " + ciudad;
        }
    }

}
