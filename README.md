# RealEstateManager
Project created for RealEstate Manager

Instructions
Step 1->unzip the project.
Step 2->import the project in ide.
step 3--> run the project as java application.

Note--> database used is H2 database.

-------Request API----------

1.Add property request

url-->http://localhost:8081/mananger/createproperty
Body-->{"propertyName":"DEF","numOfBedrooms":"3","numOfBathrooms":"2","areaOfProperty":"1000","areaOfBedroom":"200","areaOfBathroom":"30","price":"800000"}
type-->raw/JSON

2. Get Property request
url-->http://localhost:8081/customer/getproperties
Body-->{"numOfBedrooms":"2","numOfBathrooms":"2","areaOfProperty":"200","areaOfBedroom":"200","areaOfBathroom":"30","price":"500000"}
type-->raw/JSON


