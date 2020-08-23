/**
 * 
 */
var comptSlide = 1;
var video = null;

window.onload = function (){
	document.getElementById("navSlideLeft").addEventListener("click", slideleft, false);
	document.getElementById("navSlideRight").addEventListener("click", slideright, false);
	listener ();
}

function listener () {
	document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].addEventListener('timeupdate', jumpVideo, false);
}

function jumpVideo () {
	video = document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0];
	if(video.currentTime > video.duration * .93){
		slideright();
 	}
}
function slideleft (){
	document.getElementById('slide'+comptSlide).style.display = "none";
	document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].pause();
	document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].currentTime = 0;
	document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].autoplay = false;
	if (comptSlide > 1)
	{
		comptSlide-=1;
		document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].play();
	}
	else
	{
		comptSlide=13;
		document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].play();
	}
	document.getElementById('slide'+comptSlide).style.display = "flex";
	listener ();
}

function slideright (){
	document.getElementById('slide'+comptSlide).style.display = "none";
	document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].pause();
	document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].currentTime = 1;
	document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].autoplay = false;
	if (comptSlide < 13)
	{
		comptSlide+=1;
		document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].currentTime = 1;
		document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].play();
	}
	else
	{
		comptSlide=1;
		document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].currentTime = 1;
		document.getElementById('slide'+comptSlide).getElementsByTagName( 'video' )[0].play();
	}
	document.getElementById('slide'+comptSlide).style.display = "flex";
	listener ();
}