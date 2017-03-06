package com.rock.cybski.designPattern.templateMethod;

/*
 * 模板方法模式，定义了一个操作中算法的骨架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 * 通过把不变行为搬移到超类，去除子类中的重复代码
 */
public abstract class AbstractClass {
	
	public abstract void primitiveOperation1();
	public abstract void primitiveOperation2();
	
	/*
	 * 实现了一个模板方法，定义了算法的骨架，具体子类将重定义primitiveOperation以实现算法的特定步骤
	 */
	public void templateMethod(){
		this.primitiveOperation1();
		this.primitiveOperation2();
		System.out.println("");
	}

}
