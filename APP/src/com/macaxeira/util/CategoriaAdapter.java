package com.macaxeira.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class CategoriaAdapter extends BaseExpandableListAdapter {
	
	public String[] categorias = new String[] {};
	public String[][] itens = new String[][] {};
	private Activity activity;
	
	public CategoriaAdapter(Activity activity, String[] categorias, String[][] itens){
		this.activity = activity;
		this.categorias = categorias;
		this.itens = itens;
	}
	
	@Override
	public Object getChild(int childPosition, int groupPosition) {
		return itens[groupPosition][childPosition];
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		TextView txt = new TextView (this.activity);
		txt.setText(itens[groupPosition][childPosition]);
		
		return txt;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return itens[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return categorias[groupPosition];
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return categorias.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		TextView txt = new TextView (this.activity);
		txt.setText(categorias[groupPosition]);
		
		return txt;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}
}
