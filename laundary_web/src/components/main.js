import React, { useEffect } from "react";
import ReactDOM from 'react-dom';
import { Grid, Container } from "@material-ui/core";
import "./style/Main.css";
import img1 from "./img/img4.png";
import img2 from "./img/img5.png";
import img3 from "./img/img3.png";
import img6 from "./img/img6.png";
import img7 from "./img/img7.png";
import img8 from "./img/img8.png";
import phone from "./img/phone.png"
import bag from "./img/bag.png"
import truck from "./img/truck.png"


const Main = () => { 
	

	// 이미지 변환 함수
	function displayNextImage() {
		x = (x === images.length - 1) ? 0 : x + 1;
		document.getElementById("img").src = images[x];
		}

		function displayPreviousImage() {
				x = (x <= 0) ? images.length - 1 : x - 1;
				document.getElementById("img").src = images[x];
		}

		function startTimer() {
				setTimeout(displayNextImage, 4000);
		}

		var images = [], x = -1;
		images[0] = img1;
		images[1] = img2;
		images[2] = img3;

		return (
			<Grid xs={12} className="main">
			  <Grid onLoad={startTimer}>
					<img id = "img" src={img1} style={{width:"100%"}}/>
			  </Grid>

			  <Container>
				  <Grid className="mainContent">
						<p>
							세탁품질
						</p>
						<p>
							타협없는
						</p>
						<p>
							고퀄리티
						</p>
					</Grid>
					<Grid className="wrapper">
						<p className = "laudaryContent" style={{textAlign:"left"}}> 
						수백만 점을 세탁해도 고객은 단 한 점의 옷으로 평가하기에, 세탁만세는 허상을 판매하지 않습니다. 출혈경쟁의 원가부담을 값싼 노동력과 저급한 원료로 대체하지 않습니다. 품질과 직결되는 수고로운 일에 기교를 부리지 않습니다. 오직 고객과 세탁에 집중합니다.
						</p>
					</Grid>

					<Grid className="imgWrapper" style={{display:"flex"}}>
						<Grid>
							<img src = {img8} style={{width:"100%", height:"100%"}}/>
						</Grid>

						<Grid className="leftImgWrapper">
							<Grid className="img7">
								<img src = {img7} style={{width:"100%", height:"100%"}}/>
							</Grid>

							<Grid className="img6" >
								<img src = {img6} style={{width:"100%", height:"100%"}} />
							</Grid>
						</Grid>
					</Grid>

					<Grid className="bottomContent">

						<Grid className="bottomHeader">
							<p>
								당신이 잠든 새벽에 
							</p>
							<p>
								미션 클리어
							</p>
						</Grid>

						<Grid className="bottomMain">
							<p>
							더이상 세탁에 시간 쏟지 마세요. 터치 한 번이면 세탁 끝. 
							세탁만세 요원이 모두가 잠든 새벽에 깨끗한 세탁물을 문 앞까지 배송합니다. 
							모든 세탁물의 사진이 첨부된 내역서와 간편결제, 
							비대면 새벽배송으로 삶의 질을 수직 상승시켜 줄 세탁만세를 지금 바로 만나보세요.
							</p>
						</Grid>
				    </Grid>

			  </Container>


			</Grid>
		)
	}
	
export default Main;