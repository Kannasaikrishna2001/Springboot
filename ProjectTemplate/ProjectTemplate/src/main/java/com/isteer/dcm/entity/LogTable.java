package com.isteer.dcm.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "LOGDATA")
public class LogTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    @Column(name="TRANSACTIOINID")
    private String transactioinID;

    @Column(name="COMPONENTNAME")
    private String componentName;

    @Column(name="TRANSACTIONDATA")
    private String trancationData;

    @Column(name="TRANSACTIONTIME")
    private String transactionTime;

    @Column(name="TRANSACTIONTYPE")
    private String transactionType;

    @Column(name="STATUS")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactioinID() {
        return transactioinID;
    }

    public void setTransactioinID(String transactioinID) {
        this.transactioinID = transactioinID;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getTrancationData() {
        return trancationData;
    }

    public void setTrancationData(String trancationData) {
        this.trancationData = trancationData;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LogTable{" +
                "id=" + id +
                ", transactioinID='" + transactioinID + '\'' +
                ", componentName='" + componentName + '\'' +
                ", trancationData='" + trancationData + '\'' +
                ", transactionTime='" + transactionTime + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public LogTable() {
    }

    public LogTable( String transactioinID, String componentName, String trancationData, String transactionTime, String transactionType, String status) {
        this.transactioinID = transactioinID;
        this.componentName = componentName;
        this.trancationData = trancationData;
        this.transactionTime = transactionTime;
        this.transactionType = transactionType;
        this.status = status;
    }
}
