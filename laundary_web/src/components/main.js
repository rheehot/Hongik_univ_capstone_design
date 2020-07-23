import React, { useEffect } from "react";
import ReactDOM from 'react-dom';
import { Grid } from "@material-ui/core";
import "./style/Main.css";
import img1 from "./img/img4.png";
import img2 from "./img/img5.png";
import img3 from "./img/img1.png"


const Main = () => { 

	let imgArr = new Array();

	imgArr[0] = img1
	imgArr[1] = img2


	function showImage() { 

		var imgNum = Math.round(Math.random()*3); 
		
		var objImg = document.getElementById("introimg"); 
		
		objImg.src = imgArr[imgNum]; 
		
		setTimeout(showImage, 1000);
		
	}

		return (
			<Grid xs={12} className="main">
			  <Grid>
			    <img class = "mainImg" src={img1} style={{width:"100%"}}/>
				</Grid>

				<Grid>
					
				</Grid>
			</Grid>
		)


		
	}
	
export default Main;

	// // 이미지 전환 함수 
	// var img=new Array();
	// img[0]=new Image(); img[0].src="http://madalla.kr/script/img/a1.jpg";
	// img[1]=new Image(); img[1].src="http://madalla.kr/script/img/a2.jpg";
	// img[2]=new Image(); img[2].src="http://madalla.kr/script/img/a3.jpg";

	// var interval=150;
	// var n = 0;
	// var imgs = new Array("http://madalla.kr/script/img/a1.jpg","http://madalla.kr/script/img/a2.jpg","http://madalla.kr/script/img/a3.jpg","http://madalla.kr/script/img/a4.jpg");

	// const rotate = () => {
	// 	if(navigator.appName=="Netscape" && document.getElementById){
	// 		document.getElementById("slide").src = imgs[n];
	// 	}else {
	// 		document.images.slide.src=imgs[n];
	// 	}
	// 	(n === (imgs.length-1)) ? n = 0: n++;

	// 	setTimeout(rotate(),interval);
	// }
