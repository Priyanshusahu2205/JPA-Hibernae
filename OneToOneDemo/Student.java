package com.lmsInterview23i;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Student {
		
		@Id
		private int studid;
		private String studname;
		private String studaddress;
		@OneToOne(cascade=CascadeType.PERSIST)
		private SubjectS sub;
		
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Student(int studid, String studname, String studaddress, SubjectS sub) {
			super();
			this.studid = studid;
			this.studname = studname;
			this.studaddress = studaddress;
			this.sub = sub;
		}

		public int getStudid() {
			return studid;
		}

		public void setStudid(int studid) {
			this.studid = studid;
		}

		public String getStudname() {
			return studname;
		}

		public void setStudname(String studname) {
			this.studname = studname;
		}

		public String getStudaddress() {
			return studaddress;
		}

		public void setStudaddress(String studaddress) {
			this.studaddress = studaddress;
		}

		public SubjectS getSub() {
			return sub;
		}

		public void setSub(SubjectS sub) {
			this.sub = sub;
		}

		

}
