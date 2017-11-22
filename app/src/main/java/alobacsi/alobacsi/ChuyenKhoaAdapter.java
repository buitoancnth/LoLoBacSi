package alobacsi.alobacsi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import alobacsi.alobacsi.DTO.ChuyenKhoa;

public class ChuyenKhoaAdapter extends RecyclerView.Adapter<ChuyenKhoaAdapter.ViewHolder> {

    private List<ChuyenKhoa> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;

    // data is passed into the constructor
    ChuyenKhoaAdapter(Context context, List<ChuyenKhoa> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context=context;
    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_chuyen_khoa, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChuyenKhoa chuyenKhoa = mData.get(position);

        int imageId = this.getMipmapResIdByName(chuyenKhoa.getTenAnh());
        holder.imgChuyenKhoa.setImageResource(imageId);
        holder.tvChuyenKhoa.setText(chuyenKhoa.getTenChuyenKhoa());

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgChuyenKhoa;
        TextView tvChuyenKhoa;

        ViewHolder(View itemView) {
            super(itemView);
            imgChuyenKhoa = (ImageView) itemView.findViewById(R.id.imgChuyenKhoa);
            tvChuyenKhoa = (TextView) itemView.findViewById(R.id.tvChuyenKhoa);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Object getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
}