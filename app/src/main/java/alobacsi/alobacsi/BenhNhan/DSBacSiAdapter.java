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

import alobacsi.alobacsi.DTO.BacSi;
import alobacsi.alobacsi.R;

/**
 * Created by lequa on 22/11/2017.
 */

public class DSBacSiAdapter extends RecyclerView.Adapter<DSBacSiAdapter.ViewHolder> {

    private List<BacSi> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;

    // data is passed into the constructor
    DSBacSiAdapter(Context context, List<BacSi> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context=context;
    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_ds_bac_si, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BacSi bacSi = mData.get(position);

        int imageId = this.getMipmapResIdByName(bacSi.getTenAnh());
        holder.imgBacSi.setImageResource(imageId);

        holder.tvBacSi.setText(bacSi.getTenBacSi());

        ImageView[] tmp={holder.soSao1,holder.soSao2,holder.soSao3,holder.soSao4,holder.soSao5};
        for(int i=0;i<bacSi.getSoSao();i++) {
            tmp[i].setImageResource(this.getMipmapResIdByName("ic_star_full"));
        }
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgBacSi;
        TextView tvBacSi;
        ImageView soSao1;
        ImageView soSao2;
        ImageView soSao3;
        ImageView soSao4;
        ImageView soSao5;

        ViewHolder(View itemView) {
            super(itemView);
            imgBacSi = (ImageView) itemView.findViewById(R.id.imgBacSi);
            tvBacSi = (TextView) itemView.findViewById(R.id.tvBacSi);
            soSao1 = (ImageView) itemView.findViewById(R.id.soSao1);
            soSao2 = (ImageView) itemView.findViewById(R.id.soSao2);
            soSao3 = (ImageView) itemView.findViewById(R.id.soSao3);
            soSao4 = (ImageView) itemView.findViewById(R.id.soSao4);
            soSao5 = (ImageView) itemView.findViewById(R.id.soSao5);
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