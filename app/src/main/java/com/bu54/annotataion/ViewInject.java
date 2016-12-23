package com.bu54.annotataion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解初始化控件
 */

/**
 * 元注解是指注解的注解。包括  @Retention @Target @Document @Inherited四种。
 *
 * @Retention: 定义注解的保留策略
 * @Retention(RetentionPolicy.SOURCE)//注解仅存在于源码中，在class字节码文件中不包含
 * @Retention(RetentionPolicy.CLASS)// 默认的保留策略，注解会在class字节码文件中存在，但运行时无法得
 * @Retention(RetentionPolicy.RUNTIME)// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
 * @Documented
 * @Retention(RetentionPolicy.RUNTIME)
 * @Target(ElementType.ANNOTATION_TYPE) public @interface Target {
 * ElementType[] value();
 * }
 * @Target(ElementType.TYPE) //接口、类、枚举、注解
 * @Target(ElementType.FIELD) //字段、枚举的常量
 * @Target(ElementType.METHOD) //方法
 * @Target(ElementType.PARAMETER) //方法参数
 * @Target(ElementType.CONSTRUCTOR) //构造函数
 * @Target(ElementType.LOCAL_VARIABLE)//局部变量
 * @Target(ElementType.ANNOTATION_TYPE)//注解
 * @Target(ElementType.PACKAGE) ///包
 * 其中的@interface是一个关键字，在设计annotations的时候必须把一个类型定义为@interface，而不能用class或interface关键字，由以上的源码可以知道，他的elementType 可以有多个，一个注解可以为类的，方法的，字段的等等。
 * <p>
 * 1.3、@Document：说明该注解将被包含在javadoc中
 * <p>
 * 1.4、@Inherited：说明子类可以继承父类中的该注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewInject {
    int value() default 0;
}