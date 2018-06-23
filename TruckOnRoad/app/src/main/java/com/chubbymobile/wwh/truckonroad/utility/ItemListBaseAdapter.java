package com.chubbymobile.wwh.truckonroad.utility;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.chubbymobile.wwh.truckonroad.R;
import com.chubbymobile.wwh.truckonroad.bean.Parts;

public class ItemListBaseAdapter extends BaseAdapter implements SelectedIndex{
    private static ArrayList<Parts> itemDetailsrrayList;

    private Integer[] imgid = {
            R.drawable.truckt1,
            R.drawable.truckt2,
            R.drawable.truckt3,
            R.drawable.truckt4,
            R.drawable.truckt5,
            R.drawable.truckt5
    };

    private LayoutInflater l_Inflater;

    public ItemListBaseAdapter(Context context, ArrayList<Parts> results) {
        itemDetailsrrayList = results;
        l_Inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return itemDetailsrrayList.size();
    }

    public Object getItem(int position) {
        return itemDetailsrrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = l_Inflater.inflate(R.layout.part_detail_view, null);
            holder = new ViewHolder();
            holder.txt_itemName = convertView.findViewById(R.id.name);
            holder.txt_itemDescription = convertView.findViewById(R.id.itemDescription);
            holder.txt_itemPrice = convertView.findViewById(R.id.price);
            holder.itemImage = convertView.findViewById(R.id.photo);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_itemName.setText(itemDetailsrrayList.get(position).getName());
        holder.txt_itemDescription.setText(itemDetailsrrayList.get(position).getItemDescription());
        holder.txt_itemPrice.setText(itemDetailsrrayList.get(position).getPrice());
        holder.itemImage.setImageResource(imgid[itemDetailsrrayList.get(position).getImageNumber() - 1]);

        holder.mRadioButton = convertView.findViewById(R.id.list_item_check_button);
        holder.mRadioButton.setChecked(itemDetailsrrayList.get(position).isSelected());

        return convertView;
    }

    @Override
    public void setSelectedIndex(int position) {
        if (itemDetailsrrayList.get(position).isSelected()) {
            itemDetailsrrayList.get(position).setSelected(false);
        } else {
            itemDetailsrrayList.get(position).setSelected(true);
        }
    }

    static class ViewHolder {
        TextView txt_itemName;
        TextView txt_itemDescription;
        TextView txt_itemPrice;
        ImageView itemImage;
        RadioButton mRadioButton;
    }
}
