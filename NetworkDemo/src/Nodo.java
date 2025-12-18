import java.util.ArrayList;

public class Nodo {
    String nombre;
    String ip;
    boolean firewall;
    boolean vulnerable;
    boolean comprometido;
    ArrayList<Nodo> vecinos;

    Nodo(String nombre, String ip, boolean firewall, boolean vulnerable) {
        // TODO: Realizar constructor
        this.nombre = nombre;
        this.ip = ip;
        this.firewall = firewall;
        this.vulnerable = vulnerable;
        this.comprometido = false;
        this.vecinos = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public String getIp(){
        return ip;
    }

    public String getVecinos(){
        String tmp = "";
        for(Nodo v : vecinos){
            tmp += "["+ v.getNombre() +"] -";
        }
        return tmp;
    }

    void conectar(Nodo otro) {
        // TODO: conecta este nodo con "otro" (sin duplicados)
        if(!vecinos.contains(otro))
            vecinos.add(otro);
    }

    @Override
    public String toString() {
        String estado = "";
        if (vulnerable) estado += "[VULN]";
        if (comprometido) estado += "[PWN]";
        return nombre + " (" + ip + ") " + estado;
    }
}