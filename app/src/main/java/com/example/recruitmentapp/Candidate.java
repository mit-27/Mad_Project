package com.example.recruitmentapp;

public class Candidate {
    String Name,Email,Gender,Jobtitle,Phone,Source,Status,cid;
    boolean Interview_status;

    public Candidate(String name, String email, String gender, String jobtitle, String phone, String source, String status, String cid, boolean interview_status) {
        Name = name;
        Email = email;
        Gender = gender;
        Jobtitle = jobtitle;
        Phone = phone;
        Source = source;
        Status = status;
        this.cid = cid;
        Interview_status = interview_status;
    }

    public Candidate()
    {

    }

    public Candidate(String name, String email, String jobtitle, String phone, String cid) {
        Name = name;
        Email = email;
        Jobtitle = jobtitle;
        Phone = phone;
        this.cid = cid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getJobtitle() {
        return Jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        Jobtitle = jobtitle;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public boolean isInterview_status() {
        return Interview_status;
    }

    public void setInterview_status(boolean interview_status) {
        Interview_status = interview_status;
    }
}
