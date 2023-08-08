package com.example.cardqr.model;

public class Card {
    int id;
    String nameCard;
    String department;
    String company;
    String imgAvatar;
    String email;
    String phoneNumber;
    String webSite;
    String address;
    String facebook;
    String linkin;
    String instagram;

    public Card(int id, String nameCard, String department, String company, String imgAvatar,
                String email, String phoneNumber, String webSite, String address, String facebook,
                String linkin, String instagram) {
        this.id = id;
        this.nameCard = nameCard;
        this.department = department;
        this.company = company;
        this.imgAvatar = imgAvatar;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.webSite = webSite;
        this.address = address;
        this.facebook = facebook;
        this.linkin = linkin;
        this.instagram = instagram;
    }

    public Card(int id, String nameCard, String imgAvatar, String email) {
        this.id = id;
        this.nameCard = nameCard;
        this.imgAvatar = imgAvatar;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkin() {
        return linkin;
    }

    public void setLinkin(String linkin) {
        this.linkin = linkin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
