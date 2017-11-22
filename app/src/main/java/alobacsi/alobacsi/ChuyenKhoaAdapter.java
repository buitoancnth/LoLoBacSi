package alobacsi.alobacsi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import alobacsi.alobacsi.DTO.ChuyenKhoa;

/**
 * Created by lequa on 22/11/2017.
 */

public class ChuyenKhoaAdapter  extends BaseAdapter {

    private List<ChuyenKhoa> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ChuyenKhoaAdapter(Context aContext,  List<ChuyenKhoa> listData) {
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
            convertView = layoutInflater.inflate(R.layout.item_chuyen_khoa, null);
            holder = new ViewHolder();
            holder.imgChuyenKhoa = (ImageView) convertView.findViewById(R.id.imgChuyenKhoa);
            holder.tvChuyenKhoa = (TextView) convertView.findViewById(R.id.tvChuyenKhoa);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ChuyenKhoa chuyenKhoa = this.listData.get(position);
        holder.tvChuyenKhoa.setText(chuyenKhoa.getTenChuyenKhoa());
        int imageId = this.getMipmapResIdByName(chuyenKhoa.getTenAnh());

        holder.imgChuyenKhoa.setImageResource(imageId);

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
        ImageView imgChuyenKhoa;
        TextView tvChuyenKhoa;
    }

}