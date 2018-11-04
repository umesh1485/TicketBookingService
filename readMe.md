*Prerequisits:
1. java 1.8
2. mvn 3.2.5 or above
3. MySQL Server 5.5 up and running with below credentials in 'hibernate.cfg.xml file'
	name="dialect": org.hibernate.dialect.MySQL55Dialect    
        name="connection.url": jdbc:mysql://localhost:3306/DBName  
        name="connection.username": DB username  
        name="connection.password": DB password  


*Steps to run:
1. download and import the project in eclipse (I developed and ran in 'Spring Tool Suite')
2. perform command from project directory 'D:\work\TicketBookingService>mvn compile' from cmd
3. run and execute the main class 'src.com.ticketbooking.app.publish.SoapPublisher.java', make sure that port '8888' is available port
4. Then Use WSDL at for testing 'http://localhost:8888/ws/ticket?wsdl'
