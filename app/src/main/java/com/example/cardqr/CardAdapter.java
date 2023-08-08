package com.example.cardqr;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardqr.model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private Context context ;

    public CardAdapter(Context context) {
        this.context = context;
    }
    List<Card> cardList = new ArrayList<>();

    public interface OnItemClickListener {
        void onItemClick(Card card);
    }

    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_qr, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card = cardList.get(position);
        if(card == null){
            return;
        }
        holder.onBindData(card);
    }

    @Override
    public int getItemCount() {
        if(cardList != null){
            return cardList.size();
        }
        return 0;
    }

    public void setData(List<Card> List){
        this.cardList = List;

        notifyDataSetChanged();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        TextView tvNameCard, tvDepartment, tvCompany, tvEmail, tvPhoneNumber, tvWebSite, tvAddress,
                tvFaceBook, tvLinkIn, tvInstagram, tvGithub;
        ImageView ivAvatar;

        public CardViewHolder(@NonNull View itemCard){
            super(itemCard);

            tvNameCard = itemView.findViewById(R.id.tv_name_card);
            tvDepartment = itemView.findViewById(R.id.tv_department);
            tvCompany = itemView.findViewById(R.id.tv_company);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvPhoneNumber = itemView.findViewById(R.id.tv_phone);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvWebSite = itemView.findViewById(R.id.tv_website);
            tvFaceBook = itemView.findViewById(R.id.tv_fb);
            tvInstagram = itemView.findViewById(R.id.tv_instagram);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvLinkIn = itemView.findViewById(R.id.tv_linkin);

        }
        public void onBindData(Card card){
            ivAvatar.setImageURI(Uri.parse(card.getImgAvatar()));
            tvNameCard.setText(card.getNameCard()+"");
            tvDepartment.setText(card.getDepartment());
            tvCompany.setText(card.getCompany());
            tvEmail.setText(card.getEmail());
            tvPhoneNumber.setText(card.getPhoneNumber());
            tvAddress.setText(card.getAddress());
            tvWebSite.setText(card.getWebSite());
            tvFaceBook.setText(card.getFacebook());
            tvInstagram.setText(card.getInstagram());
            tvLinkIn.setText(card.getLinkin());

            setBgr();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dia = new AlertDialog.Builder(v.getContext());
                    dia.setTitle("Dialog Fragment");
                    dia.setIcon(R.drawable.ic_scan_qr);
                    dia.setMessage("ID" + card.getNameCard() + ": " + card.getEmail() + ", "
                            + card.getPhoneNumber());

                    dia.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    dia.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(dia.getContext(), "ok", Toast.LENGTH_SHORT).show();
                        }
                    });

                    dia.show();

                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(card);
                    }
                }
            });
        }

        private void setBgr(){
            itemView.setBackgroundResource(R.drawable.bg_white_corner10);
        }
    }
}
