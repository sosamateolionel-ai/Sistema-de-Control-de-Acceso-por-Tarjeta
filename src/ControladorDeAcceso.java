import java.util.HashMap;
import java.util.Map;

public class ControladorDeAcceso {

    private Map<String, Integer> permisosPorZona; // zona -> nivel mínimo requerido

    public ControladorDeAcceso() {
        this.permisosPorZona = new HashMap<>();
    }

    public void registrarZona(String zona, int nivelMinimoRequerido) {
        permisosPorZona.put(zona, nivelMinimoRequerido);
        System.out.println("Zona registrada: " + zona + " (nivel mínimo: " + nivelMinimoRequerido + ")");
    }

    public boolean verificarAcceso(TarjetaRFID tarjeta, String zona) {

        if (!permisosPorZona.containsKey(zona)) {
            System.out.println("La zona \"" + zona + "\" no está registrada en el sistema.");
            return false;
        }

        int nivelRequerido = permisosPorZona.get(zona);

        if (tarjeta.getNivelAcceso() >= nivelRequerido) {
            System.out.println("Acceso autorizado: tarjeta " + tarjeta.getCodigo()
                    + " (nivel " + tarjeta.getNivelAcceso() + ") puede ingresar a " + zona + ".");
            return true;
        } else {
            System.out.println("Acceso denegado: tarjeta " + tarjeta.getCodigo()
                    + " (nivel " + tarjeta.getNivelAcceso() + ") no alcanza el nivel requerido ("
                    + nivelRequerido + ") para " + zona + ".");
            return false;
        }
    }
}