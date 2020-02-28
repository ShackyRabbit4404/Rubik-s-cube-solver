import java.util.*;
public class main{
    public static void main(String[] args){
        
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the positions of the colors on the cube(r,g,w,b,o,y):");
        //green on bottom
        String[][] white = new String[3][3];
        System.out.println("Starting on the white face with green on the bottom:");
        for(int x = 0; x < white.length;x++){
            for(int y = 0; y < white[0].length;y++){
                System.out.println("X: "+x+"Y: "+y);
                if(x == 1 && y == 1){
                    white[1][1] = "w";
                }
                else{
                    white[x][y] = scn.nextLine();
                }
            }
        }
        //white on bottom
        String[][] blue = new String[3][3];
        System.out.println("The blue face with white on the bottom:");
        for(int x = 0; x < blue.length;x++){
            for(int y = 0; y < blue[0].length;y++){
                if(x == 1 && y ==  1){
                    blue[1][1] = "b";
                }
                else{
                    blue[x][y] = scn.nextLine();
                }
            }
        }
        //blue on bottom
        String[][] yellow = new String[3][3];
        System.out.println("The yellow face with blue on the bottom:");
        for(int x = 0; x < yellow.length;x++){
            for(int y = 0; y < yellow[0].length;y++){
                if(x == 1 && y ==  1){
                    yellow[1][1] = "y";
                }
                else{
                    yellow[x][y] = scn.nextLine();
                }
            }
        }
        //yellow on bottom
        String[][] green = new String[3][3];
        System.out.println("The green face with yellow on the bottom:");
        for(int x = 0; x < green.length;x++){
            for(int y = 0; y < green[0].length;y++){
                if(x == 1 && y ==  1){
                    green[1][1] = "g";
                }
                else{
                    green[x][y] = scn.nextLine();
                }
            }
        }
        //yellow on bottom
        String[][] orange = new String[3][3];
        System.out.println("The orange face with yellow on the bottom:");
        for(int x = 0; x < orange.length;x++){
            for(int y = 0; y < orange[0].length;y++){
                if(x == 1 && y ==  1){
                    orange[1][1] = "o";
                }
                else{
                    orange[x][y] = scn.nextLine();
                }
            }
        }
        //yellow on bottom
        String[][] red = new String[3][3];
        System.out.println("The red face with yellow on the bottom:");
        for(int x = 0; x < red.length;x++){
            for(int y = 0; y < red[0].length;y++){
                if(x == 1 && y ==  1){
                    red[1][1] = "r";
                }
                else{
                    red[x][y] = scn.nextLine();
                }
            }
        }
        String[][][] cube = new String[][][]{white,blue,yellow,green,orange,red};
        System.out.println("IsSolved: "+checkSolved(cube));
        printCube(cube);
        while(true){
            String movement = scn.nextLine();
            cube = move(cube,movement);
            System.out.println("Moved the cube: "+movement);
            printCube(cube);
        }
    }
    public static void printCube(String[][][] cube){
        for(String[][] face: cube){
            for(int y = 0; y < face[0].length; y++){
                for(int x = 0; x < face.length; x++){
                    System.out.print(face[x][y]+" ");
                }
                System.out.println();
            }
            System.out.println("\n");
        }
    }
    //assumes yellow is on top && looking at red face
    public static String[][][] move(String[][][] c,String move){
        if(move.equals("U'")){
            int[] top = new int[]{5,3,4,1};
            String[] temp = new String[]{c[top[0]][0][0],c[top[0]][1][0],c[top[0]][2][0]};
            for(int i = 0; i < top.length-1; i++){
                String[] replaced = new String[]{c[top[i+1]][0][0],c[top[i+1]][1][0],c[top[i+1]][2][0]};
                c[top[i+1]][0][0] = temp[0];
                c[top[i+1]][1][0] = temp[1];
                c[top[i+1]][2][0] = temp[2];
                temp = replaced;
            }
            c[5][0][0] = temp[0];
            c[5][1][0] = temp[1];
            c[5][2][0] = temp[2];
        }
        else if(move.equals("U")){
            int[] top = new int[]{5,1,4,3};
            String[] temp = new String[]{c[top[0]][0][0],c[top[0]][1][0],c[top[0]][2][0]};
            for(int i = 0; i < top.length-1; i++){
                String[] replaced = new String[]{c[top[i+1]][0][0],c[top[i+1]][1][0],c[top[i+1]][2][0]};
                c[top[i+1]][0][0] = temp[0];
                c[top[i+1]][1][0] = temp[1];
                c[top[i+1]][2][0] = temp[2];
                temp = replaced;
            }
            c[5][0][0] = temp[0];
            c[5][1][0] = temp[1];
            c[5][2][0] = temp[2];
        }
        return c;
    }
    public static boolean checkSolved(String[][][] cube){
        //white,blue,yellow,green,orange,red
        for(int i = 0; i < cube.length; i++){
            for(int x = 0; x < cube[i].length;x++){
                for(int y = 0; y < cube[i][x].length;y++){
                    if((i==0 && !cube[i][x][y].equals("w"))||(i==1 && !cube[i][x][y].equals("b"))||(i==2 && !cube[i][x][y].equals("y"))||(i==3 && !cube[i][x][y].equals("g"))||(i==4 && !cube[i][x][y].equals("o"))||(i==5 && !cube[i][x][y].equals("r"))){
                        System.out.println("Face: "+i);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}