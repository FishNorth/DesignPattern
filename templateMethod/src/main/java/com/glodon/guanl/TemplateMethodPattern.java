package com.glodon.guanl;

/**
 * @author: guanl-c
 * @date: 2019/3/15 20:01
 * @description:
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        AbstractClass class_2 = new CocreteClass_2();
        class_2.TemplateMethod();
        tm.TemplateMethod();
    }
}
