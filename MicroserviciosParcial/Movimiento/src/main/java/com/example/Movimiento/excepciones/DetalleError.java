package com.example.Movimiento.excepciones;


public class DetalleError {
        private int EstadoCodigo;
        private String mensaje;
        private String datalle;

        
        public DetalleError() {
        }

        public DetalleError(int estadoCodigo, String mensaje, String datalle) {
            EstadoCodigo = estadoCodigo;
            this.mensaje = mensaje;
            this.datalle = datalle;
        }

        public int getEstadoCodigo() {
            return EstadoCodigo;
        }

        public void setEstadoCodigo(int estadoCodigo) {
            EstadoCodigo = estadoCodigo;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getDatalle() {
            return datalle;
        }

        public void setDatalle(String datalle) {
            this.datalle = datalle;
        }

        

}
