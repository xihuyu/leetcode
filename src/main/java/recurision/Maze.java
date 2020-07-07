package recurision;

/**
 * @ClassNameMaze
 * @Description 迷宫问题
 * @Author fenggaopan
 * @Date2020/7/7 9:54 下午
 * @Version V1.0
 **/
public class Maze {


    public static void main(String[] args) {
        //二维数组表示迷宫
        //地图
        int[][] map = new int[8][7];
        //1表示墙,上下
        for(int i=0;i<7;i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右1
        for(int i=0;i<8;i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        System.out.println("======地图情况===========");
        for(int i=0;i<8;i++) {
            for(int j=0;j<7;j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }

        //递归找路
        findWay(map, 1,1);

        //输出新的地图
        System.out.println("======发现的路情况===========");
        for(int i=0;i<8;i++) {
            for(int j=0;j<7;j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map 表示地图
     * @param i 从什么位置开始找
     * @param j
     * @return 返回结果
     * 1.如果找到map[6][5]表示找到路
     * 2.挡map[i][j] 为0表示没有走过，1表示墙，2表示通路，可以走，3表示走过
     * 3.需要指定一个策略:下->右->上->左
     */
    public static boolean findWay(int[][]map , int i, int j) {
        if(map[6][5] ==2) {
            return true;
        } else {
            if(map[i][j] ==0) {
                map[i][j] = 2; //假定可以走通
                //下
                if(findWay(map, i+1,j)) {
                    return true;
                } else if(findWay(map, i, j+1)) {
                    //右
                    return true;
                } else if(findWay(map, i-1, j)) {
                    //上
                    return true;
                } else if(findWay(map, i, j-1)) {
                    //左
                    return true;
                } else {
                    //置为3
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //不为0，可能是1，2，3
                return false;
            }
        }
    }
}
