package com.macaxeira.util;

import com.macaxeira.model.Adicional;
import com.macaxeira.model.Ingrediente;

public class AdapterChild {
	
	private String name;
	private String text1;
	private Ingrediente ingrediente;
	private Adicional adicional;
	private boolean isChecked;
	
	public AdapterChild(Ingrediente ingrediente){
		this.ingrediente = ingrediente;
		text1 = ingrediente.getNome();
		isChecked = ingrediente.isChecked();
	}
	public AdapterChild(Adicional adicional){
		this.adicional = adicional;
		text1 = adicional.getNome();
		isChecked = adicional.isChecked();
	}
	public AdapterChild(){
		super();
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
	
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
		if(adicional!=null){
			adicional.setChecked(isChecked);
		}
		if(ingrediente!=null){
			ingrediente.setChecked(isChecked);
		}
	}

	public Boolean isChecked() {
		return isChecked;
	}
	
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public Adicional getAdicional() {
		return adicional;
	}
	public void setAdicional(Adicional adicional) {
		this.adicional = adicional;
	}
}
