/*
 * 矩形对象
 */
package cn.gzccc.bean;

public class Rectangle {

	private int width = 10;
	private int height = 10;
	private int area = 0;// 面积

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getArea() {
		area = width * height;
		return area;
	}

}
