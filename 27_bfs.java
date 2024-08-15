public class bfs {
    static class graphh{
        public int adjmatr[][];
        public int vert;

        public graphh(int v){
            vert=v;
            adjmatr=new int[vert][vert];
        }

        public void insertedge(int src,int dest){
            adjmatr[src][dest]=1;
            adjmatr[dest][src]=1;
        }

        public void bfs(int startv){
            boolean[] visited=new boolean[vert];
            int[] q=new int[vert];
            int front=0;
            int rear=-1;

            visited[startv]=true;
            q[++rear]=startv;

            while(front<=rear){
                int vertex=q[front++];
                System.out.println(vertex+" ");
                for(int i=0;i<vert;i++){
                    if(adjmatr[vertex][i]==1&&!visited[i]){
                        visited[i]=true;
                        q[++rear]=i;
                    }
                }
            }
        }
    }

    public static void main(String args[]){
        graphh g = new graphh(6);
        g.insertedge(0,1);
        g.insertedge(0,3);  
        g.insertedge(0,4);
        g.insertedge(4,5);
        g.insertedge(3,5);
        g.insertedge(1,2);
        System.out.println("BFS traversal starting from vertex 0:");
        g.bfs(0);
    }
    }

