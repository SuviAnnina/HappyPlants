For English, scroll down. Screenshots of the site at the end of the page.  

# Happy Plants is live on Render!  
Check out [Happy Plants](http://happyplants.onrender.com/) on Render. (Site may take a few minutes to load).

## Happy Plants  
Tavoitteenani oli rakentaa perusta/prototyyppi (kuvitteelliselle) kasvikaupalle Happy Plantsille. Projektissa käytin Java Spring Boot ohjelmistokehystä ja toteutin käyttöliittymän Thymeleafilla. Sovelluksessa on CRUD-toiminnot kasvilajikkeille, kasveille ja pistokkaille, käytön rajoitukset ja suojaukset, syötettävien tietojen validointi palvelinpäässä sekä H2-tietokanta.  
Kirjautumaton käyttäjä pääsee katselemaan listausta kasvilajikkeista ja kasveista, kirjautunut käyttäjä näkee myös listauksen pistokkaista ja voi ostaa pistokkaita (tätä toiminnallisuutta ei ole toteutettu) ja admin-tason käyttäjä pystyy lisäämään, muokkaamaan ja poistamaan sovelluksesta sisältöä UI:n kautta.  
  
![alt Kuvakaappaus Happy Plants](/.screenshots/HP01.png)  
  
## Sisältö  
1. Kirjautumaton käyttäjä  
    - Kasvilajikkeiden listaus  
    - Kasvien listaus  
    - Kirjautuminen  
2. Kirjautunut käyttäjä  
    - Samat toiminnot kuin yllä  
    - Pistokkaiden listaus  
    - Uloskirjautuminen  
3. Admin-tason käyttäjä  
    - Samat toiminnot kuin yllä  
    - Kasvilajien, kasvien ja pistokkaiden lisäys, muokkaus ja poisto (CRUD)
    - Käyttäjien listaus


## Happy Plants  
My goal was to build the foundation/prototype for the (imaginary) Happy Plants plant store. In this project I used the Java Spring Boot framework and implemented the user interface with Thymeleaf. The application includes CRUD operations for plant species, plants, and cuttings, usage restrictions and security measures, server-side validation of input data, and an H2 database.  
Unauthenticated user is able to browse listings of plant species and plants, logged in user can also browse listings of cuttings and potentially buy them (this feature is not implemented) and admin-level user can add, edit and delete content via UI.  
  
![alt Screenshot of Happy Plants](/.screenshots/HP01.png)
  
## Content  
1. Unauthenticated user  
    - Plant species listing  
    - Plant listing  
    - Log in  
2. Logged in user  
    - Same functions as above  
    - Cutting listings  
    - Log out  
3. Admin user  
    - Same functions as above  
    - Adding new plant species, plants and cuttings  
    - Editing plant species, plants and cuttings  
    - Deleting plant species, plants and cuttings  
    - User listing  

## Kuvakaappaukset - Screenshots  
View for unauthenticated user - Plant listing - Landing page    
![alt Screenshot of Happy Plants](/.screenshots/HP01.png)    
View for anauthenticated user - Plant species listing    
![alt Screenshot of Happy Plants](/.screenshots/HP02.png)  
View for logged in user - Plant listing  
![alt Screenshot of Happy Plants](/.screenshots/HP03.png)  
View for logged in user - Cutting listing  
![alt Screenshot of Happy Plants](/.screenshots/HP04.png)  
View for admin user - Plantlisting with CRUD    
![alt Screenshot of Happy Plants](/.screenshots/HP05.png)  
View for admin user - Add a new cutting  
![alt Screenshot of Happy Plants](/.screenshots/HP06.png)  
View for admin user - Edit cutting
![alt Screenshot of Happy Plants](/.screenshots/HP07.png)  
