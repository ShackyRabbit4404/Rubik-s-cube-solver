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
                if(x != 1 && y !=  1){
                    white[x][y] = scn.nextLine();
                }
                else{
                    white[1][1] = "w";
                }
            }
        }
        //white on bottom
        String[][] blue = new String[3][3];
        System.out.println("The blue face with white on the bottom:");
        for(int x = 0; x < blue.length;x++){
            for(int y = 0; y < blue[0].length;y++){
                if(x != 1 && y !=  1){
                    blue[x][y] = scn.nextLine();
                }
                else{
                    blue[1][1] = "b";
                }
            }
        }
        //blue on bottom
        String[][] yellow = new String[3][3];
        System.out.println("The yellow face with blue on the bottom:");
        for(int x = 0; x < yellow.length;x++){
            for(int y = 0; y < yellow[0].length;y++){
                if(x != 1 && y !=  1){
                    yellow[x][y] = scn.nextLine();
                }
                else{
                    yellow[1][1] = "y";
                }
            }
        }
        //yellow on bottom
        String[][] green = new String[3][3];
        System.out.println("The green face with yellow on the bottom:");
        for(int x = 0; x < green.length;x++){
            for(int y = 0; y < green[0].length;y++){
                if(x != 1 && y !=  1){
                    green[x][y] = scn.nextLine();
                }
                else{
                    green[1][1] = "g";
                }
            }
        }
        //yellow on bottom
        String[][] orange = new String[3][3];
        System.out.println("The orange face with yellow on the bottom:");
        for(int x = 0; x < orange.length;x++){
            for(int y = 0; y < orange[0].length;y++){
                if(x != 1 && y !=  1){
                    orange[x][y] = scn.nextLine();
                }
                else{
                    orange[1][1] = "o";
                }
            }
        }
        //yellow on bottom
        String[][] red = new String[3][3];
        System.out.println("The red face with yellow on the bottom:");
        for(int x = 0; x < red.length;x++){
            for(int y = 0; y < red[0].length;y++){
                if(x != 1 && y !=  1){
                    red[x][y] = scn.nextLine();
                }
                else{
                    red[1][1] = "r";
                }
            }
        }
        String[][][] cube = new String[][][]{white,blue,yellow,green,orange,red};
        
    }
    public boolean checkSolved(String[][][] cube){
        //white,blue,yellow,green,orange,red
        for(int i = 0; i < cube.length; i++){
            for(int x = 0; x < cube[i].length;x++){
                for(int y = 0; y < cube[i][x].length;y++){
                    if(i==0){
                        
                    }
                    else if(i==1){
                        
                    }
                    else if(i==2){
                    
                    }
                    else if(i==3){
                        
                    }
                    else if(i==4){
                        
                    }
                    else{
                        
                    }
                }
            }
        }
        return true;
    }
}