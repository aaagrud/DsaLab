public class dfs {
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

        public void dfs(int startv){ 
            boolean[] visited=new boolean[vert];
            int[] stack=new int[vert];
            int top=-1;

            
            stack[++top]=startv;

            int w;
            while(top>=0){
                w=stack[top--];
                if(!visited[w]){
                    visited[w]=true;
                    System.out.println(w);
                
                for(int i=vert-1;i>=0;i++){
                    if(adjmatr[w][i]==1&&!visited[i]){
                        stack[++top]=i;
                    }
                }
            }}

        }}
}
