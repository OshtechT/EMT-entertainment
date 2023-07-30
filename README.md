Project Methodology
(Diagram to show organisation of website / site map)

Methodology Introduction

This section highlights the methods used designing and implementing the Online Ticketing platform. This project had followed an agile development methodology during the course of this project. Agile is an iterative approach to project management and software development that helps teams deliver value to their customers faster(Atlassian 2023). This style of development delivers progress in small increments, which can then be evaluated early to see whether or not development is going in the right direction. These were the following development stages for the course of this project:

    1. Research

During this stage, extensive research was done on online ticketing platforms to gather information needed for the success of this project.  The research methodology used was case-study research, this involves looking at solutions that have already been made and evaluating the success of those platforms. From there key features and minimum requirements are identified.
 
    2. Design

From the research, the architecture of the system was thoroughly designed this covers what the technical aspects of the solution in detail . This consists of front-end and back-end components, security measures, database and third parties like payment gateway integration. This design was reviewed and refined with feed back from project supervisor. 


    3. Implementation

To implement the solution, the framework was Spring Boot was used. This is primarily focused on the java programming language but HTML, CSS and  JavaScript was also used. The code for this project was constantly reviewed, refined and tested to get the best possible results to ensure the performance of the application and to provide a positive user-experience.
  
    4. Testing

The testing of the proposed solution was full-bodied and rigorous, some of the tests that were used was unit testing and integration testing. This was to ensure the success of the application under the circumstances and conditions at each of those given times. This success of this depended on if the solution had met the minimum requirements and project aims. 

Overall, the methodology had guaranteed that the development of the Online Ticketing platform was done in an organised and efficient manner. The agile iterative development process encouraged constant progress and improvement of the solution.

Research

The research data that had been collected for this project was mainly case study-research. The case-studies used for the background research had to be similar to  the proposed solution in terms of the service or product that was being offered/sold, in other words they would also have to be online ticketing platform. The kind of information that was gathered from these studies would be characteristics such as:
 
Design of the webpages- The case studies webpage design would demonstrate what a aesthetic user-interface should look like and the types of front-end features, animations and effects that would be or wouldn’t be useful/necessary.
 
Site map – From the site map, the total amount of webpages and their purpose can be learnt from it. This information gathered from them will directly influence the amount and kind of web pages the solution will have. 

Process of buying tickets- The case-studies has been used to gather information on the process of using the chosen platform to buy a ticket. From this the best practices can be learnt when designing a similar system for the solution, an example of this would be the overall user-experience. If it was good, those aspects of it will be brought into the solution and if it was subpar then the negative aspects and limitations will be avoided.

Total event information and total ticket information- The case-studies showed what information was needed for both events and tickets such as a ticket needing a price, entry type, latest entry time and etc. This information directly supports the development of the solution. 

From the data gathered, the similarities between the different platforms had influenced what would be a minimum requirement for a solution like this to be successful as well as helping  to determine what the project should also aim for(non-function requirements). 

System Design Architecture

The design architecture of the proposed solution for an online ticketing platform is a client-server model. This is because the clients initiate communication with the server and the server responds to the request given. The front-end of the application was for the customers who want to purchase tickets, make an enquiry or find more about the event organisers whilst the bank-end server handles the technological duties of the requests. The system is designed to be robust, secure and user-friendly, these are the components:

Front – End: The front end of the solution is the face of the platform, this is what the client see and interact with when using the platform. This will be made using  the languages HTML, CSS and JavaScript. These will provide a stylish and user-friendly website interface which the client can use to view upcoming events, purchase tickets, make an enquiry or find more about the event organisers. From here event organisers will also have access to an admin page where the can manage content for their customers. This gives them the power to create,delete or edit events and their respective tickets on the platform. The front-end will also include visual design features like animations and after effects, image sliders, background videos , navigation bars, drop down lists and so on.

Back-End: The back-end of the platform is what users cannot see but is actually doing the legwork for the application. The solution has been developed using Java under the spring boot framework. It has been designed to consist of a database to store the data and a multi-layered architecture for the tools to access them. For every request made from the front-end there has to be a back-end process to carry out the request. The components of the back-end are: Ticket delivery system, ticket authentication system, event and ticket data handling and email handling.

Database: The platform will be using a relational database management system (RDBMS). It will be designed to handle vast amounts of information  and to be accessed quick and securely. The database will be used in the solution to store information about tickets, events and orders.

