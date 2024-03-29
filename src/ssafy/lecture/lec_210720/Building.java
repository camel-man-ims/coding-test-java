package ssafy.lecture.lec_210720;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
3
6
G B G G B B
G B G G B G
B B B B G B
B G B B B B
G B B B B G
G B B B B G
5
G B G G B
G B G G B
B B B B G
B G B B B
G B B B B
3
G G B
G B B
B B B
 */

public class Building{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        int loopCount =Integer.parseInt(n);

        for (int i=0;i<loopCount;i++){
            int result = 2;
            int arrSize = Integer.parseInt(br.readLine());
            char[][] arr = new char[arrSize][arrSize];

            char[] temp ;
            for (int j=0;j<arrSize;j++){
                temp = br.readLine().replace(" ","").toCharArray();
                arr[j] = temp.clone();
            }

            // 루프 돌면서 G에 대한 확인. 만약 팔방면에 G가 없다면, 세로 쭉, 가로 쭉 해서 B의 갯수 세기.
            // 아닐 경우 2 반환
            for(int k=0;k<arrSize;k++){
                for (int j=0;j<arrSize;j++){
                    if (arr[k][j] == 'B' && search(arr,k,j)){

                        System.out.println("B이고, 근처에 B가 없을 때의 i =  " + i +" j = " + j);

                        int temp1 = 0;
                        for(int i1=0;i1<arrSize;i1++){
                            if(arr[k][i1]=='B') temp1+=1;
                        }
                        for(int i1=0;i1<arrSize;i1++){
                            if(arr[i1][j]=='B') temp1+=1;
                        }
                        result = Math.max(result,temp1);
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void print(char[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    static boolean inRange(int nx,int ny,int length){
        if( nx>=0 && nx < length && ny>=0 && ny<length){
            return true;
        }else{
            return false;
        }
    }
    static boolean search(char[][] arr,int i,int j){
        int[] dx = {-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};

        for(int k=0;k<8;k++){
            if(inRange(i+dx[k],j+dy[k],arr.length)){
                if( arr[i+dx[k]][j+dy[k]] == 'G'){
                    return false;
                }
            }
        }
        return true;
    }
}