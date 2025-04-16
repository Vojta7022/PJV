/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2023 Apryse Group NV
    Authors: Apryse Software.

    For more information, please contact iText Software at this address:
    sales@itextpdf.com
 */
package cz.cvut.fel.pjv;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFontFactory.EmbeddingStrategy;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;

public class CzechExample {
    public static final String DEST = "./results/chapter02/czech_example.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new CzechExample().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        // "Č,Ć,Š,Ž,Đ"
        Paragraph p1 = new Paragraph("Testing of letters \u010c,\u0106,\u0160,\u017d,\u0110");
        doc.add(p1);


        // "Č,Ć,Š,Ž,Đ"
        Paragraph p2 = new Paragraph("Testing of letters \u010c,\u0106,\u0160,\u017d,\u0110");
        doc.add(p2);

        doc.close();
    }
}