Security: This is very important for an Online Ticketing platform as preventing fraud is a priority is essential for the success of this solution. Here are some of the measures taken in the design of the solution:

Prepared statements to prevent SQL injection – An SQL injection is when an authorized user gains access to the database using malicious SQL queries. The way prepared statements would combat this is through the separation of the user input and the SQL query using placeholders.
Using  updated software and  using best practices for the development- This is a security measure because outdated software have often been breached because of its age and the rate at which hackers are exploiting vulnerabilities. This has lead to developers patching the holes and releasing new versions in order to keep people protected from previous exploits making it more secure.
Having a strong ticket authentication system – This is a security measure as part of the solution is to make sure only people that have paid for a ticket can get access, if this is not the case people will exploit this no longer pay for entry and this will negatively impact events and profits. 
Regular maintenance of the system – This is a security measure because the code base will need to be regularly tested so that exploits a found before hackers start using them. This will stop security breaches before they happen and therefore has been implemented in the design.

Third-Party Integration- There are certain limitations that can come with developing web applications and these drawbacks can be accounted for by integrating third-party software and libraries. The proposed solution will use these for the payment gateway and mobile text updates. To build a payment gateway from the ground up will not only take a lot of valuable time but would be very difficulty however using a payment gateway like stripe will ensure the service that is delivered is reliable and secure.

Overall, the design architecture of the online ticketing platform covers how the solution will be developed. Through the agile iterative development, the design for this platform will be continuously adapted to make sure the success criteria is met.


Implementation

The solution has been implemented using  the Spring Boot framework. It is a open-source framework used to create advanced production level web applications and make the process quicker and easier.  This utilized the Java programming language for the ticket scanner and the Back-end along with a PostgreSQL database. The Front-end was developed using HTML, CSS, and JavaScript. The following highlights the implementation of the solution:

Back-end Development

This was the where the project had started. Requests made from the web-application are sent to the Back-end through this Multi-layered architecture and the respective task is fulfilled and the relative output is passed back to the Front-End. The Back-end had been implemented into 4 layers that are run on the web server: Entity layer, Service layer, Persistence layer and Controller layer.

 The Java classes in the Entity layer are made up of the data models that would be needed throughout the program, some of those objects would be tables in the database. For this solution, the entities where tickets, events and orders. The rest of the objects in this layer are the inputs for forms that how shown on the Front-End on the platform(Webpage).

The Java classes in the Controller layer are the forefront of the Multi-layered architecture, it is the layer that interacts with the  Front-End of the solution. Its role is to receive specific HTTP requests using the endpoints of the URL and after validation of the data the Service Layer is then used to handle the task. Once the task is complete, the relevant out is sent back to the Web Application. For this solution one controller Java class is used to handle all the HTTP requests as there is not many.  
  
The Java classes in the Service Layer are used to handle all the business logic of the applications. These are  the Java classes with the functions that will provide services to the user-requests received from the Controller layer. For this solution, these services would include the shopping basket for customers, the creation and delivery of e-tickets and the delivery of queries made for private bookings. For the services that include the CRUD(Create,Read,Update,Delete) operations for the data models like tickets, events and orders, the     task can only be carried out after the data is received from the Persistence Layer.

The Java classes in the Persistence Layer interact directly with the database. The Java classes act as repositories that are used in the Service Layer to perform CRUD operations for the entities stored in the database. For this solution, the Persistence Layer includes the ticket,event and order repositories. 

The benefits of using this Multi-Architecture approach when implementing the solution is that it can be maintained easier as the different layers have different roles meaning that the code can be easily found and edited. Another benefit is this approach is better for scalability as more instances can be added to a layer rather than the entire application.

The database for the solution was implement using PostgreSQL, it is ideal for the solution because of its support for complex data types, high performance and its minimal downtime. This is important for a solution like this because accessibility is a minimum success requirement. It is also  can also be hosted on multiple different servers like the cloud, this is a result of PostgreSQL being a flexible database solution. For the Online Ticketing platform, its is used to store tables for orders,events and tickets.

Front-End Development/Ticketing Process

The Front-End of the solution was developed using HTML, CSS and JavaScript. This part of the web-application includes a set of templates(webpages):Homepage,Shopping-Basket,Details,Purchase Confirmed, Private Bookings/Queries and the About Us page.

