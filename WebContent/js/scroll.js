/**
 * 
 */

window.onscroll = function(){

	if (document.body.scrollTop > 110 || document.documentElement.scrollTop > 110) {
    	document.getElementById("header").className = "header-scroll";
		document.getElementById("nav").className = "nav-scroll";
  	}
	else {
    	document.getElementById("header").className = "";
		document.getElementById("nav").className = "";
  	}
}