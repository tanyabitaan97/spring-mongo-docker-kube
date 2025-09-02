package mongodb;

import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "userevents")
public class Events {

	
	    @Id
	    private String id;
	    
	    private String typeOfInteractionData;
	    
	    private String dateOfInteraction;
	    
	    private String nameOfEvent;
	    
	    private String createdAt;
	    
	    private double amount;
	    
	    private String dataUpdatedBy;
	    

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTypeOfInteractionData() {
			return typeOfInteractionData;
		}

		public void setTypeOfInteractionData(String typeOfInteractionData) {
			this.typeOfInteractionData = typeOfInteractionData;
		}

		public String getDateOfInteraction() {
			return dateOfInteraction;
		}

		public void setDateOfInteraction(String dateOfInteraction) {
			this.dateOfInteraction = dateOfInteraction;
		}

		public String getNameOfEvent() {
			return nameOfEvent;
		}

		public void setNameOfEvent(String nameOfEvent) {
			this.nameOfEvent = nameOfEvent;
		}

		public String getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getDataUpdatedBy() {
			return dataUpdatedBy;
		}

		public void setDataUpdatedBy(String dataUpdatedBy) {
			this.dataUpdatedBy = dataUpdatedBy;
		}
	    
}
