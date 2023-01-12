package com.finalexam_news.indonews.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import com.finalexam_news.indonews.R;
import com.google.android.material.card.MaterialCardView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*

    Topic       : Berita Terupdate bedasarkan kategori
    Name        : Fransiscus William Wong
    Purpose     : Menampilkan data-data berita terupdate beseerta dengan kategori headline,
                         teknologi, hingga strusny. Melalui Webview.

    */

    MaterialCardView cvHead, cvTechno, cvBusiness, cvEntertaiment;
    TextView tvToday;
    String today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvHead = findViewById(R.id.cardHeadLine);
        cvTechno = findViewById(R.id.cardTechno);
        cvBusiness = findViewById(R.id.cardBusiness);
        cvEntertaiment = findViewById(R.id.cardEnter);

        cvHead.setOnClickListener(this);
        cvTechno.setOnClickListener(this);
        cvBusiness.setOnClickListener(this);
        cvEntertaiment.setOnClickListener(this);

        tvToday = findViewById(R.id.tvDate);
        Date dateNow = Calendar.getInstance().getTime();
        today = (String) DateFormat.format("EEEE", dateNow);
        if (today.equalsIgnoreCase("sunday")) {
            today = "Minggu";
        } else if (today.equalsIgnoreCase("monday")) {
            today = "Senin";
        } else if (today.equalsIgnoreCase("tuesday")) {
            today = "Selasa";
        } else if (today.equalsIgnoreCase("wednesday")) {
            today = "Rabu";
        } else if (today.equalsIgnoreCase("thursday")) {
            today = "Kamis";
        } else if (today.equalsIgnoreCase("friday")) {
            today = "Jumat";
        } else if (today.equalsIgnoreCase("saturday")) {
            today = "Sabtu";
        }

        getToday();

    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String stdate = (String) DateFormat.format("d", date);
        String monthNumber = (String) DateFormat.format("M", date);
        String year = (String) DateFormat.format("yyyy", date);

        int month = Integer.parseInt(monthNumber);
        String stmonth = null;
        if (month == 1) {
            stmonth = "Januari";
        } else if (month == 2) {
            stmonth = "Februari";
        } else if (month == 3) {
            stmonth = "Maret";
        } else if (month == 4) {
            stmonth = "April";
        } else if (month == 5) {
            stmonth = "Mei";
        } else if (month == 6) {
            stmonth = "Juni";
        } else if (month == 7) {
            stmonth = "Juli";
        } else if (month == 8) {
            stmonth = "Agustus";
        } else if (month == 9) {
            stmonth = "September";
        } else if (month == 10) {
            stmonth = "Oktober";
        } else if (month == 11) {
            stmonth = "November";
        } else if (month == 12) {
            stmonth = "Desember";
        }
        String formatFix = today + ", " + stdate + " " + stmonth + " " + year;
        tvToday.setText(formatFix);
    }

    @Override
    public void onClick(View v) {
        // Akan melempar ke activity lain.
        if (v.getId() == R.id.cardHeadLine) {
            Intent intent = new Intent(MainActivity.this, HeadLineActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardTechno) {
            Intent intent = new Intent(MainActivity.this, TechnologyActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardBusiness) {
            Intent intent = new Intent(MainActivity.this, BusinessActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cardEnter) {
            Intent intent = new Intent(MainActivity.this, EntertaimentActivity.class);
            startActivity(intent);
        }
    }
}