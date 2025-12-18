 import java.util.ArrayList;

 public class Red {
        ArrayList<Nodo> nodos;

        Red() {
             // TODO: Realizar constructor
             nodos = new ArrayList<>();
        }

        void agregarNodo(Nodo n) {
            // TODO: añade nodo a la red
            if(!nodos.contains(n))
                nodos.add(n);
        }

        void conectar(Nodo a, Nodo b) {
            // TODO: conecta a <-> b (bidireccional)
            a.conectar(a);
            b.conectar(b);
        }

        
        void mostrar() {
            // TODO: imprime topología (nodo -> vecinos)
            System.out.println("=== GRAFO ===");
            for (Nodo n : nodos){
                System.out.println(n.getNombre()+ " -> " + n.getVecinos());
            }
        }
        
        void resetCompromisos() {
            // TODO: poner comprometido=false a todos los nodos
        }

        void escanearDesde(Nodo origen) {
            // TODO: BFS desde origen - https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/
            // Reglas:
            // - si un nodo visitado es vulnerable => comprometido=true
            // - si un nodo visitado es firewall => NO se propaga a sus vecinos
        }

        Nodo buscarPorIP(String ip) {
            // Buscar por IP (iterar nodos)
            return null;
        }
  
        int contarVulnerablesAlcanzables(Nodo origen) {
            // Contar vulnerables alcanzables desde origen (BFS)
            return 0;
        }

        String listarVecinosDe(Nodo n) {
            // Listar vecinos (iterar vecinos)
            return "";
        }

        ArrayList<Nodo> nodosAislados() {
            // Obtener nodos aislados (vecinos.size()==0)
            return new ArrayList<>();
        }
    }
