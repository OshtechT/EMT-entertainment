package Entertainment.EMT.EMTShop;

import java.io.*;
import java.util.List;

import com.itextpdf.io.image.*;
import com.itextpdf.io.image.ImageData; 
import com.itextpdf.io.image.ImageDataFactory; 
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.font.constants.FontWeights;

import com.itextpdf.kernel.pdf.*; 
import com.itextpdf.kernel.geom.Rectangle; 
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.font.PdfFontFactory; 
import com.itextpdf.kernel.font.PdfFont; 

import com.itextpdf.layout.Document; 
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
    public class createPDF{


     public  void  CreatePDF(String orderID, Integer random, Ticket t, Event e,String customer) throws Exception   {

      // Creating a PdfWriter
      String code = Integer.toString(random);
      String dest =  "src/main/resources/PDFs/"+code + ".pdf";
      PdfWriter writer = new PdfWriter(dest);

      String barcodePath= "src/main/resources/barcodes/"+ code +".png";
      GenerateQRCode g= new GenerateQRCode();
      g.generateQRcode(code);
      // Creating a PdfDocument
      PdfDocument pdf = new PdfDocument(writer);
      // Creating a Document
      Document document = new Document(pdf);
      // Creating a PdfCanvas object
      // Creating a new page
      PdfPage pdfPage = pdf.addNewPage();

      PdfCanvas canvas = new PdfCanvas(pdfPage);
       // Setting color to the rectangle
      Color color = ColorConstants.BLACK;       
      canvas.setColor(color, true);              
      
      // creating a rectangle
      canvas.rectangle(10, 10,600,200 );
        
      // Creating Paragraphs       
      Text para1 = new Text("EMT Entertainment Presents: "+ e.title +"!");
      
      Text para2 = new Text( t.type + "   £"+ t.price + "\n Ordered By: " + customer +" \n Enter Before " + t.entry);
      Text para3 = new Text(e.location +", " + e.postcode +"\n "+ e.date + " \n Order ID: "+ orderID);
      Text para4 = new Text("Permits 1 x Person(s)");

      // Setting font of the text       
      PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);       
      PdfFont font2 = PdfFontFactory.createFont(StandardFonts.HELVETICA);       
      para1.setFont(font);
      para1.setFontSize(17);   

      para2.setFont(font);
      para2.setFontSize(15);
      
      para3.setFont(font2);
      para4.setFont(font2);
      
      Paragraph paragraph1 = new Paragraph(para1);
      Paragraph paragraph2 = new Paragraph(para2);
      Paragraph paragraph3 = new Paragraph(para3);
      Paragraph paragraph4 = new Paragraph(para4);
      
       // Setting the position of the paragraph to the page
      paragraph1.setMarginLeft(10);
      paragraph1.setMarginTop(160);
     
      paragraph2.setMarginLeft(10);
      paragraph2.setMarginTop(30);

      paragraph3.setMarginLeft(20);
      paragraph3.setMarginTop(50);
   
      paragraph4.setMarginLeft(20);
      paragraph4.setMarginTop(60);



      // Creating an ImageData object       
      String imFile = "src/main/resources/static/images/EMTLogo.jpeg";
      String imFile2 = "src/main/resources/static/images/"+ e.title + ".jpg";
      String imFile3 =  barcodePath;
      ImageData data = ImageDataFactory.create(imFile);              
      ImageData data2 = ImageDataFactory.create(imFile2);              
      ImageData data3 = ImageDataFactory.create(imFile3);              
      
      // Creating an Image object        
      Image image = new Image(data);
      Image image2 = new Image(data2);
      Image image3 = new Image(data3);
       // Setting the position of the image to the center of the page
      image.setFixedPosition(250, 700);
      image.setHeight(100);
      image.setWidth(100);


       
      image2.setFixedPosition(425, 500);
      image2.setHeight(150);                                      
      image2.setWidth(100);                 

      // Creating Barcode
       image3.setFixedPosition(400, 300);
       image3.setHeight(150);
       image3.setWidth(150);
     
      
      // Adding paragraphs to document       
      document.add(paragraph1);       
      document.add(paragraph2);       
      document.add(paragraph3);       
      document.add(paragraph4);       
      
      // Adding image to the document    
         
      document.add(image);              
      document.add(image2);              
      document.add(image3);              
      
      // Closing the document       
      document.close();              
      
      System.out.println("Image added"); 
     }
    }
