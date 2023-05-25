package com.gga.vo;

public class MemberVo {
   String name, id, pass, cpass, gender, email1, email2, car1, tel, birth;
   String[] genre;
   String email, phone, genreList, carnum, mdate;
   int rno, car2;
   
   
   public String getBirth() {
      return birth;
   }
   public void setBirth(String birth) {
      this.birth = birth;
   }
   public  String getCpass() {
      return cpass;
   }
   public void setCpass(String cpass) {
      this.cpass = cpass;
   }
   public String getCar1() {
      return car1;
   }
   public void setCar1(String car1) {
      this.car1 = car1;
   }
   public int getCar2() {
      return car2;
   }
   public void setCar2(int car2) {
      this.car2 = car2;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPass() {
      return pass;
   }
   public void setPass(String pass) {
      this.pass = pass;
   }
   public String getGender() {
      return gender;
   }
   public void setGender(String gender) {
      this.gender = gender;
   }
   public String getEmail1() {
      return email1;
   }
   public void setEmail1(String email1) {
      this.email1 = email1;
   }
   public String getEmail2() {
      return email2;
   }
   public void setEmail2(String email2) {
      this.email2 = email2;
   }
   public String getCarnum() {
      if(car1 != null) {
         carnum = car1 + " " + car2;
      }
      return carnum;
   }
   public void setCarnum(String carnum) {
      this.carnum = carnum;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   
   public String[] getGenre() {
      return genre;
   }
   public void setGenre(String[] genre) {
      this.genre = genre;
   }
   public String getEmail() {
      if(email1 != null) {
         email = email1 + "@" + email2;
      }
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getGenreList() {
      if(genre != null) {
         genreList = String.join(", ", genre);
      }
      return genreList;
   }
   public void setGenreList(String genreList) {
      this.genreList = genreList;
   }
   public String getMdate() {
      return mdate;
   }
   public void setMdate(String mdate) {
      this.mdate = mdate;
   }
   public int getRno() {
      return rno;
   }
   public void setRno(int rno) {
      this.rno = rno;
   }
   
   
}