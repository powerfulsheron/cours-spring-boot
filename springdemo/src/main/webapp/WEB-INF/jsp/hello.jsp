<head>
<style>
/*This changes the background color*/
body { 
  background: linear-gradient(to right, #482164, #3675D4);
}

/* Snippet inspired by https://codepen.io/WebSonick/pen/vjmgu?editors=1100*/
.star {
  background: url(http://www.script-tutorials.com/demos/360/images/stars.png) repeat top center;
  z-index: 0;
  height: 100%;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  display: block;
  position: absolute;
  animation: 400s twinkle linear infinite;
}
/*End snippet*/

/*This is the styling for the rocket*/
.rocket {
  position: absolute;
  top: 20%;
  transform: rotate(90deg);
  -webkit-animation: launch 4s linear infinite;
  -moz-animation: launch 4s linear infinite;
  -o-animation: launch 4s linear infinite;
  animation: launch 4s linear infinite;
  z-index: 9999;
}

/*We did not go over this. The planet wrapper ensures our planet stays in the middle of the screen no matter the screen size.*/
.planet-wrapper {
  position: relative;
  width: 200px;
  margin: 120px auto;
}

/*The styling for the planet. Overflow: hidden just makes sure the shadow doesn't go outside of the planet's borders.*/
.planet {
  height: 200px;
  width: 200px;
  background: linear-gradient(to bottom, #E98642, #B5441C);
  border-radius: 100%;
  position: relative;
  overflow: hidden;
  box-shadow: 2px 2px 65px 2px #E26537; 
}

/*When you want to style multiple elements the same, you can separate the class names by commas!*/
.crater1, .crater2, .crater3{  
  background-color: #B54416;
  border-radius: 50%;
  position: absolute;
}


.crater1 {
  height: 40px;
  width: 40px;
  border-radius: 50%;
  top: 70px;
  left: 30px;
}

.crater1:after {
  height: 50px;
  width: 12px;
  top: 20px;
  left: 60px;
}

.crater2 {
  height: 25px;
  width: 25px;
  border-radius: 50%;
  position: absolute;
  top: 25px;
  left: 32px;
}

.crater3 {
  height: 12px;
  width: 12px;
  border-radius: 50%;
  position: absolute;
  top: 70px;
  left: 100px;
}

/*Here are all the keyframes animations. The extra prefixes are to make sure your animations work in all web browsers.*/

/*Planet rotation animation*/
@-webkit-keyframes rotate {
  to { transform: rotate(360deg)}
}

@-moz-keyframes rotate {
  to { transform: rotate(360deg)}
}

@-o-keyframes rotate {
  to { transform: rotate(360deg)}
}

@keyframes rotate {
  to { transform: rotate(360deg)}
}

/*Rocket animation*/
@-webkit-keyframes launch {
   0%   {top: 20%; left: 0;}
   25%  {top: 30%; left: 25%;}
   50%  {top: 20%; left: 50%;}
   75%  {top: 30%; left: 75%;}
   100% {top: 20%; left: 110%;}
}

@-o-keyframes launch {
   0%   {top: 20%; left: 0;}
   25%  {top: 30%; left: 25%;}
   50%  {top: 20%; left: 50%;}
   75%  {top: 30%; left: 75%;}
   100% {top: 20%; left: 110%;}
}

@-moz-keyframes launch {
   0%   {top: 20%; left: 0;}
   25%  {top: 30%; left: 25%;}
   50%  {top: 20%; left: 50%;}
   75%  {top: 30%; left: 75%;}
   100% {top: 20%; left: 110%;}
}

@keyframes launch {
   0%   {top: 20%; left: 0;}
   25%  {top: 30%; left: 25%;}
   50%  {top: 20%; left: 50%;}
   75%  {top: 30%; left: 75%;}
   100% {top: 20%; left: 110%;}
}

/*Moving stars */
@keyframes twinkle {
  from { background-position: 0 0;}
  to {background-position: -2000px 5000px;}
}
</style>
</head>
<html>
	<div class="star">
	  <img src="https://bit.ly/2b2lqIN" height="50"  class="rocket">
	  <div class="planet-wrapper">
	    <div class="planet">
	      <div class="crater1">Zdrare</div>
	      <div class="crater2"></div>
	      <div class="crater3"></div>
	    </div>
	  </div>
	</div>
</html>
