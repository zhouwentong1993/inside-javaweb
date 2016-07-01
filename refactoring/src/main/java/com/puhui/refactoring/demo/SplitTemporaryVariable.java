package com.puhui.refactoring.demo;

/**
 * Created by wentong on 2016/7/1.
 * 分解临时变量
 * 针对每一次赋值，创造一个独立、对应的临时变量
 */
public class SplitTemporaryVariable {

    //    /**
//     * 计算一个苏格兰布丁运动的距离
//     * @param time 时间
//     * @return 距离
//     */
//    public double getDistanceTravelled(int time) {
//        double result;
//        double acc = primaryForce / mass;
//    }

    /**
     * temp 被使用了两次，承担了两个责任，这样很不方便于维护
     */
    public void test1() {
        int height = 0;
        int width = 0;
        double temp = 2 * (height + width);
        System.out.println(temp);
        temp = height * width;
        System.out.println(temp);
    }

    /**
     * 将变量声明成 final 类型，在语法层面上保证了这个变量不会被修改。
     * 具体做法：
     *  1. 在待分解临时变量的声明及其第一次被赋值处，修改其名称
     *  2. 将新的变量声明成 final 类型
     *  3. 以该临时变量的第二次赋值动作为界，修改此前对该临时变量的所有引用点，让他们引用新的临时变量。
     *  4. 在第二次赋值出，重新声明原先的那个临时变量。
     *  5. 编译、测试
     *  6. 重复上述流程。先改名，然后变成 final，在第二个引用之前改成修改之后的名字。
     */
    public void test2() {
        int height = 0;
        int width = 0;
        final double perimeter = 2 * (height + width);
        System.out.println(perimeter);
        final double area = height * width;
        System.out.println(area);
    }
}
