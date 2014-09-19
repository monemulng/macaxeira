package com.macaxeira.util;

import java.util.ArrayList;

public class AdapterParent {
	private String name;
	private String text1;
	private String checkedtype;
	private ArrayList<AdapterChild> children;
	
	public AdapterParent(String nome, ArrayList<AdapterChild> children){
		this.text1 = nome;
		this.children = children;
	}
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getText1()
	{
		return text1;
	}
	
	public void setText1(String text1)
	{
		this.text1 = text1;
	}
	public String getCheckedType()
	{
		return checkedtype;
	}
	
	public void setCheckedType(String checkedtype)
	{
		this.checkedtype = checkedtype;
	}
	public ArrayList<AdapterChild> getChildren()
	{
		return children;
	}
	
	public void setChildren(ArrayList<AdapterChild> children)
	{
		this.children = children;
	}
}
