public class TarjetaRFID {

    private String codigo;
    private int nivelAcceso;

    public TarjetaRFID(String codigo, int nivelAcceso) {
        this.codigo = codigo;
        this.nivelAcceso = nivelAcceso;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }
}