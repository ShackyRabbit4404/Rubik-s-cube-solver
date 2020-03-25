import java.util.*;
public class main{
    public static void main(String[] args){
        String[][][] locationCube = new String[][][]{{{"U","U","V"},{"X","w","V"},{"X","W","W"}},{{"E","E","F"},{"H","b","F"},{"H","G","G"}},{{"A","A","B"},{"D","y","B"},{"D","C","C"}},{{"M","M","N"},{"P","g","N"},{"P","O","O"}},{{"Q","Q","R"},{"T","o","R"},{"T","S","S"}},{{"I","I","J"},{"L","r","J"},{"L","K","K"}}};
        String[][][] solvedCube = new String[][][]{{{"w","w","w"},{"w","w","w"},{"w","w","w"}},{{"b","b","b"},{"b","b","b"},{"b","b","b"}},{{"y","y","y"},{"y","y","y"},{"y","y","y"}},{{"g","g","g"},{"g","g","g"},{"g","g","g"}},{{"o","o","o"},{"o","o","o"},{"o","o","o"}},{{"r","r","r"},{"r","r","r"},{"r","r","r"}}};
        
        Scanner scn = new Scanner(System.in);
        /*
        System.out.println("Enter the positions of the colors on the cube(r,g,w,b,o,y):");
        //green on bottom
        String[][] white = new String[3][3];
        System.out.println("Starting on the white face with orange on the bottom:");
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
        System.out.println("The yellow face with red on the bottom:");
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
        System.out.println("The white face with yellow on the bottom:");
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
        System.out.println("The orange face with white on the bottom:");
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
        System.out.println("The red face with white on the bottom:");
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
            System.out.println("Has second layer: "+checkSecondLayer(cube));
            System.out.println("Is solved: "+checkSolved(cube));
            solveWhiteCross(cloneCube(cube));
            System.out.println("--------------------------------");
        }
    }
    public static String findEdge(String sideOne, String sideTwo,String[][][] cube){
        String[][][] locationCube = new String[][][]{{{"U","U","V"},{"X","w","V"},{"X","W","W"}},{{"E","E","F"},{"H","b","F"},{"H","G","G"}},{{"A","A","B"},{"D","y","B"},{"D","C","C"}},{{"M","M","N"},{"P","g","N"},{"P","O","O"}},{{"Q","Q","R"},{"T","o","R"},{"T","S","S"}},{{"I","I","J"},{"L","r","J"},{"L","K","K"}}};
        String[] edgePieces = new String[]{"AQ","BM","CI","DE","NT","JP","FL","RH","KU","OV","SW","GX"};
        String[] locsOne = new String[4];
        int oneCount = 0;
        String[] locsTwo = new String[4];
        int twoCount = 0;
        for(int face = 0; face < cube.length;face++){
            for(int row = 0; row< cube[face].length;row++){
                for(int col = 0; col < cube[face][row].length;col++){
                    if(row != col && !(row == 0 && col == 2) && !(row == 2 && col == 0)){
                        if(cube[face][row][col].equals(sideOne)){
                            locsOne[oneCount] = locationCube[face][row][col];
                            oneCount++;
                        }
                        else if(cube[face][row][col].equals(sideTwo)){
                            locsTwo[twoCount] = locationCube[face][row][col];
                            twoCount++;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < locsOne.length; i++){
            for(int a = 0; a < locsTwo.length; a++){
                for(String edge:edgePieces){
                    if(edge.contains(locsOne[i]) && edge.contains(locsTwo[a])){
                        return locsOne[i];
                    }
                }
            }
        }
        return "ERROR: piece does not exist";
    }
    public static String[][][] solveWhiteCross(String[][][] cube){
        String[][][] solvedCube = new String[][][]{{{"w","w","w"},{"w","w","w"},{"w","w","w"}},{{"b","b","b"},{"b","b","b"},{"b","b","b"}},{{"y","y","y"},{"y","y","y"},{"y","y","y"}},{{"g","g","g"},{"g","g","g"},{"g","g","g"}},{{"o","o","o"},{"o","o","o"},{"o","o","o"}},{{"r","r","r"},{"r","r","r"},{"r","r","r"}}};
        String[] pieces = new String[]{"rw","bw","ow","gw"};
        String moves = "";
        for(int i = 0; i < 4; i++){
            String loc = findEdge(pieces[i].substring(0,1),"w",cube);
            String face = getFace(loc);
            System.out.println("Location of edge piece: "+loc+" Face it's on: "+face);
            if(face.equals("D")){
                cube = move(cube,face+"2");
                loc = findEdge(pieces[i].substring(0,1),"w",cube);
                face = "U";
                moves += face+"2 ";
            }
            if(isEdgeInMidRow(loc)){
                int count = 0;
                while(!isEdgeInTopRow(loc)){
                    cube = move(cube,face);
                    count++;
                    loc = findEdge(pieces[i].substring(0,1),"w",cube);
                    moves += face+" ";
                }
                cube = move(cube,"U");
                moves += "U ";
                
                for(int a = 0; a < count; a++){
                    cube = move(cube,face+"'");
                    moves += face+"' ";
                }
                loc = findEdge(pieces[i].substring(0,1),"w",cube);
                face = getFace(loc);
            }
            if(face.equals("U")){
                while(!getFace(findEdge("w",pieces[i].substring(0,1),cube)).equals("F")){
                    cube = move(cube,"U");
                    loc = findEdge(pieces[i].substring(0,1),"w",cube);
                    face = getFace(loc);
                    moves += "U ";
                }
                cube = move(cube,"F");
                cube = move(cube,"R");
                cube = move(cube,"U'");
                cube = move(cube,"R'");
                cube = move(cube,"F'");
                moves += "F R U' R' F' ";
            }
            if(isEdgeInTopRow(loc)){
                String target = getFace(findEdge(pieces[i].substring(0,1),"w",solvedCube));
                System.out.println("Target Face: "+target+" Current Face: "+face);
                while(!target.equals(face)){
                    cube = move(cube,"U");
                    loc = findEdge(pieces[i].substring(0,1),"w",cube);
                    face = getFace(loc);
                    moves += "U ";
                }
                cube = move(cube,face+"2");
                moves += face+"2 ";
            }
        }
        System.out.println("Solve White Cross: "+moves);
        return cube;
    }
    public static String getFace(String loc){
        if(loc.equals("A") || loc.equals("B") || loc.equals("C") || loc.equals("D")){
            return "U";
        }
        else if(loc.equals("E") || loc.equals("F") || loc.equals("G") || loc.equals("H")){
            return "L";
        }
        else if(loc.equals("I") || loc.equals("J") || loc.equals("K") || loc.equals("L")){
            return "F";
        }
        else if(loc.equals("M") || loc.equals("N") || loc.equals("O") || loc.equals("P")){
            return "R";
        }
        else if(loc.equals("Q") || loc.equals("R") || loc.equals("S") || loc.equals("T")){
            return "B";
        }
        return "D";
    }
    public static boolean isEdgeInTopRow(String loc){
        if(loc.equals("A") || loc.equals("B") || loc.equals("C") || loc.equals("D") || loc.equals("M") || loc.equals("Q") || loc.equals("E") || loc.equals("I")){
            return true;
        }
        return false;
    }
    public static boolean isEdgeInMidRow(String loc){
        if(loc.equals("F") || loc.equals("L") || loc.equals("J") || loc.equals("P") || loc.equals("N") || loc.equals("T") || loc.equals("R") || loc.equals("H") ){
            return true;
        }
        return false;
    }
    public static void printCube(String[][][] cube){
        for(String[][] face: cube){
            for(int y = 0; y < face[0].length; y++){
                for(int x = 0; x < face.length; x++){
                    System.out.print(face[y][x]+" ");
                }
                System.out.println();
            }
            System.out.println("\n");
        }
    }
    public static boolean checkSecondLayer(String[][][] c){
        if(!c[5][1][0].equals("r") || !c[5][1][2].equals("r") || !c[3][1][0].equals("g") || !c[3][1][2].equals("g") || !c[4][1][0].equals("o") || !c[4][1][2].equals("o") || !c[1][1][0].equals("b") || !c[1][1][2].equals("b")){
            return false;
        }
        return true;
    }
    public static boolean checkWhiteCross(String[][][] c){
        if(!c[0][1][0].equals("w") || !c[0][1][2].equals("w") || !c[0][0][1].equals("w") || !c[0][2][1].equals("w") ){
            return false;
        }
        if(!c[5][2][1].equals("r") || !c[1][2][1].equals("b") || !c[3][2][1].equals("g") || !c[4][2][1].equals("o")){
            return false;
        }
        return true;
    }
    public static boolean checkBottomLayer(String[][][] c){
        if(!c[0][0][0].equals("w") || !c[5][2][0].equals("r") || !c[0][0][1].equals("w") || !c[5][2][1].equals("r") || !c[0][0][1].equals("w") || !c[5][2][2].equals("r")){
            return false;
        }
        if(!c[0][0][0].equals("w") || !c[1][2][2].equals("b") || !c[0][1][0].equals("w") || !c[1][2][1].equals("b") || !c[0][2][0].equals("w") || !c[1][2][0].equals("b")){
            return false;
        }
        if(!c[0][0][2].equals("w") || !c[3][2][0].equals("g") || !c[0][1][2].equals("w") || !c[3][2][1].equals("g") || !c[0][2][2].equals("w") || !c[3][2][2].equals("g")){
            return false;
        }
        if(!c[0][2][0].equals("w") || !c[4][2][2].equals("o") || !c[0][2][1].equals("w") || !c[4][2][1].equals("o") || !c[0][2][2].equals("w") || !c[4][2][0].equals("o")){
            return false;
        }
        return true;
    }
    public static String[][][] cloneCube(String[][][] cube){
        String[][][] c = new String[cube.length][cube[0].length][cube[0][0].length];
        for(int a = 0;  a < c.length; a++){
            for(int b = 0; b < c[0].length; b++){
                for(int d = 0; d < c[0][0].length; d++){
                    c[a][b][d] = cube[a][b][d];
                }
            }
        }
        return c;
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
            String[] red = new String[]{c[3][0][0],c[3][0][1],c[3][0][2]};
            String[] blue = new String[]{c[5][0][0],c[5][0][1],c[5][0][2]};
            String[] orange = new String[]{c[1][0][0],c[1][0][1],c[1][0][2]};
            String[] green = new String[]{c[4][0][0],c[4][0][1],c[4][0][2]};
            
            c[5][0][0] = red[0];
            c[5][0][1] = red[1];
            c[5][0][2] = red[2];
            
            c[1][0][0] = blue[0];
            c[1][0][1] = blue[1];
            c[1][0][2] = blue[2];
            
            c[4][0][0] = orange[0];
            c[4][0][1] = orange[1];
            c[4][0][2] = orange[2];
            
            c[3][0][0] = green[0];
            c[3][0][1] = green[1];
            c[3][0][2] = green[2];
            
            c[2] = rotate("counterclock wise",c[2]);
            c[2] = rotate("counterclock wise",c[2]);
        }
        else if(move.equals("U2")){
            c = move(c,"U");
            c = move(c,"U");
        }
        else if(move.equals("D")){
            String[] red = new String[]{c[1][2][0],c[1][2][1],c[1][2][2]};
            String[] green = new String[]{c[5][2][0],c[5][2][1],c[5][2][2]};
            String[] orange = new String[]{c[3][2][0],c[3][2][1],c[3][2][2]};
            String[] blue = new String[]{c[4][2][0],c[4][2][1],c[4][2][2]};
            
            c[5][2][0] = red[0];
            c[5][2][1] = red[1];
            c[5][2][2] = red[2];
            
            c[3][2][0] = green[0];
            c[3][2][1] = green[1];
            c[3][2][2] = green[2];
            
            c[4][2][0] = orange[0];
            c[4][2][1] = orange[1];
            c[4][2][2] = orange[2];
            
            c[1][2][0] = blue[0];
            c[1][2][1] = blue[1];
            c[1][2][2] = blue[2];
            
            c[0] = rotate("counterclock wise",c[0]);
            c[0] = rotate("counterclock wise",c[0]);
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
            //order white,blue,yellow,green,orange,red
            String[] red = new String[]{c[0][0][2],c[0][1][2],c[0][2][2]};
            String[] yellow = new String[]{c[5][0][2],c[5][1][2],c[5][2][2]};
            String[] orange = new String[]{c[2][2][2],c[2][1][2],c[2][0][2]};
            String[] white = new String[]{c[4][0][0],c[4][1][0],c[4][2][0]};
            
            c[5][0][2] = red[0];
            c[5][1][2] = red[1];
            c[5][2][2] = red[2];
            
            c[2][0][2] = yellow[0];
            c[2][1][2] = yellow[1];
            c[2][2][2] = yellow[2];
            
            c[4][0][0] = orange[0];
            c[4][1][0] = orange[1];
            c[4][2][0] = orange[2];
            
            c[0][0][2] = white[2];
            c[0][1][2] = white[1];
            c[0][2][2] = white[0];
            
            c[3] = rotate("counterclock wise",c[3]);
            c[3] = rotate("counterclock wise",c[3]);
            
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
            String[] yellow = new String[]{c[1][2][2],c[1][1][2],c[1][0][2]};
            String[] green = new String[]{c[2][2][0],c[2][2][1],c[2][2][2]};
            String[] white = new String[]{c[3][2][0],c[3][1][0],c[3][0][0]};
            String[] blue = new String[]{c[0][0][0],c[0][0][1],c[0][0][2]};
            
            c[2][2][0] = yellow[0];
            c[2][2][1] = yellow[1];
            c[2][2][2] = yellow[2];
            
            c[3][0][0] = green[0];
            c[3][1][0] = green[1];
            c[3][2][0] = green[2];
            
            c[0][0][0] = white[0];
            c[0][0][1] = white[1];
            c[0][0][2] = white[2];
            
            c[1][0][2] = blue[0];
            c[1][1][2] = blue[1];
            c[1][2][2] = blue[2];
            
            c[5] = rotate("counterclock wise",c[5]);
            c[5] = rotate("counterclock wise",c[5]);
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
           //order white,blue,yellow,green,orange,red
            String[] yellow = new String[]{c[3][0][2],c[3][1][2],c[3][2][2]};
            String[] blue = new String[]{c[2][0][2],c[2][0][1],c[2][0][0]};
            String[] white = new String[]{c[1][0][0],c[1][1][0],c[1][2][0]};
            String[] green = new String[]{c[0][2][2],c[0][2][1],c[0][2][0]};
            
            c[2][0][0] = yellow[0];
            c[2][0][1] = yellow[1];
            c[2][0][2] = yellow[2];
            
            c[1][0][0] = blue[0];
            c[1][1][0] = blue[1];
            c[1][2][0] = blue[2];
            
            c[0][2][0] = white[0];
            c[0][2][1] = white[1];
            c[0][2][2] = white[2];
            
            c[3][0][2] = green[0];
            c[3][1][2] = green[1];
            c[3][2][2] = green[2];
            
            c[4] = rotate("counterclock wise",c[4]);
            c[4] = rotate("counterclock wise",c[4]);
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
            c[3] = rotate("counterclock wise",c[3]);
            c[3] = rotate("counterclock wise",c[3]);
            c[1] = rotate("clock wise",c[1]);
            c[1] = rotate("clock wise",c[1]);
        }
        else if(move.equals("x'")){
            c = move(c,"x");
            c = move(c,"x");
            c = move(c,"x");
        }
        else if(move.equals("y'")){
            int[] order = new int[]{5,1,4,3};
            String temp[][] = c[order[0]].clone();
            for(int i = 0; i < order.length-1;i++){
                String[][] replace = c[order[i+1]];
                c[order[i+1]] = temp;
                temp = replace;
            }
            c[order[0]] = temp;
            c[2] = rotate("counterclock wise",c[2]);
            c[2] = rotate("counterclock wise",c[2]);
            c[0] = rotate("clock wise",c[0]);
            c[0] = rotate("clock wise",c[0]);
        }
        else if(move.equals("y")){
            c = move(c,"y'");
            c = move(c,"y'");
            c = move(c,"y'");
        }
        else if(move.equals("L")){
            String[] red = new String[]{c[2][0][0],c[2][1][0],c[2][2][0]};
            String[] white = new String[]{c[5][0][0],c[5][1][0],c[5][2][0]};
            String[] orange  = new String[]{c[0][2][0],c[0][1][0],c[0][0][0]};
            String[] yellow = new String[]{c[4][2][2],c[4][1][2],c[4][0][2]};
            
            c[5][0][0] = red[0];
            c[5][1][0] = red[1];
            c[5][2][0] = red[2];
            
            c[0][0][0] = white[0];
            c[0][1][0] = white[1];
            c[0][2][0] = white[2];
            
            c[4][0][2] = orange[0];
            c[4][1][2] = orange[1];
            c[4][2][2] = orange[2];
            
            c[2][0][0] = yellow[0];
            c[2][1][0] = yellow[1];
            c[2][2][0] = yellow[2];
            
            c[1] = rotate("counterclock wise",c[1]);
            c[1] = rotate("counterclock wise",c[1]);
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