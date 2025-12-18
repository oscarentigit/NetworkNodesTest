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
    }

    public String getNombre(){
        return nombre;
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
        // TODO: devolver algo tipo:
        // "WebServer (172.16.0.10) [VULN] [PWN]" etc.
        return "";
    }
}