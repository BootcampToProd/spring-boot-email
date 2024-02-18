package com.bootcamptoprod.springbootemail.model;

import java.util.List;

public class EmailRequest {

    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String text;
    private String attachmentPath;
    private List<String> inlineImagesPath;
    private List<List<String>> tableData;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public List<String> getInlineImagesPath() {
        return inlineImagesPath;
    }

    public void setInlineImagesPath(List<String> inlineImagesPath) {
        this.inlineImagesPath = inlineImagesPath;
    }

    public List<List<String>> getTableData() {
        return tableData;
    }

    public void setTableData(List<List<String>> tableData) {
        this.tableData = tableData;
    }
}
