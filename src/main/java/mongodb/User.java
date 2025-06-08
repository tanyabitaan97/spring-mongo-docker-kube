package mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userregistrations")
public class User {
	
	    @Id
	    private String id;
	    
	    private String fullName;
	    
	    private double phoneNumber;
	    
	    private String emailId;
	    
	    private String organization;
	    
	    private String designation;
	    
	    private int phonePrefix;
	    
	    private String userType;
	    
	    private String userExchange;
	    
	    private String otherInterestType;
	    
	    private String userCommitment;
	    
	    private boolean isEnableCommunication;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public double getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(double phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getOrganization() {
			return organization;
		}

		public void setOrganization(String organization) {
			this.organization = organization;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public int getPhonePrefix() {
			return phonePrefix;
		}

		public void setPhonePrefix(int phonePrefix) {
			this.phonePrefix = phonePrefix;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		public String getUserExchange() {
			return userExchange;
		}

		public void setUserExchange(String userExchange) {
			this.userExchange = userExchange;
		}

		public String getOtherInterestType() {
			return otherInterestType;
		}

		public void setOtherInterestType(String otherInterestType) {
			this.otherInterestType = otherInterestType;
		}

		public String getUserCommitment() {
			return userCommitment;
		}

		public void setUserCommitment(String userCommitment) {
			this.userCommitment = userCommitment;
		}

		public boolean isEnableCommunication() {
			return isEnableCommunication;
		}

		public void setEnableCommunication(boolean isEnableCommunication) {
			this.isEnableCommunication = isEnableCommunication;
		}
	    
	    
	
	    

}
