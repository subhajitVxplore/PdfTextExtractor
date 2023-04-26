package com.vxplore.pdftextextractor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // creating variables for
    // button and text view.
    private Button extractPDFBtn;
    private TextView extractedTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing variables for button and text view.
        extractedTV = findViewById(R.id.idPDFTV);
        extractPDFBtn = findViewById(R.id.idBtnExtract);

        // adding on click listener for button
        extractPDFBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling method to extract
                // data from PDF file.
                extractPDF();
            }
        });
    }

    private void extractPDF() {
        try {
            String extractedText = "        ";
            PdfReader reader = new PdfReader("res/raw/test_pdf.pdf");
            int n = reader.getNumberOfPages();
            for (int i = 0; i < n; i++) {

                extractedText = extractedText + PdfTextExtractor.getTextFromPage(reader, i + 1).trim() + "\n";
            }


 //-------------------------------

//            String myArray[] = extractedText.split("\n");
//            List myList = new ArrayList();
//            Collections.addAll(myList, myArray);

 //-------------------------------
            extractedTV.setText(extractedText);



            reader.close();
        } catch (Exception e) {
            extractedTV.setText("Error found is : \n" + e);
        }
    }
}