The Homepage is the first page displayed upon visiting the site. This page is the most important as it is the most visited which means it has to catch the eye of visitors. For this solution, to cater for this  a video has been added to the background along with an image banner. The homepage has the links to the Shopping Basket,Private Bookings/Queries and the About Us page. This page is also where upcoming events can be viewed and added to basket, this has been implemented using pop-up models and forms for the user inputs. Data of events and tickets are retrieved from the Back-end of the web application and used to show event flyers, information and display available tickets. When a ticket is added to basket, the customer is redirected to the Basket Page this feature has been implemented because for Online Ticketing Platforms tickets are mainly bought for only one event. This in return streamlines the process of purchasing a ticket making it quicker, easier and more user-friendly.

The Shopping-Basket page is shown as a result of either clicking on the basket logo or adding a product. For the solution, this page is used to display items that have been added to the basket by a specific session-id along with the total price and number of items in the basket. This feature has been implemented unto this page in order to keep other peoples baskets separate to each other. This page also holds links to go back to the homepage, clear the basket or continue to checkout. Choosing to continue will take the customer to the Details page.

The Details page is displayed after confirming the contents of the shopping basket. The purpose of this page is to collect information about the customer, For this solution, this webpage was implemented using a html form and the data collected would be: Name, Email and Phone Number. The main feature that has been implemented is the validation of the user input, not only does this ensures that every field in the form has been filled  but also ensures a valid UK phone number and a correct email address has been entered. This feature makes the ticketing system more reliable as it is accounting for human error. After passing validation the customer is then directed to the payment gateway to finish checking out.

After the payment has been processed the customer will receive the e-ticket via email and be redirected the Purchase Confirmed page. This page consists of a message thanking the customer for their purchase, this has been implemented with animations and on the mobile site has been implemented with an image slider. This feature brings about a positive customer experience that accessible on any device. This page links back to the main homepage and will automatically redirect after a certain time limit making the web application more user-friendly.

The Private Bookings/Query page has been implemented using a HTML form. This page is important because it gives Customers a direct line to contact event organisers making the solution more user-friendly resulting in a better user-experience.

The About-Us page is the last page on the website. Its purpose is to give customer background information about the Event Organisers. This has been implemented using an image slider and a personal message to customers in order to be appealing and eye-catching, providing the customers with a  better user-experience.

Ticket Scanner/Ticket Authentication system

The ticket scanner of the solution was developed using Java, For this solution, it was needed to authenticate event e-tickets that were sent to customers. This was implemented by using the computers webcam to take a picture of the QR code and obtain the output. The output of the QR code should match the barcode number of an order in the Order table,  if this is the case then the ticket is valid and then marked if not then the ticket is invalid. Once marked the tickets cannot be used again. Steps that have been taken to make this secure is that the process of making the QR code value is completely randomized and has to be made with at least 11 digits, This makes the chances of guessing the correct Qr code value very slim.

Overall, The solution was implemented using Java based web-framework Spring Boot, The Back-End was implement using a multi-layer architecture and the ticket verification system was made using a Web Cam. They were both developed in Java, the Front-End was made using HTML,CSS and JavaScript.

Testing
The solution has undergone rigorous testing to ensure the success of the web-application. The success of this project was measured against how well the project requirements and aims were met. There were several stages to the testing and these were unit testing, integration testing and Performance testing.
Unit testing is used to test individual components or units of code within a certain scope rather than include the rest of the application. An example of a unit test would be to test the addTicket() function in the Service Layer of the Back-end. This test was implemented using  J Unit a Java library that specializes in unit testing, a test was written for each component/function to ensure the success of the solution. The passing of the test is shown as a green tick in the console, a fail would be a red cross  
Integration testing was used to evaluate how well the different components of the system could work together. These would include the interaction between both sides of the application(Front-End and Back-End) along with the Ticket Scanner. An example of this test would be to dynamically generate a list of events onto the web page, this would require the Front-End to get information for the Back and display it, testing the integration between the two. This tests success would be if the correct event information was displayed if not its a fail.
Performance testing was used to test whether or not the solution can handle high levels of traffic. For this solution, this had involved simulating large numbers of users attempting to purchase a ticket. This was implemented by using multiple devices and  multiple instances of the web application simultaneously. The success of this test would be a short waiting time for each customer  to receive a their e-ticket, failure would be a very long waiting time or a connection time out.
Overall, the solution had undergone a series of tests to ensure the success of the application. These tests had included: unit tests using J Unit, integration tests between different components and performance tests of the ticket delivery system. 
