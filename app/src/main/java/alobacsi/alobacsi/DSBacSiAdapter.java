package alobacsi.alobacsi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import alobacsi.alobacsi.DTO.BacSi;

/**
 * Created by lequa on 22/11/2017.
 */

public class DSBacSiAdapter  extends BaseAdapter {

    private List<BacSi> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public DSBacSiAdapter(Context aContext,  List<BacSi> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_ds_bac_si, null);
            holder = new ViewHolder();
            holder.imgBacSi = (ImageView) convertView.findViewById(R.id.imgBacSi);
            holder.tvBacSi = (TextView) convertView.findViewById(R.id.tvBacSi);
            holder.soSao1=(ImageView)convertView.findViewById(R.id.soSao1);
            holder.soSao2=(ImageView)convertView.findViewById(R.id.soSao2);
            holder.soSao3=(ImageView)convertView.findViewById(R.id.soSao3);
            holder.soSao4=(ImageView)convertView.findViewById(R.id.soSao4);
            holder.soSao5=(ImageView)convertView.findViewById(R.id.soSao5);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        BacSi bacSi = this.listData.get(position);
        holder.tvBacSi.setText(bacSi.getTenBacSi());
        int imageId = this.getMipmapResIdByName(bacSi.getTenAnh());

        holder.imgBacSi.setImageResource(imageId);

        ImageView[] tmp={holder.soSao1,holder.soSao2,holder.soSao3,holder.soSao4,holder.soSao5};
        for(int i=0;i<bacSi.getSoSao();i++) {
            tmp[i].setImageResource(this.getMipmapResIdByName("ic_star_full"));
        }

        return convertView;
    }

    // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView imgBacSi;
        TextView tvBacSi;
        ImageView soSao1;
        ImageView soSao2;
        ImageView soSao3;
        ImageView soSao4;
        ImageView soSao5;
    }

}