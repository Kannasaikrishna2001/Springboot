package com.isteer.dcm.utility;

import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.entity.DcmUsers;
import com.isteer.dcm.model.Status;
import com.isteer.dcm.service.OnstartupDataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
* Author: Jeevan,Amarnath, Nasir
* this class provides the utility methods for sending email, generating transaction id, trimming stack trace
* create a seven zip file etc*/


@Component
public class DcmUtility {

    @Autowired
    OnstartupDataInitializer onstartupDataInitializer;

    @Value("$(smtp.server.username)")
    private String username;

    @Value("$(smtp.server.password)")
    private String password;

    @Value("$(smtp.server.hostname)")
    private String hostname;

    @Value("$(smtp.server.port)")
    private String port;

    @Value("$(smtp.server.ssl.protocols)")
    private String sslProtocol;

    @Value("$(smtp.applicaton.content.type)")
    private String contentType;
public void demoMethod(){
   List<DcmUsers> usersList= onstartupDataInitializer.getDcmUsersList();
    Optional<DcmUsers> userData = usersList.stream().filter(p->p.getUserid()==2).findAny();
    DcmUsers dcmUser=userData.get();
  String email=  dcmUser.getUseremail();
}
    public static String getStacktraceSubString(String stackTrace) {
        String[] words = stackTrace.split("\\s+");
        StringBuilder result = new StringBuilder();
        int wordCount = 0;
        for (String word : words) {
            if (wordCount >= 1000) {
                break;
            }
            result.append(word).append(" ");
            wordCount++;
        }
        return result.toString().trim();
    }

    public String createSevenZipFile(String sevenZipFilePath, File fileToZip) throws IOException {
        String outputSevenZipFile = Paths.get(sevenZipFilePath) + fileToZip.getName().replace(".csv", getCurrentDateTime() + ".7z");
        final FileOutputStream fos = new FileOutputStream(outputSevenZipFile);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
        zipOut.close();
        fos.close();
        return outputSevenZipFile;
    }

    public Status sendEmail(String toEmail, String subject, String body) {
        try {
            java.util.Properties mailProperties = System.getProperties();

            mailProperties.setProperty(DCMConstants.MAIL_SMTP_HOST, hostname);
            mailProperties.setProperty(DCMConstants.MAIL_SMTP_PORT, port);
            mailProperties.setProperty(DCMConstants.MAIL_SMTP_AUTH, "true");
            mailProperties.setProperty("mail.smtp.ssl.enable", "true");
            mailProperties.setProperty(DCMConstants.MAIL_SMTP_SOCKETFACTORY_CLASS, DCMConstants.JAVAX_NET_SSLFACTORY);
            mailProperties.setProperty(DCMConstants.MAIL_SMTP_SOCKETFACTORY_FALLBACK, "true");
            mailProperties.put("mail.smtp.ssl.protocols", sslProtocol);

            Session session = Session.getInstance(mailProperties, new javax.mail.Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setContent(body, contentType);

            Transport.send(message);
            return new Status(1, DCMConstants.EMAIL_SUCCESS_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
            return new Status(0, DCMConstants.EMAIL_ERROR_MESSAGE);
        }
    }


    public String generateTransactionId() {
        return getProcessId() + "_" + getCurrentDateTime();
    }

    private String getProcessId() {
        String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        long processId = Long.parseLong(processName.split("@")[0]);
        return String.valueOf(processId);
    }

    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmssSSS");
        return dateFormat.format(new Date());
    }
}