<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management</title>
    <style>
*{
  box-sizing: border-box;
}
body{
  margin: 0;
  padding: 0;
}
#about{
background-image:linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0.7));
width:1250px;
}
.navbar{
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #333;
  color: white;
  color:white;
}
.brand-title{
  font-size: 1.5rem;
  margin: .5rem;
}
.navbar-links ul{
  margin: 0;
  padding: ;
  display: flex;
  align-items: center;
}
.navbar-links li{
  list-style: none;
}
.navbar-links li a{
  text-decoration: none;
  color : white;
  padding: 1rem;
  display: bolck;
}
.navbar-links li:hover{
  background-color: #555;
}
.toggle-btn{
  position: absolute;
  top: .75rem;
  right: 1rem;
  display: none;
  flex-direction: column;
  justify-content: space-between;
  width: 31px;
  height: 21px
}
.toggle-btn .bar{
  height: 3px;
  width: 100%;
  background-color: white;
  border-radius: 10px;
}

@media(max-width: 600px){
  .toggle-btn{
    display: flex;
  }
  .navbar-links{
    display: none;
    width: 100%;
  }
  .navbar{
    flex-direction: column;
    align-items: flex-start;
  }
  .navbar-links ul{
    width: 100%;
    flex-direction: column;
  }
  .navbar-links li{
    text-align: center;
  }
  .navbar-links li a{
    padding: .5rem 1rem;
  }
  .navbar-links.active{
    display: flex;
  }
}
.topnav {
  background-color: black;
  overflow: hidden;
}
h4{
font-size:larger;
font-weight: bold;
color:yellow;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size:larger;
}
body{
  background-image: url('Assets/Rose-flowers-books.jpg');
           background-repeat: no-repeat;
            background-size:cover;
            color:white;
          
        }
/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: rgba(71, 90, 28, 0.945);
}

/* Add a color to the active/current link */
.topnav a {
  background-color: black;
  color: white;
  float: right;
}
p,pre{
  color:white;
  font-size: large;
}
fieldset{
  width: 200px;
}

#about{
text-align: justify;}
h1{
color:yellow;
text-shadow: 2px 2px #ff0000;
}
#foot{
  text-align: center;

}
#quotes{
  position:relative;
  float: right;
  width:50%;
  top:-450px;
  height:50px;
}
#award,#contact{
  color: red;
}

</style>
</head>
<body id="top">
    <nav class="navbar">
        <div class='brand-title'>Library Management</div>
        <a href='#' class='toggle-btn' id='toggle-btn'>
          <span class='bar'></span>
          <span class='bar'></span>
          <span class='bar'></span>
        </a>
        <div class='navbar-links' id='navbar-links'>
          <ul>
            <li><a class="active"id='links' href="index.jsp">Login</a></li>
            <li><a href="#contact" id='links'>Contact</a></li>
            <li><a href= "#award" id='links'>About</a></li>
          </ul>
        </div>
      </nav>
      <br><br><br>
      <div id="image">
        <img src="Assets/library.jpg" width="600px" height="450px">
        
  </div>
  <div id="quotes">
  <h1>World Leaders about Books</h1>
    <p>"Reading is an exercise in empathy; an exercise in walking in someone else's shoes for a while." -- Malorie Blackman</p><BR>
    <p>"Not all readers are leaders, but all leaders are readers." -- Harry S Truman</p><BR>
    <p>"It is not true that 'we have only one life to live,' if we can read, we can live as many more lives and as many kinds of lives as we wish." -- S.I. Hayakawa</p><BR>
    <P>"Reading is an act of civilization; it's one of the greatest acts of civilization because it takes the free raw material of the mind and builds castles of possibilities." -- Ben Okri</P><BR>
      <P>"A book is a dream that you hold in your hand." -- Neil Gaiman</P>
  </div>


  <BR><BR><BR>
   
  <fieldset id="about">
  <h2 id="award" >About Us:</h2> 
  
  <p> &emsp;&emsp;The Anna Centenary Library (ACL), a state-of the-art library was inaugurated on September 15, 2010 on the occasion of the 102nd birth anniversary of the former Chief Minister of Tamil Nadu Dr. C N Annadurai popularly called ANNA. By reason of his great interest towards the books and library, this library is named as Anna Centenary Library. The foundation stone laid on August 16, 2008, completed in a short span and declared open to the public from 20th September 2010.
</p>
<p>    The built up area of this centralized air-conditioned library is 3.75 lakh sq. ft., encompasses ground and eight floors. At present, it hosts five lakhs books covering wide range of subjects to serve the information needs of the public, academic and corporate community. Our Library has a Braille Section, Own Books Reading Section, Children Section, Periodicals and Newspapers Section, Tamil books Section, English Books Section and Digital Library. </p><p>In addition, the library has a Conference Hall that can facilitate 150 members.  Our Library Auditorium is the most prestigious Auditorium of Chennai. This fully Air Conditioned Auditorium is an elegant structure with aesthetically designed Public Areas, Main Hall, Green Rooms, etc.

</p><p>The Auditorium stage is ideal for demanding theatrical performances. To enable quick change of scenes and sets as well as elobarate lighting design.

</p><p>The Auditorium has excellent acoustics. It is furthermore equipped with a professional quality sound system, Sound craft Mixer. Auditorium also has its own sophisticated stage lighting with a large variety of professional lights.

</p><p>Auditorium has an elaborate CCTV system. Auditorium can accommodate 1100 people. A projector with latest technology is available in the auditorium to screen the movie, other than main projector 2 LCD projectors with separate screens are available at main auditorium hall. It has surround sound system and very good lighting facility to conduct any type of programme.





<h4>Amphitheatre</h4>


<p>The crescent shaped amphitheater with a seating capacity of more than 800 people available at our library. It is equipped with world-class acoustics and a state-of-the-art lighting system.
</p>
<p>The stage is a versatile option for product launches, celebrity gatherings, corporate events, and entertainment spectacles. a rehearsal room and green rooms contain complete support facilities.
</p>

<h4>Conference Hall:</h4>



<p>Simple elegance and modern design make the  Conference Hall a premier site of events that require a higher standard of refinement. Its spacious capacity accommodates up to 151 people for Conference and Seminar. Flexible equipment and furnishings can be customized to meet the needs of any event, whether it is a conference, seminar or any presentation, or business meeting. It has LCD projector and LCD Panel for presentation.
</p>


<h4>Mini Conference Halls:</h4>

Capacity minimum 30 people


     </p>   
</fieldset>
<br><br><br>
    <h3 id="contact">Contact Us</h3>
    <fieldset>
      <pre>The Chief Librarian & Information Officer
        Anna Centenary Library 
        Kotturpuram 
        Chennai - 600025 
        Phone Number : 7010619606
        Email : library@tn.gov.in</pre>
    </fieldset>
    <br><br>
    
    <a href="#top" style="color:white;">Back To Top</a>
<hr>
    <footer>
      <pre id="foot">
        Copyright  2022 Anna Centenary Library| Powered by Blogger
      Design by SimpleWpThemes | Blogger Theme by NewBloggerThemes.com
      </pre>
    </footer>
</body>
</html>