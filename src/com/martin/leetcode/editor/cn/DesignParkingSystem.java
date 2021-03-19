//请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。 
//
// 请你实现 ParkingSystem 类： 
//
// 
// ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停
//车位的数目。 
// bool addCar(int carType) 检查是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2
// 和 3 表示。一辆车只能停在 carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
//[[1, 1, 0], [1], [2], [3], [1]]
//输出：
//[null, true, true, false, false]
//
//解释：
//ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
//parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
//parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
//parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
//parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
// 
//
// 
//
// 提示： 
//
// 
// 0 <= big, medium, small <= 1000 
// carType 取值为 1， 2 或 3 
// 最多会调用 addCar 函数 1000 次 
// 
// Related Topics 设计 
// 👍 45 👎 0


package com.martin.leetcode.editor.cn;


public class DesignParkingSystem{
    public static void main(String[] args) {
        int num = 20;
        System.out.println(Integer.toBinaryString(num & (~num + 1)));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/*class ParkingSystem {
        int[] logging;

    public ParkingSystem(int big, int medium, int small) {
        logging = new int[4];
        logging[1] = big;
        logging[2] = medium;
        logging[3] = small;
    }
    
    public boolean addCar(int carType) {
        if (logging[carType] > 0) {
            logging[carType]--;
            return true;
        }
        return false;
    }
}*/

class ParkingSystem {

    int count = 0;

    public ParkingSystem(int big, int medium, int small) {
        for (int i = 0; i < 30; i++) {
            int check = 0;
            if (i < 10) {
                check = (big >> i) & 1;
            } else if (i < 20) {
                check = (medium >> (i-10)) & 1;
            } else {
                check = (small) >> (i-20) & 1;
            }
            count += check == 0 ? 0 : (1 << i);
        }
    }

    public boolean addCar(int carType) {
        carType = carType-1;
        int start = carType * 10, end = start + 10;
        int storage = 0;
        for (int i = start; i < end; i++) {
            if (((count >> i) & 1) == 1) {
                storage += (1 << (i-start));
            }
        }
        if (storage == 0) return false;

        storage--;
        for (int i = start; i < end; i++) {
            if (((storage >> (i-start)) & 1) == 1) {
                count |= (1 << i);
            } else {
                count &= ~(1 << i);
            }
        }

        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
