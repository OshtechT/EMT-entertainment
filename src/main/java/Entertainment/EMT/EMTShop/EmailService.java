package Entertainment.EMT.EMTShop;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {


    private static JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender){
        this.emailSender = emailSender;
    }


     public static void notifyEmail(Orders order){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("emteventswebsite@gmail.com");
        message.setTo("to18574@essex.ac.uk");
        message.setText("Name: "+ order.Fname +" "+order.Lname+"\n Mobile: "+order.mobile+"\n E-mail: "+order.email+"\n Event: "+order.event+" \nOrder: x" +order.quantity+"  "+order.ticket+"\n TicketID: "+order.barcode);
        message.setSubject("New order from website");
        emailSender.send(message);
    }
    public static void orderEmail(Orders order) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("emteventswebsite@gmail.com");
        mimeMessageHelper.setTo(order.email);
        mimeMessageHelper.setText("Your Ticket is attatched below \nIf the ticket has not been attatched email us at:");
        mimeMessage.setSubject("Thank you for your Order!");
        String PDFpath = "src/main/resources/PDFs/"+order.barcode + ".pdf";

        FileSystemResource fileSystemResource = new FileSystemResource(new File(PDFpath));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);

        emailSender.send(mimeMessage);
        System.out.println(" PDF has been sent");
    }
    public static void PBEmail(PBForm form){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("emteventswebsite@gmail.com");
        message.setTo("to18574@essex.ac.uk");
        message.setText("Name: "+ form.name +" \n Mobile: "+form.mobile+"\n Email: "+form.email+" \nSubject: x" +form.subject+"\n message: "+form.info);
        message.setSubject("New query from website");
        emailSender.send(message);
    }
}
