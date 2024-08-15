import java.io.*;

class Node
{public int data;
 public Node lchild;
 public Node rchild;
 boolean rthread;
 public Node(int d)
 {data = d;
  lchild = null;
  rchild = null;
  rthread = true; //initially all are true
 }
 public void displayNode()
 {System.out.print(data + " ");
 }
}

class Tree
{public Node root;
 public Tree()
 {root = null;
 }    
 
 public void insert(int j) 
 {Node newnode = new Node(j);
  if (root == null) 
  {root = newnode;
   return;
  }
  Node current = root;
  Node parent = null;
  while (true) 
  {parent = current;
   if (j < current.data) 
   {current = current.lchild;
    if (current == null) 
    {parent.lchild = newnode;
     newnode.rchild = parent;
     newnode.rthread = true;
     return;
    }
   } 
   else 
   {if (!parent.rthread) 
    {current = current.rchild;
     if (current == null) 
     {parent.rchild = newnode;
      parent.rthread = false;
      newnode.rchild = null;
      newnode.rthread = true;
      return;
     }
    } 
    else 
    {newnode.rchild = parent.rchild;
     parent.rchild = newnode;
     parent.rthread = false;
     newnode.rthread = true;
     return;
    }
   }
  }
 }
 public void inorder()
 {Node q, p = root;//q is previous pointer 
  do
  {q = null;
   while(p!=null)
   {q = p;
    p = p.lchild;
   }
   if(q!=null)
   {q.displayNode();
    p = q.rchild;
    while(q.rthread && p!=null)
    {p.displayNode();
     q = p;
     p = p.rchild;
    }
   }
  }while(q!=null);
 }
}

public class threaded
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  Tree t = new Tree();
  int m = 0;
  System.out.println("Enter the nodes(Press a character to exit) : ");
  while(true)
  {try
   {m = Integer.parseInt(buf.readLine());
    t.insert(m);
   }
   catch (NumberFormatException e) 
   {break;
   }
  }

  System.out.println("The inorder traversal is : ");
  t.inorder();
  
 }
}