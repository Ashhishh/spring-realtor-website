package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "pg")
public class Pg {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
		@Column(name = "city")
	    @NotEmpty(message = "*select city")
	    private String city;
		@Column(name = "place")
	    @NotEmpty(message = "*select place")
	    private String place;
	    @Column(name = "home_type")
	    @NotEmpty(message = "*Please select Home type")
	    private String home_type;
	    @Column(name = "sq_ft")
	    @NotEmpty(message = "*Please enter area of the property in Sq_ft")
	    private String sq_ft;
		@Column(name = "is_sharing")
	    @NotEmpty(message = "*select sharing type")
	    private String is_sharing;
	    @Column(name = "no_of_bhk")
	    @NotEmpty(message = "*select no of bhk")
	    private String no_of_bhk;
	    @Column(name = "price")
	    @NotEmpty(message = "*enter the Price of property")
	    private String price;
//	    @ManyToOne
//	    @JoinColumn
//	    private User user;
		public String getIs_sharing() {
			return is_sharing;
		}
		public void setIs_sharing(String is_sharing) {
			this.is_sharing = is_sharing;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPlace() {
			return place;
		}
		public void setPlace(String place) {
			this.place = place;
		}
		public String getHome_type() {
			return home_type;
		}
		public void setHome_type(String home_type) {
			this.home_type = home_type;
		}
		public String getNo_of_bhk() {
			return no_of_bhk;
		}
		public void setNo_of_bhk(String no_of_bhk) {
			this.no_of_bhk = no_of_bhk;
		}
		public String getSq_ft() {
			return sq_ft;
		}
		public void setSq_ft(String sq_ft) {
			this.sq_ft = sq_ft;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}

}
