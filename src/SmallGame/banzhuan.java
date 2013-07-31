package SmallGame;



import Main.GamePanel;


// 创建一个俄罗斯方块类
public class banzhuan {
	public GamePanel gp;

    // blockType 代表方块类型
    // turnState代表方块状态
    public int blockType;
    public int score = 0;

    public int turnState;

    public int x;

    public int y;

    public int i = 0;

    public int j = 0;
    int flag = 0;
    // 定义已经放下的方块x=0-11,y=0-21;
    public int[][] map = new int[13][23];

    // 方块的形状 第一组代表方块类型有S、Z、L、J、I、O、T 7种 第二组 代表旋转几次 第三四组为 方块矩阵
    public final int shapes[][][] = new int[][][] {
    // i
            { { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
                    { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } },
            // s
            { { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },
            // z
            { { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } },
            // j
            { { 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                    { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
            // o
            { { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
            // l
            { { 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
            // t
            { { 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 } } };

    
    // 初始化构造方法
    public banzhuan(GamePanel Gp) {
    	gp=Gp;
    	
        newblock();
        newmap();
        drawwall();

    }
    
    
    // 生成新方块的方法
    public void newblock() {
        blockType = (int) (Math.random() * 1000) % 7;
        turnState = (int) (Math.random() * 1000) % 4;
        x = 4;
        y = 0;
    
    }

    // 画围墙
    
    public void drawwall() {
        for (i = 0; i < 12; i++) {
            map[i][21] = 2;
        }
        for (j = 0; j < 22; j++) {
            map[11][j] = 2;
            map[0][j] = 2;
        }
    }

    // 初始化地图
    public void newmap() {
        for (i = 0; i < 12; i++) {
            for (j = 0; j < 22; j++) {
                map[i][j] = 0;
            }
        }
    }



    // 旋转的方法
    public void turn() {
        int tempturnState = turnState;
        turnState = (turnState + 1) % 4;
        if (blow(x, y, blockType, turnState) == 1) {
        }
        if (blow(x, y, blockType, turnState) == 0) {
            turnState = tempturnState;
        }

    }

    // 左移的方法
    public void left() {
        if (blow(x - 1, y, blockType, turnState) == 1) {
            x = x - 1;
        }
      

    }

    // 右移的方法
    public void right() {
        if (blow(x + 1, y, blockType, turnState) == 1) {
            x = x + 1;
        }
     

    }

    // 下落的方法
    public void down() {
        if (blow(x, y + 1, blockType, turnState) == 1) {
            y = y + 1;
            delline();
        }
      
        if (blow(x, y + 1, blockType, turnState) == 0) {
            add(x, y, blockType, turnState);
            newblock();
            delline();
        }
    

    }

    // 是否合法的方法
    public int blow(int x, int y, int blockType, int turnState) {
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x
                        + b + 1][y + a] == 1))
                        || ((shapes[blockType][turnState][a * 4 + b] == 1) && (map[x
                                + b + 1][y + a] == 2))) {

                    return 0;
                }
            }
        }
        return 1;
    }

    // 消行的方法
    public void delline() {
        int c = 0;
        for (int b = 0; b < 22; b++) {
            for (int a = 0; a < 12; a++) {
                if (map[a][b] == 1) {

                    c = c + 1;
                    if (c == 10) {
                        score += 10;
                        gp.sp.play("delline");
                        for (int d = b; d > 0; d--) {
                            for (int e = 0; e < 11; e++) {
                                map[e][d] = map[e][d - 1];

                            }
                        }
                    }
                }
            }
            c = 0;
        }
    }

    // 判断你挂的方法
    public int gameover(int x, int y) {
        if (blow(x, y, blockType, turnState) == 0) {
            return 1;
        }
        if(score>=100){
        	return 2;
        }
        return 0;
    }

    // 把当前添加map
    public void add(int x, int y, int blockType, int turnState) {
        int j = 0;
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if (map[x + b + 1][y + a] == 0) {
                    map[x + b + 1][y + a] = shapes[blockType][turnState][j];
                }
                ;
                j++;
            }
        }
    }

 
    //逻辑更新
    public void update(){
    	   if (blow(x, y + 1, blockType, turnState) == 1) {
               y = y + 1;
               delline();
           }
           ;
           if (blow(x, y + 1, blockType, turnState) == 0) {

               if (flag == 1) {
                   add(x, y, blockType, turnState);
                   delline();
                   newblock();
                   flag = 0;
               }
               flag = 1;
           }
    }


	
}
