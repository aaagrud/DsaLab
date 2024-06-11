import java.util.*;

class SelectionSort{
    public static void main(String[] args) {
        int arr[] = new int[100];
        Scanner sc = new Scanner(System.in);
        int min, j;

        System.out.print("enter length: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.print("enter element: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("sorting...");

        for(int i = 0; i < n - 1; i++){
            min = i;
            for(j = i + 1; j < n ; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp; 
        }

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}