public class LectorTarjetas {

    private String ubicacion; // dónde está instalado el lector
    private ControladorDeAcceso controlador; // asociación con el controlador

    public LectorTarjetas(String ubicacion, ControladorDeAcceso controlador) {
        this.ubicacion = ubicacion;
        this.controlador = controlador;
    }

    public void leerTarjeta(TarjetaRFID tarjeta, String zona) {

        System.out.println("\n[" + ubicacion + "] Tarjeta " + tarjeta.getCodigo() + " detectada, solicitando acceso a " + zona + "...");

        boolean autorizado = controlador.verificarAcceso(tarjeta, zona);

        if (autorizado) {
            System.out.println("[" + ubicacion + "] Puerta abierta.");
        } else {
            System.out.println("[" + ubicacion + "] Acceso rechazado, puerta permanece cerrada.");
        }
    }
}