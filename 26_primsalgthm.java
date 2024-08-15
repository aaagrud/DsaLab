class node{
    public int dest;
    public int wt;
    public node next;

    public node(int d,int w){
        dest=d;
        wt=w;
        next=null;
    }
}

class linkedlist{
    public node head;
    public linkedlist(){
        head=null;
    }

    public void add(int d,int w){
        node nl=new node(d,w);
        if(head==null){
            head=nl;
        }else{
            node cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=nl;
        }
    }

    public void print(){
        node cur=head;
        while(cur!=null){
            System.out.print("("+cur.dest+","+cur.wt+")"+"-->");
            cur=cur.next;
        }
        System.out.println("END");
    }

    public node gethead(){
        return head;
    }
}

class graph{
    public int v;
    public linkedlist[] lists;

    public graph(int vert){
        v=vert;
        lists=new linkedlist[v];
        for(int i=0;i<v;i++){
            lists[i]=new linkedlist();
        }
    }

    public void addedge(int s,int d,int w){
        lists[s].add(d,w);
    }

    public void prisms(){
        boolean[] mst=new boolean[v];
        int[] key=new int[v];
        int[] parent=new int[v];

        for(int i=0;i<v;i++){
            key[i]=Integer.MAX_VALUE;
            parent[i]=-1;
            mst[i]=false;
        }

        key[0]=0;
        parent[0]=-1;

        for(int j=0;j<v-1;j++){
            int minkey=Integer.MAX_VALUE;
            int u=-1;
            for(int i=0;i<v;i++){
                if(!mst[i]&&key[i]<minkey){
                    minkey=key[i];
                    u=i;
                }
            }
            mst[u]=true;

            node cur=lists[u].gethead();
            while(cur!=null){
                int v=cur.dest;
                int wt=cur.wt;
                if(!mst[v]&&wt<key[v]){
                    key[v]=wt;
                    parent[v]=u;
                }
                cur=cur.next;
            }
        }
        printmst(parent);
    }

    public void printmst(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < v; i++) {
            int parentIndex = parent[i];
            if (parentIndex >= 0 && parentIndex < v) {
                node cur = lists[parentIndex].gethead();
                while (cur != null) {
                    if (cur.dest == i) {
                        System.out.println(parentIndex + "-" + i + "\t" + cur.wt);
                        break;
                    }
                    cur = cur.next;
                }
            } else {
                continue;
            }
        }
    }
    
    
}



public class primsalgthm {
    public static void main(String[] args) {
        graph g = new graph(6);
        g.addedge(0, 1, 1);
        g.addedge(0, 4, 4);
        
        g.addedge(1, 2, 7);
        g.addedge(1, 4, 3);
        g.addedge(1, 0, 1);
        
        g.addedge(2, 1, 7);
        g.addedge(2, 4, 5);
        g.addedge(2, 3, 9);
        g.addedge(3, 4, 2);
        g.addedge(3, 2, 9);
        g.addedge(4, 0, 4);
        g.addedge(4, 1, 3);
        g.addedge(4, 2, 5);
        g.addedge(4, 3, 2);
       
        g.prisms();
}}
