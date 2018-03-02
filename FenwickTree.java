import java.io.*;
public class FenwickTree{
    static int n;
    static int[] fen;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Size of the arrray
        n = Integer.parseInt(br.readLine());
        //All elements in array
        String[] s = br.readLine().split(" ");
        int[] a = new int[n];
        fen = new int[n+1];
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(s[i]);
        }
        for(int i=1;i<=n;i++){
            update(i, a[i-1]);
        }

        System.out.println(getSum(Integer.parseInt(br.readLine())));
    }
    private static int getParent(int i){
        return (i - ((~i+1) & i));
    }
    private static int getNext(int i){
        return (i + ((~i+1) & i));
    }
    private static void update(int pos, int value){
        while(pos <= n){
            fen[pos] += value;
            pos = getNext(pos);
        }
    }
    private static int getSum(int parent){
        int total = 0;
        while(parent != 0){
            total += fen[parent];
            parent = getParent(parent);
        }
        return total;
    }
}
