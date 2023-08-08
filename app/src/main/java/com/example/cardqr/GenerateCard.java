package com.example.cardqr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateCard extends AppCompatActivity {

    EditText edt_link;
    Button btn_generate;
    ImageView iv_qr_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_card);

        edt_link = findViewById(R.id.edt_link);
        btn_generate = findViewById(R.id.btn_generate);
        iv_qr_code = findViewById(R.id.iv_qr_code);

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(edt_link.getText().toString(), BarcodeFormat.QR_CODE, 800, 800);

                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                    iv_qr_code.setImageBitmap(bitmap);

                }
                catch (Exception e){
                    throw new RuntimeException();
                }
            }
        });
    }
}