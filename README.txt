Name:Mohamed Fathi Mohamed Razzk
Code : 16X0103 


## Auto Test 
1- To Test the code all what you need to do is click on "Run.exe" it will execute 3 shells everyone of them responsable 
for a node - " Driver Client Console "," Area Computer Console" and "City Server Console" 

2- For More Client and Computer Console and multi-threading testing you can open "More_Drivers.exe" and it will execute more
driver client console which will work sperated ans semiannually  



## Manual Testing 
Can sempily open file sepertly by secquance to grante that all port connection will be accepted throw the local host 

open powershell or cmd inside the main folder which contain com and src folders 
and run 

1- "java com.company.city_thread"
2- "java com.company.area_server"
3- "java com.company.driver"

for more driver client run the command number 3 again for more ana more driver console 

## Compile and manual testing 

Open 3 file classes in and compile&run 
city_thread , area_server , driver class modules in seriers to make sure that local server is up 
and start testing 

############################################################################################## 

#Testing Parametars 

1- In the Drive console he will ask about using the current location or you wanna to select a new location 
	- if you type and enter "y" he will ask for the destination automaticly 
	- if you type and enter "n" he will ask first for the start location 
		- then will ask for the destination location 

2- after that client send this data to area computer which open socket with server to send it the "start location " and " Required destination"

3- then server reply to the area computer client with best rute and then area computer server send data to driver client 

4- then ask him if he wanna to do another operation if y he will repeat the steps, if no will close the socket port between them 

all those operation can run sperated, parallel and semiannually using extend multithread 

############################################################################################