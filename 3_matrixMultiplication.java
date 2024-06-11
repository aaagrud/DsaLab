import java.util.*;

class MatrixMultiplication{
    public static void main(String[] args) {
        int a[][] = new int[100][100];
        int b[][] = new int[100][100];

        Scanner sc = new Scanner(System.in);
        int r1, r2, c1, c2;

        System.out.print("enter r1, c1: ");
        r1 = sc.nextInt();
        c1 = sc.nextInt();

        System.out.print("enter r2, c2: ");
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        System.out.println("enter a's elements: ");
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("enter b's elements: ");
        for(int i = 0; i < r2; i++){
            for(int j = 0; j < c2; j++){
                b[i][j] = sc.nextInt();
            }
        }

        System.out.println("matrix a: ");

        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < r2; i++){
            for(int j = 0; j < c2; j++){
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("multiplying...");

        if(c1 != r2){
            System.out.println("cannot multiply...");
        } 
        else {
            int multiply[][] = new int[100][100];
            
            for(int i = 0; i < r1; i++){
                for(int j = 0; j < c2; j++){
                    multiply[i][j] = 0;
                    for(int k = 0; k < r2; k++){
                        multiply[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            System.out.println("new matrix:\n");
            for(int i = 0; i < r2; i++){
                for(int j = 0; j < c2; j++){
                    System.out.print(multiply[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}