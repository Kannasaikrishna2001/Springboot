package com.isteer.dcm.constants;

public interface DCMConstants {
    String SUCCESS = "200";
    String BAD_REQUEST = "400";
    String Unauthorized="401";
    String Forbidden = "403";
    String NOT_FOUND = "404";
    String Method_Not_Allowed = "405";
    String INTERNAL_SERVER_ERROR = "500";
    String ORDERSTATUS_PLACED="PLACED";
    String ORDERSTATUS_INPROGRESS="INPROGRESS";
    String ORDERSTATUS_SHIPPED="SHIPPED";
    String ORDERSTATUS_COMPLETED="COMPLETED";
    String ORDERSTATUS_NEW="NEW";
    String ORDER_MSG_SUCCESS="ORDER PLACED SUCCESSFULLY";
    String ORDER_REQUEST="Received place order request:";
    String INSUFFICIENT_INVENTORY="Inventory size not sufficient for order";
    String PRODUCT_NOT_FOUND="Product not found";
    String MAIL_SMTP_HOST = "mail.smtp.host";
    String MAIL_SMTP_PORT = "mail.smtp.port";
    String MAIL_SMTP_AUTH = "mail.smtp.auth";
    String MAIL_SMTP_SOCKETFACTORY_CLASS = "mail.smtp.socketFactory.class";
    String MAIL_SMTP_SOCKETFACTORY_FALLBACK = "mail.smtp.socketFactory.fallback";
    String JAVAX_NET_SSLFACTORY = "javax.net.ssl.SSLSocketFactory";
    String EMAIL_SUCCESS_MESSAGE="Message sent successfully";
    String EMAIL_ERROR_MESSAGE="Error while sending email";
    String VALID_REGION_AND_STORE="VALID";

    String NO_UPCS_FOUND="NO UPCS FOUND FOR THIS MANUFACTURER";
    String INVALID_REGION_AND_STORE="INVALID";
    String FAILURE ="Failure" ;
    String VALID_MANUFACTURER="Valid Manufacturer";
    String INVALID_MANUFACTURER="Invalid Manufacurer";
    String ACCESS_DENIED="Access Denied";
    String ROLE_NOT_FOUND="Role not found";
    String ORDERSTATUS_ERROR = "Error while placing the order: ";
    String INVALID_USER="INVALID USER";
    String NO_DATA_FOUND="NO DATA FOUND";
    String SUCCESS_RESP_MSG="SUCCESS";
    String USER_MANUFACTURER="MANUFACTURER";
}
