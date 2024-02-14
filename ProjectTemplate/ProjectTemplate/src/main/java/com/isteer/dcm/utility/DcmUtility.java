package com.isteer.dcm.utility;

import com.isteer.dcm.model.Status;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DcmUtility {
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

    public String ZipFile() throws IOException {
        String file1 = "D:\\business-financial-data-september-2023-quarter.csv";
        String file2 = "D:\\machine-readable-business-employment-data-sep-2023-quarter.csv";
        final List<String> srcFiles = Arrays.asList(file1, file2);

        final FileOutputStream fos = new FileOutputStream(Paths.get(file1).getParent().toAbsolutePath() + "/SpringBootCompressed.7z");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }

        zipOut.close();
        fos.close();
        return null;
    }


    public Status sendEmail(String toEmail, String subject, String body) {

        String MAIL_SMTP_HOST = "mail.smtp.host";
        String MAIL_SMTP_PORT = "mail.smtp.port";
        String MAIL_SMTP_AUTH = "mail.smtp.auth";
        String MAIL_SMTP_SOCKETFACTORY_CLASS = "mail.smtp.socketFactory.class";
        String MAIL_SMTP_SOCKETFACTORY_FALLBACK = "mail.smtp.socketFactory.fallback";
        String JAVAX_NET_SSLFACTORY = "javax.net.ssl.SSLSocketFactory";

        try {
            java.util.Properties mailProperties = System.getProperties();

            mailProperties.setProperty(MAIL_SMTP_HOST, "smtp.gmail.com");
            mailProperties.setProperty(MAIL_SMTP_PORT, "465");
            mailProperties.setProperty(MAIL_SMTP_AUTH, "true");
            mailProperties.setProperty("mail.smtp.ssl.enable", "true");
            mailProperties.setProperty(MAIL_SMTP_SOCKETFACTORY_CLASS, JAVAX_NET_SSLFACTORY);
            mailProperties.setProperty(MAIL_SMTP_SOCKETFACTORY_FALLBACK, "true");
            mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");

            Session session = Session.getInstance(mailProperties, new javax.mail.Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("jeevan.sy@isteer.com", "ywugkmznysyzfboz");
                }
            });

            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setContent(body, "text/html");

            Transport.send(message);
            return new Status(1, "Message sent successfully");
        } catch (Exception e) {
            System.out.println(e);
            return new Status(0, "Error while sending email");
        }
    }

    public class TransactionIdGenerator {

        public String generateTransactionId() {
            // Get process ID
            String processId = getProcessId();

            // Get current date and time in the specified format
            String dateTime = getCurrentDateTime();

            // Combine process ID and datetime to form the transaction ID
            String transactionId = processId + dateTime;
            return transactionId;

        }

        private String getProcessId() {

            // Get process ID
            String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
            long processId = Long.parseLong(processName.split("@")[0]);
            return String.valueOf(processId);
        }

        private String getCurrentDateTime() {
            // Get current date and time in the specified format
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmssSSS");
            return dateFormat.format(new Date());
        }
    }


}