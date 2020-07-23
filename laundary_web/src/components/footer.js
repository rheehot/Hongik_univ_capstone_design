import React from "react";
import { Grid, Container , MuiThemeProvider , createMuiTheme , makeStyles , Button } from "@material-ui/core"
import mail from "./img/mail.png";
import insta from "./img/insta.png";
import "./style/Footer.css";

const useStyles = makeStyles((theme) => ({
	root:{
		fontFamily: "Noto Sans KR",
	},
	
	footer:{
		fontFamily: "Noto Sans KR, sans-serif",
		fontWeight:"400",
		fontSize:"13px",
		lineHeight:"1.5em",
		letterSpacing:"0.05em",
		paddingTop:"30px"
    },

    footerGround:{
        backgroundColor:"#F9F9F9"
		},
		mailImg:{
			width:"24px",
			height:"24px",
			paddingLeft:"130px"
		},
		instaImg:{
			width:"24px",
			height:"24px",
			marginLeft:"10px"
		}
}))


const Footer = () => {

	const classes = useStyles();

	// 이용약관 노션페이지
	const useTerm = "https://www.notion.so/46a9013fa05c4aeaa9c73102e0d102aa";

	// 개인정보처리방침 노션페이지
	const userInfoDiscipline = "https://www.notion.so/10b05ec77bd24a49a33c7a7c63d81b5e";

	// 사업자정보확인
	const managerInfo = "https://www.notion.so/f5f6c9172c2b42a8b186228c2e84403f";

	// 인스타주소 
	const instaAddress = "https://www.instagram.com/jangwon_diego_yoon/?hl=ko";

    return(
			<Grid className={classes.footerGround}>
				<Container> 
					<Grid className={classes.footer}>
						<p>
						상호: HONGIK Inc. | 대표: 윤장원 | 개인정보관리책임자: 윤장원 | 전화: 010-7257-6466 | 이메일: yoonjangwon94@gmail.com
							<img className={classes.mailImg} src={mail}/>
							<a href = {instaAddress} >
							  <img className={classes.instaImg} src={insta} />
							</a>
						</p>
						<p>
						주소: 인천광역시 연수구 송도과학로51번길 136 211동 1704호
						</p>
						<p>
						<Button>
							<a href={useTerm}>이용약관</a>
						</Button>
						<Button>
							<a href={userInfoDiscipline}>개인정보처리방침</a>
						</Button>
						<Button>
							<a href={managerInfo}>사업자정보확인</a>
						</Button>
						</p>
						<p>
						ⓒ 2020 D.S STUDENT, DEPARTMENT OF COMPUTER ENGINEERING, HONGIK UNIVERSITY, REPUBLIC OF KOREA
						</p>
					</Grid>
				</Container>
			</Grid>
    )
}

export default Footer;
