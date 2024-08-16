public class dfs {
    static class graphh {
        public int adjmatr[][];
        public int vert;

        public graphh(int v) {
            vert = v;
            adjmatr = new int[vert][vert];
        }

        public void insertedge(int src, int dest) {
            adjmatr[src][dest] = 1;
            adjmatr[dest][src] = 1;
        }

        public void dfs(int startv) { 
            boolean[] visited = new boolean[vert];
            dfs(startv, visited);
        }

        private void dfs(int currentVertex, boolean[] visited) {
            visited[currentVertex] = true;
            System.out.println(currentVertex);

            for (int i = 0; i < vert; i++) {
                if (adjmatr[currentVertex][i] == 1 && !visited[i]) {
                    dfs(i, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        graphh g = new graphh(6);
        g.insertedge(0, 1);
        g.insertedge(0, 2);
        g.insertedge(1, 3);
        g.insertedge(1, 4);
        g.insertedge(2, 4);
        g.insertedge(3, 5);
        g.insertedge(4, 5);

        System.out.println("DFS traversal starting from vertex 0:");
        g.dfs(0);
    }
}
