package info.basic.hsdf;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nitesh on 8/5/16.
 */
public class InformationHomeAdapter extends RecyclerView.Adapter<InformationHomeAdapter.InfoamationViewHolder> {
    public static class InfoamationViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView infoText;
        ImageView infoPhoto;

        InfoamationViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            infoText = (TextView)itemView.findViewById(R.id.info_text);
            infoPhoto = (ImageView)itemView.findViewById(R.id.info_photo);
        }

    }
    List<InformationHome> informationHomeList;

    InformationHomeAdapter(List<InformationHome> informationHomeList){
        this.informationHomeList = informationHomeList;
    }
    @Override
    public int getItemCount() {
        return informationHomeList.size();
    }
    @Override
    public InfoamationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.information_home_cardview, viewGroup, false);
        InfoamationViewHolder ivh = new InfoamationViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(InfoamationViewHolder infoamationViewHolder, int i) {
        infoamationViewHolder.infoText.setText(informationHomeList.get(i).heading);
        infoamationViewHolder.infoPhoto.setImageResource(informationHomeList.get(i).imageId);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
