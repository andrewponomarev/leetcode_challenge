package daily._2020._06._14;

import java.util.ArrayList;
import java.util.List;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        return 0;
    }

    public class DirectedEdge {
        // from
        private final int u;
        // to
        private final int v;
        // weight
        private final int w;

        public DirectedEdge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int from() {
            return u;
        }

        public int to() {
            return v;
        }

        public int weigth() {
            return w;
        }

        @Override
        public String toString() {
            return String.format("%d->%d %d", u, v, w);
        }
    }

    public class EdgeWeightedDigraph {
        // n of vertex
        private final int N;
        // n of edges
        private int M;
        private List<DirectedEdge>[] adj;

        public EdgeWeightedDigraph(int N) {
            this.N = N;
            this.M = 0;
            this.adj = (List<DirectedEdge> []) new List[N];
            for (int n = 0; n < N; n++) {
                adj[n] = new ArrayList<>();
            }
        }

        public int N() {
            return N;
        }

        public int M() {
            return M;
        }

        public void addEdge(DirectedEdge e) {
            adj[e.from()].add(e);
            M++;
        }

        public Iterable<DirectedEdge> adj(int n) {
            return adj[n];
        }

        public Iterable<DirectedEdge> edges() {
            List<DirectedEdge> list = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                for (DirectedEdge e : adj[n]) {
                    list.add(e);
                }
            }
            return list;
        }
    }


}
