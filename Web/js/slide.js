/**
 * 
 */
var comptSlide = 1;

window.onload = function (){
	document.getElementById("navSlideLeft").addEventListener("click", slideleft, false);
	document.getElementById("navSlideRight").addEventListener("click", slideright, false);
}

function slideleft (){
	document.getElementById('slide'+comptSlide).style.display = "none";
	if (comptSlide > 1)
		comptSlide-=1;
	else
		comptSlide=4;
	document.getElementById('slide'+comptSlide).style.display = "flex";
	
}

function slideright (){
	document.getElementById('slide'+comptSlide).style.display = "none";
	if (comptSlide < 4)
		comptSlide+=1;
	else
		comptSlide=1;
	document.getElementById('slide'+comptSlide).style.display = "flex";
}