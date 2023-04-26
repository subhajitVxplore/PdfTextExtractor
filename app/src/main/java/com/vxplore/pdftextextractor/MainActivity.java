package com.vxplore.pdftextextractor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

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
            String extractedText = "";

            PdfReader reader = new PdfReader("res/raw/test_pdf.pdf");


            int n = reader.getNumberOfPages();

            // running a for loop to get the data from PDF
            // we are storing that data inside our string.
            for (int i = 0; i < n; i++) {
                extractedText = extractedText + PdfTextExtractor.getTextFromPage(reader, i + 1).trim() + "\n";
                // to extract the PDF content from the different pages
            }

            // after extracting all the data we are
            // setting that string value to our text view.
            extractedTV.setText(extractedText);

            // below line is used for closing reader.
            reader.close();
        } catch (Exception e) {
            // for handling error while extracting the text file.
            extractedTV.setText("Error found is : \n" + e);
        }
    }
}
