package com.isteer.dcm.constants;

public interface DCMConstants {
    String SUCCESS = "200";
    String BAD_REQUEST = "400";
    String Unauthorized="401";
    String Forbidden = "403";
    String NOT_FOUND = "404";
    String Method_Not_Allowed = "405";
    String INTERNAL_SERVER_ERROR = "500";
    //String placed,String inprogress, String shipped
    String ORDERSTATUS_PLACED="PLACED";
    String ORDERSTATUS_INPROGRESS="INPROGRESS";
    String ORDERSTATUS_SHIPPED="SHIPPED";
    String ORDERSTATUS_COMPLETED="COMPLETED";
    String ORDERSTATUS_NEW="NEW";
}
