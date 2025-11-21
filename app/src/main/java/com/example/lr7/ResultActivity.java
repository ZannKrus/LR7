package com.example.lr7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    ImageView resultImage;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultImage = findViewById(R.id.resultImage);
        resultText = findViewById(R.id.resultText);

        String qrCode = getIntent().getStringExtra("QR_RESULT");

        if (qrCode != null) {
            updateUI(qrCode);
        }
    }

    private void updateUI(String code) {
        resultImage.setColorFilter(null);

        switch (code.toLowerCase().trim()) {
            case "bread":
                resultImage.setImageResource(R.drawable.bread);
                resultText.setText(R.string.text_bread);
                break;
            case "milk":
                resultImage.setImageResource(R.drawable.milk);
                resultText.setText(R.string.text_milk);
                break;
            case "chocolate":
                resultImage.setImageResource(R.drawable.chocolate);
                resultText.setText(R.string.text_chocolate);
                break;
            default:
                resultImage.setImageResource(android.R.drawable.ic_dialog_alert);
                resultImage.setColorFilter(android.graphics.Color.RED);

                resultText.setText("Неизвестный товар:\n" + code);
                break;
        }
    }
}