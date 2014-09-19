package com.macaxeira.util;

import java.util.ArrayList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.macaxeira.android.R;

public class ExpandableAdapter extends BaseExpandableListAdapter {	
		private LayoutInflater inflater;
		private ArrayList<AdapterParent> parents;
		
		public ExpandableAdapter(ArrayList<AdapterParent> parents)
		{
			this.parents = parents;
			// Create Layout Inflator
			inflater = LayoutInflater.from(MyApp.getAppContext());
		}
    
		
		// This Function used to inflate parent rows view
		
		@Override
		public View getGroupView(int groupPosition, boolean isExpanded, 
				View convertView, ViewGroup parentView)
		{
			final AdapterParent parent = parents.get(groupPosition);
			
			convertView = inflater.inflate(R.layout.parent_row, parentView, false); 
			
			((TextView) convertView.findViewById(R.id.text1)).setText(parent.getText1());
			//((TextView) convertView.findViewById(R.id.text)).setText(parent.getText2());
			
			
			// Get grouprow.xml file checkbox elements
			//CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
			//checkbox.setChecked(parent.isChecked());
			
			// Set CheckUpdateListener for CheckBox (see below CheckUpdateListener class)
			//checkbox.setOnCheckedChangeListener(new CheckUpdateListener(parent));
			
			return convertView;
		}

		
		// This Function used to inflate child rows view
		@Override
		public View getChildView(int groupPosition, int childPosition, boolean isLastChild, 
				View convertView, ViewGroup parentView)
		{
			final AdapterParent parent = parents.get(groupPosition);
			final AdapterChild child = parent.getChildren().get(childPosition);
			
			// Inflate childrow.xml file for child rows
			convertView = inflater.inflate(R.layout.child_row, parentView, false);
			
			// Get childrow.xml file elements and set values
			((TextView) convertView.findViewById(R.id.text1)).setText(child.getText1());
			
			CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
			checkbox.setChecked(child.isChecked());
			
			// Set CheckUpdateListener for CheckBox (see below CheckUpdateListener class)
			checkbox.setOnCheckedChangeListener(new CheckUpdateListener(child));
			
			return convertView;
		}

		
		@Override
		public Object getChild(int groupPosition, int childPosition)
		{
			//Log.i("Childs", groupPosition+"=  getChild =="+childPosition);
			return parents.get(groupPosition).getChildren().get(childPosition);
		}

		//Call when child row clicked
		@Override
		public long getChildId(int groupPosition, int childPosition)
		{
			/****** When Child row clicked then this function call *******/
			
			//Log.i("Noise", "parent == "+groupPosition+"=  child : =="+childPosition);
			return childPosition;
		}

		@Override
		public int getChildrenCount(int groupPosition)
		{
			int size=0;
			if(parents.get(groupPosition).getChildren()!=null)
				size = parents.get(groupPosition).getChildren().size();
			return size;
		}
     
		
		@Override
		public Object getGroup(int groupPosition)
		{
			Log.i("Parent", groupPosition+"=  getGroup ");
			
			return parents.get(groupPosition);
		}

		@Override
		public int getGroupCount()
		{
			return parents.size();
		}

		//Call when parent row clicked
		@Override
		public long getGroupId(int groupPosition)
		{
			//Log.i("Parent", groupPosition+"=  getGroupId "+ParentClickStatus);
			
			//ParentClickStatus=groupPosition;
			//if(ParentClickStatus==0)
			//	ParentClickStatus=-1;
			
			return groupPosition;
		}

		@Override
		public void notifyDataSetChanged()
		{
			// Refresh List rows
			super.notifyDataSetChanged();
		}

		@Override
		public boolean isEmpty()
		{
			return ((parents == null) || parents.isEmpty());
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition)
		{
			return true;
		}

		@Override
		public boolean hasStableIds()
		{
			return true;
		}

		@Override
		public boolean areAllItemsEnabled()
		{
			return true;
		}
		
		private final class CheckUpdateListener implements OnCheckedChangeListener
		{
			private final AdapterChild child;
			
			private CheckUpdateListener(AdapterChild child)
			{
				this.child = child;
			}
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				child.setChecked(isChecked);
				notifyDataSetChanged();
				
				final Boolean checked = child.isChecked();
			}
		}

	}