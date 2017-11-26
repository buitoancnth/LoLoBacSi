package alobacsi.alobacsi.BenhNhan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import alobacsi.alobacsi.DTO.HoiDap;
import alobacsi.alobacsi.R;

/**
 * Created by lequa on 26/11/2017.
 */

public class HoiDapAdapter extends RecyclerView.Adapter<HoiDapAdapter.ViewHolder> {
    private List<HoiDap> mData;
    private LayoutInflater mInflater;
    private HoiDapAdapter.ItemClickListener mClickListener;
    private Context context;

    // data is passed into the constructor
    HoiDapAdapter(Context context, List<HoiDap> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context=context;
    }

    // inflates the cell layout from xml when needed
    @Override
    public HoiDapAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_hoi_dap_cua_toi, parent, false);
        return new HoiDapAdapter.ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(HoiDapAdapter.ViewHolder holder, int position) {
        HoiDap hoiDap = mData.get(position);
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCauHoi;
        TextView tvDate;

        ViewHolder(View itemView) {
            super(itemView);
            tvCauHoi = (TextView) itemView.findViewById(R.id.tvBacSi);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
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
    void setClickListener(HoiDapAdapter.ItemClickListener itemClickListener) {
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
