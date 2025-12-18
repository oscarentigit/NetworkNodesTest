 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.Queue;

public class Red {
    ArrayList<Nodo> nodos;

    Red() {
        nodos = new ArrayList<>();
    }

    void agregarNodo(Nodo n) {
        if (!nodos.contains(n))
            nodos.add(n);
    }

    void conectar(Nodo a, Nodo b) {
        a.conectar(b);
        b.conectar(a);
    }

    void mostrar() {
        System.out.println("=== GRAFO ===");
        for (Nodo n : nodos) {
            System.out.println(n.getNombre() + " -> " + listarVecinosDe(n));
        }
    }

    void resetCompromisos() {
        for (Nodo n : nodos) {
            n.comprometido = false;
        }
    }

    void escanearDesde(Nodo origen) {
        Queue<Nodo> cola = new LinkedList<>();
        resetCompromisos();
        cola.add(origen);
        origen.comprometido = true;

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            if (actual.vulnerable) {
                actual.comprometido = true;
            }
            if (actual.firewall) {
                continue;
            }
            for (Nodo vecino : actual.vecinos) {
                if (!vecino.comprometido) {
                    vecino.comprometido = true;
                    cola.add(vecino);
                }
            }
        }
    }

    Nodo buscarPorIP(String ip) {
        for (Nodo n : nodos) {
            if (n.getIp().equals(ip)) {
                return n;
            }
        }
        return null;
    }

    int contarVulnerablesAlcanzables(Nodo origen) {
        int contador = 0;
        resetCompromisos();
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(origen);
        origen.comprometido = true;

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            if (actual.vulnerable) {
                contador++;
            }
            if (actual.firewall) {
                continue;
            }
            for (Nodo vecino : actual.vecinos) {
                if (!vecino.comprometido) {
                    vecino.comprometido = true;
                    cola.add(vecino);
                }
            }
        }
        return contador;
    }

    String listarVecinosDe(Nodo n) {
        String tmp = "";
        for (Nodo v : n.vecinos) {
            tmp += "[" + v.getNombre() + "] -";
        }
        return tmp;

    }
}


