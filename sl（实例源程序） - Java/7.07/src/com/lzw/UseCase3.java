package com.lzw;

public class UseCase3 {
	private float height;
	private float width;
	public UseCase3(float height,float width){
		this.height=height;
		this.width=width;
	}
	public float square(){
		return height*width;
	}
	public static void main(String args[]){
		UseCase3 u=new UseCase3(3.5f,4.5f);
		System.out.println(u.square());
	}
}
