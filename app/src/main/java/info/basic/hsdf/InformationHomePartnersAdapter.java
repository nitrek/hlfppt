package info.basic.hsdf;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by nitesh on 8/5/16.
 */
public class InformationHomePartnersAdapter extends RecyclerView.Adapter<InformationHomePartnersAdapter.InfoamationViewHolder> {
    public static class InfoamationViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView infoPhoto;

        InfoamationViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.pcv);
            infoPhoto = (ImageView)itemView.findViewById(R.id.partners_photo);
        }

    }
    List<InformationHomePartner> informationHomeList;

    InformationHomePartnersAdapter(List<InformationHomePartner> informationHomeList){
        this.informationHomeList = informationHomeList;
    }
    @Override
    public int getItemCount() {
        return informationHomeList.size();
    }
    @Override
    public InfoamationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.partners_home, viewGroup, false);
        InfoamationViewHolder ivh = new InfoamationViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(InfoamationViewHolder infoamationViewHolder, final int i) {
        infoamationViewHolder.infoPhoto.setImageResource(informationHomeList.get(i).imageId);


    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
