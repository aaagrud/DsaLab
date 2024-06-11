import java.util.*;

class BubbleSort{
    public static void main(String[] args) {
        int arr[] = new int[100];
        Scanner sc = new Scanner(System.in);

        System.out.println("enter element: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("enter element: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("sorting...");

        for(int i = 0; i < n - 1; i++){
            int swapped = 0;
            for(int j = 0; j < n - i -1; j++){
                if (arr[j] > arr[j + 1]){
                    swapped = 1;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(swapped == 0){
                break;
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}