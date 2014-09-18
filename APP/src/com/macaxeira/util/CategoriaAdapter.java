package com.macaxeira.util;

import com.macaxeira.android.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class CategoriaAdapter extends BaseExpandableListAdapter {
	
	public String[] categorias = new String[] {};
	public String[][] itens = new String[][] {};
	private Activity activity;
	private Context context = MyApp.getAppContext();
	
	public CategoriaAdapter(Activity activity, String[] categorias, String[][] itens){
		this.activity = activity;
		this.categorias = categorias;
		this.itens = itens;
	}
	
	static class ViewHolder {
        TextView text;
        CheckBox checkbox;
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
	
    	return convertView;
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
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		

		final ViewHolder holder;

        if (convertView == null) {
            LayoutInflater viewInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = viewInflater.inflate(R.layout.list_item_child, parent, false);
        	holder = new ViewHolder();
            holder.text = (TextView)convertView.findViewById(R.id.mtopicsgrouptv);
            holder.checkbox = (CheckBox)convertView.findViewById(R.id.cb_group);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(getGroup(groupPosition).toString());
    	return convertView;
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
