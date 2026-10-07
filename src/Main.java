//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    ControladorDeAcceso controlador = new ControladorDeAcceso();

    controlador.registrarZona("Oficinas Generales", 1);
    controlador.registrarZona("Sala de Servidores", 3);

    LectorTarjetas lectorServidores = new LectorTarjetas("Puerta Sala de Servidores", controlador);

    TarjetaRFID tarjetaValida = new TarjetaRFID("RFID-9001", 3);   // nivel gerencia
    TarjetaRFID tarjetaInvalida = new TarjetaRFID("RFID-4521", 1); // nivel empleado común

    System.out.println("--- Prueba 1: tarjeta válida ---");
    lectorServidores.leerTarjeta(tarjetaValida, "Sala de Servidores");

    System.out.println("\n--- Prueba 2: tarjeta inválida (nivel insuficiente) ---");
    lectorServidores.leerTarjeta(tarjetaInvalida, "Sala de Servidores");

}


