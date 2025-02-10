package model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {


        protected String username;
        protected String email;
        protected String nombre;
        protected String telefono;
        protected int documentoIdentidad;

        public Persona() {

        }

        public Persona( String username, String email, String nombre, String telefono, int documentoIdentidad) {
            this.username = username;
            this.email = email;
            this.nombre = nombre;
            this.telefono = telefono;
            this.documentoIdentidad = documentoIdentidad;
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public int getDocumentoIdentidad() {
            return documentoIdentidad;
        }

        public void setDocumentoIdentidad(int documentoIdentidad) {
            this.documentoIdentidad = documentoIdentidad;
        }

    @Override
    public String toString() {
        return "Persona{" +
                "documentoIdentidad=" + documentoIdentidad +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
