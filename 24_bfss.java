import java.io.IOException;

class node{
    public int d;
    public node next;
    public node prev;

    public node(int d){
        this.d=d;
        next=prev=null;
    }
}

class linklist{
    public node first;
    public node last;

    public linklist(){
        first=null;
        last=null;
    }

    public boolean isempty(){
        return(first==null&&last==null);
    }

    public void insertlast(int d){
        node nl=new node(d);
        if(first==null&&last==null){
            first=nl;
            last=nl;
            return;
        }
        last.next=nl;
        nl.prev=last;
        last=nl;
    }

    public int deletefirst(){
        if(first==null){
            return -1;
        }
        else if(first==last&&first!=null){
            node temp=first;
            first=null;
            last=null;
            return (temp.d);
        }
        node temp=first;
        first=first.next;
        return (temp.d);
    }

    public int size(){
        int i=0;
        node cur=first;
        while(cur!=null){
         i++;
         cur=cur.next;   
        }
        return i;
    }

    public int getx(int x){
        node cur=first;
        for(int i=1;i<=x;i++){
            cur=cur.next;
        }
        return(cur.d);
    }
}

class graphop{
    public linklist[] a;
    public int v;
    public linklist q;
     
    public graphop(int vert){
        v=vert;
        a=new linklist[v];
        for(int i=0;i<v;i++){
            a[i]=new linklist();
        }
        q=new linklist();
    }

    public void insertedge(int s,int d){
        a[s].insertlast(d);
        a[d].insertlast(s);
    }

    public void bfs(int startv){
        boolean[] visited=new boolean[v];
        
        visited[startv]=true;
        q.insertlast(startv);
        int w;
        int x;
        while(!q.isempty()){
            w=q.deletefirst();
            System.out.print(w+" ");
            for(int i=0;i<a[w].size();i++){
                x=a[w].getx(i);
                if(!visited[x]){
                    visited[x]=true;
                    q.insertlast(x);
                }
            }
        }
    }
}





public class bfss 
    {public static void main(String[] args)throws IOException
 {graphop g = new graphop(6);
  g.insertedge(0,1);
  g.insertedge(0,3);  
  g.insertedge(0,4);
  g.insertedge(4,5);
  g.insertedge(3,5);
  g.insertedge(1,2);
  System.out.println("The BFS traversal of the graph is : ");
  g.bfs(0);  
 }
}

