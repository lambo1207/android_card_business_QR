package com.example.cardqr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cardqr.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView ivScan, ivNewCard;
    RecyclerView rvCards;
    List<Card> listCard = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivScan = findViewById(R.id.imgv_scan_qr);
        ivNewCard = findViewById(R.id.iv_new_card);
        rvCards = findViewById(R.id.rv_card_qr);

        ivScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scanIntent = new Intent(getApplicationContext(), ScanCard.class);
                startActivity(scanIntent);
            }
        });

        ivNewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newCardIntent = new Intent(getApplicationContext(), GenerateCard.class);
                startActivity(newCardIntent);
            }
        });

        CardAdapter cardAdapter = new CardAdapter(getApplicationContext());
        cardAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Card card) {
                Intent newIntent = new Intent(getApplicationContext(), DetailScreen.class);
                newIntent.putExtra("card", (CharSequence) card); // Truyền thông tin thẻ đã nhấn vào activity DetailScreen
                startActivity(newIntent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        rvCards.setLayoutManager(linearLayoutManager);

        listCard = getData(listCard, getApplicationContext());
        cardAdapter.setData(listCard);
        rvCards.setAdapter(cardAdapter);
        cardAdapter.notifyDataSetChanged();
    }

    public List<Card> getData(List<Card> itemList, Context context) {

        List<Card> cardListGet = new ArrayList<>();

        Random random = new Random();
        int[] imgInt = {R.drawable.ava01, R.drawable.ava02, R.drawable.ava03, R.drawable.ava04,
                R.drawable.ava05, R.drawable.ava06, R.drawable.ava07};
        String[] imgString = new String[imgInt.length];
        String imgParse;
        for (int i = 0; i < imgInt.length; i++) {
            imgParse = "android.resource://" + context.getPackageName() + "/" + imgInt[i];
            imgString[i] = imgParse;
        }
        String[] nameCard = {"Iphone 11", "Iphone 12 Pro", "Iphone 13 ProMax", "Iphone 12 Mini", "Iphone 13 Mini", "Iphone 11 ProMax", "Iphone 14", "Iphone 14 Pro", "Iphone 14 ProMax", "Iphone 15"};
        String[] email = {"Iphone 11", "Iphone 12 Pro", "Iphone 13 ProMax", "Iphone 12 Mini", "Iphone 13 Mini", "Iphone 11 ProMax", "Iphone 14", "Iphone 14 Pro", "Iphone 14 ProMax", "Iphone 15"};

        for (int i = 1; i <= 10; i++){
            Card card = (new Card( i, nameCard[random.nextInt(nameCard.length)], imgString[random.nextInt(imgString.length)],  email[random.nextInt(email.length)]));
            cardListGet.add(card);
        }
        return cardListGet;
    }
}