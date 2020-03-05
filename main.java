import java.util.*;
public class main{
    public static void main(String[] args){
        String[][][] solvedCube = new String[][][]{{{"w","w","w"},{"w","w","w"},{"w","w","w"}},{{"b","b","b"},{"b","b","b"},{"b","b","b"}},{{"y","y","y"},{"y","y","y"},{"y","y","y"}},{{"g","g","g"},{"g","g","g"},{"g","g","g"}},{{"o","o","o"},{"o","o","o"},{"o","o","o"}},{{"r","r","r"},{"r","r","r"},{"r","r","r"}}};
        Scanner scn = new Scanner(System.in);
        /*
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
        */
        //String[][][] cube = new String[][][]{white,blue,yellow,green,orange,red};
        String[][][] cube = solvedCube;
        printCube(cube);
        System.out.println("--------------------------------");
        while(true){
            String movement = scn.nextLine();
            cube = move(cube,movement);
            System.out.println("Moved the cube: "+movement);
            printCube(cube);
            System.out.println("Has second layer solved: "+checkSecondLayer(cube));
            System.out.println("Has first layer: "+checkBottomLayer(cube));
            System.out.println("Has a white cross: "+checkWhiteCross(cube));
            System.out.println("Is solved: "+checkSolved(cube));
            System.out.println("--------------------------------");
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
    public static boolean checkSecondLayer(String[][][] c){
        if(!c[5][0][1].equals("r") || !c[5][2][1].equals("r") || !c[3][0][1].equals("g") || !c[3][2][1].equals("g") || !c[4][0][1].equals("o") || !c[4][2][1].equals("o") || !c[1][0][1].equals("b") || !c[1][2][1].equals("b")){
            return false;
        }
        return true;
    }
    public static boolean checkWhiteCross(String[][][] c){
        if(!c[0][1][0].equals("w") || !c[0][1][2].equals("w") || !c[0][0][1].equals("w") || !c[0][2][1].equals("w") ){
            return false;
        }
        return true;
    }
    public static boolean checkBottomLayer(String[][][] c){
        if(!c[0][0][0].equals("w") || !c[5][0][2].equals("r") || !c[0][1][0].equals("w") || !c[5][1][2].equals("r") || !c[0][2][0].equals("w") || !c[5][2][2].equals("r")){
            return false;
        }
        if(!c[0][0][0].equals("w") || !c[1][2][2].equals("b") || !c[0][0][1].equals("w") || !c[1][1][2].equals("b") || !c[0][0][2].equals("w") || !c[1][0][2].equals("b")){
            return false;
        }
        if(!c[0][2][0].equals("w") || !c[3][0][2].equals("g") || !c[0][2][1].equals("w") || !c[3][1][2].equals("g") || !c[0][2][2].equals("w") || !c[3][2][2].equals("g")){
            return false;
        }
        if(!c[0][1][2].equals("w") || !c[4][2][2].equals("o") || !c[0][1][2].equals("w") || !c[4][1][2].equals("o") || !c[0][0][2].equals("w") || !c[4][0][2].equals("o")){
            return false;
        }
        return true;
    }
    public static String[][] rotate(String dir,String[][] face){
        int[][] order = new int[8][2];
        if(dir.equals("clock wise")){
            order = new int[][]{{0,0},{1,0},{2,0},{2,1},{2,2},{1,2},{0,2},{0,1}};
        }
        else{
            order = new int[][]{{0,0},{0,1},{0,2},{1,2},{2,2},{2,1},{2,0},{1,0}};
        }
        String replace = face[order[0][0]][order[0][1]];
        for(int i = 0; i < order.length-1; i++){
            String temp = face[order[i+1][0]][order[i+1][1]];
            face[order[i+1][0]][order[i+1][1]] = replace;
            replace = temp;
        } 
        face[order[0][0]][order[0][1]] = replace;
        return face;
    }
    //assumes yellow is on top && looking at red face
    //order white,blue,yellow,green,orange,red  
    public static String[][][] move(String[][][] c,String move){
        if(move.equals("U'")){
            c = move(c,"U");
            c = move(c,"U");
            c = move(c,"U");
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
            c[2] = rotate("clock wise",c[2]);
            c[2] = rotate("clock wise",c[2]);
        }
        else if(move.equals("U2")){
            c = move(c,"U");
            c = move(c,"U");
        }
        else if(move.equals("D")){
            int[] top = new int[]{5,3,4,1};
            String[] temp = new String[]{c[top[0]][0][2],c[top[0]][1][2],c[top[0]][2][2]};
            for(int i = 0; i < top.length-1; i++){
                String[] replaced = new String[]{c[top[i+1]][0][2],c[top[i+1]][1][2],c[top[i+1]][2][2]};
                c[top[i+1]][0][2] = temp[0];
                c[top[i+1]][1][2] = temp[1];
                c[top[i+1]][2][2] = temp[2];
                temp = replaced;
            }
            c[5][0][2] = temp[0];
            c[5][1][2] = temp[1];
            c[5][2][2] = temp[2];
            c[0] = rotate("clock wise",c[0]);
            c[0] = rotate("clock wise",c[0]);
        }
        else if(move.equals("D'")){
            c = move(c,"D");
            c = move(c,"D");
            c = move(c,"D");
        }
        else if(move.equals("D2")){
            c = move(c,"D");
            c = move(c,"D");
        }
        else if(move.equals("R")){
            int[] right = new int[]{5,2,4,0};
            String[] temp = new String[] {c[right[0]][2][0],c[right[0]][2][1],c[right[0]][2][2]};
            for(int i = 0; i < right.length-1;i++){
                String[] replaced = new String[]{c[right[i+1]][2][0],c[right[i+1]][2][1],c[right[i+1]][2][2]};
                c[right[i+1]][2][0] = temp[0];
                c[right[i+1]][2][1] = temp[1];
                c[right[i+1]][2][2] = temp[2];
                temp = replaced;
            }
            c[5][2][0] = temp[0];
            c[5][2][1] = temp[1];
            c[5][2][2] = temp[2];
            c[3] = rotate("clock wise",c[3]);
            c[3] = rotate("clock wise",c[3]);
        }
        else if(move.equals("R'")){
            c = move(c,"R");
            c = move(c,"R");
            c = move(c,"R");
        }
        else if(move.equals("R2")){
            c = move(c,"R");
            c = move(c,"R");
        }
        else if(move.equals("F")){
            int[] front = new int[]{2,3,0,1};
            String[] temp = new String[] {c[front[0]][0][2],c[front[0]][1][2],c[front[0]][2][2]};
            for(int i = 0; i < front.length-1;i++){
                String[] replaced = new String[]{c[front[i+1]][2][2],c[front[i+1]][2][2],c[front[i+1]][2][2]};
                c[front[i+1]][0][2] = temp[0];
                c[front[i+1]][1][2] = temp[1];
                c[front[i+1]][2][2] = temp[2];
                temp = replaced;
            }
            c[front[0]][0][2] = temp[0];
            c[front[0]][1][2] = temp[1];
            c[front[0]][2][2] = temp[2];
            c[5] = rotate("clock wise",c[5]);
            c[5] = rotate("clock wise",c[5]);
        }
        else if(move.equals("F'")){
            c = move(c,"F");
            c = move(c,"F");
            c = move(c,"F");
        }
        else if(move.equals("F2")){
            c = move(c,"F");
            c = move(c,"F");
        }
        else if(move.equals("B'")){
            c = move(c,"B");
            c = move(c,"B");
            c = move(c,"B");
        }
        else if(move.equals("B2")){
            c = move(c,"B");
            c = move(c,"B");
        }
        else if(move.equals("B")){
            int[] front = new int[]{2,1,0,3};
            String[] temp = new String[] {c[front[0]][0][0],c[front[0]][1][0],c[front[0]][2][0]};
            for(int i = 0; i < front.length-1;i++){
                String[] replaced = new String[]{c[front[i+1]][2][0],c[front[i+1]][2][0],c[front[i+1]][2][0]};
                c[front[i+1]][0][0] = temp[0];
                c[front[i+1]][1][0] = temp[1];
                c[front[i+1]][2][0] = temp[2];
                temp = replaced;
            }
            c[front[0]][0][0] = temp[0];
            c[front[0]][1][0] = temp[1];
            c[front[0]][2][0] = temp[2];
            c[4] = rotate("clock wise",c[4]);
            c[4] = rotate("clock wise",c[4]);
        }
        else if(move.equals("x")){
            int[] order = new int[]{5,2,4,0};
            String temp[][] = c[order[0]].clone();
            for(int i = 0; i < order.length-1;i++){
                String[][] replace = c[order[i+1]];
                c[order[i+1]] = temp;
                temp = replace;
            }
            c[order[0]] = temp;
        }
        else if(move.equals("x'")){
            c = move(c,"x");
            c = move(c,"x");
            c = move(c,"x");
        }
        else if(move.equals("y")){
            int[] order = new int[]{5,1,4,3};
            String temp[][] = c[order[0]].clone();
            for(int i = 0; i < order.length-1;i++){
                String[][] replace = c[order[i+1]];
                c[order[i+1]] = temp;
                temp = replace;
            }
            c[order[0]] = temp;
        }
        else if(move.equals("y'")){
            c = move(c,"y");
            c = move(c,"y");
            c = move(c,"y");
        }
        else if(move.equals("L")){
            int[] right = new int[]{5,0,4,2};
            String[] temp = new String[] {c[right[0]][0][0],c[right[0]][0][1],c[right[0]][0][2]};
            for(int i = 0; i < right.length-1;i++){
                String[] replaced = new String[]{c[right[i+1]][0][0],c[right[i+1]][0][1],c[right[i+1]][0][2]};
                c[right[i+1]][0][0] = temp[0];
                c[right[i+1]][0][1] = temp[1];
                c[right[i+1]][0][2] = temp[2];
                temp = replaced;
            } 
            c[5][0][0] = temp[0];
            c[5][0][1] = temp[1];
            c[5][0][2] = temp[2];
            c[1] = rotate("clock wise",c[1]);
            c[1] = rotate("clock wise",c[1]);
        }
        else if(move.equals("L'")){
            c = move(c,"L");
            c = move(c,"L");
            c = move(c,"L");
        }
        else if(move.equals("L2")){
            c = move(c,"L");
            c = move(c,"L");
        }
        else if(move.equals("M")){
            c = move(c,"L");
            c = move(c,"R'");
            c = move(c,"x");
        }
        else if(move.equals("M'")){
            c = move(c,"M");
            c = move(c,"M");
            c = move(c,"M");
        }
        else if(move.equals("M2")){
            c = move(c,"M");
            c = move(c,"M");
        }
        else if(move.equals("r")){
            c = move(c,"M");
            c = move(c,"R");
        }
        else if(move.equals("r'")){
            c = move(c,"r");
            c = move(c,"r");
            c = move(c,"r");
        }
        return c;
    }
    public static boolean checkSolved(String[][][] cube){
        //white,blue,yellow,green,orange,red
        for(int i = 0; i < cube.length; i++){
            for(int x = 0; x < cube[i].length;x++){
                for(int y = 0; y < cube[i][x].length;y++){
                    if((i==0 && !cube[i][x][y].equals("w"))||(i==1 && !cube[i][x][y].equals("b"))||(i==2 && !cube[i][x][y].equals("y"))||(i==3 && !cube[i][x][y].equals("g"))||(i==4 && !cube[i][x][y].equals("o"))||(i==5 && !cube[i][x][y].equals("r"))){
                        //System.out.println("Face: "+i);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}