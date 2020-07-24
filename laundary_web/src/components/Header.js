import React from "react";
import {
     Grid,
     Button,
     Hidden,
     Box,
     Container,
     createMuiTheme,
     MuiThemeProvider,
	 makeStyles
		} from "@material-ui/core";
import "./style/Header.css";

const useStyles = makeStyles((theme) => ({
  root:{
	fontFamily: "Noto Sans KR",
  },
  member:{
	fontFamily: "Noto Sans KR, sans-serif",
	fontSize: "16px",
	color:"#FFFFFF"
  },
  left:{
	fontFamily: "Noto Sans KR, sans-serif",
	color:"#FFFFFF",
	fontSize:"36px",
	paddingBottom:"10px",
	fontWeight:"700"
  }

}))

const Header = () => {

	const classes  = useStyles();

	const showMember = (e) => {
		e.preventDefault();
	} 

	const memberLink = "https://www.notion.so/Framework-a0b51c5f08694cde8de57660e53be9f7";
	
	return(
		<Grid container className = "header">
		  <Container className="headerWrapper" xs={9} style={{display:"flex"}}>
			<Grid className={classes.left}>
				세탁 만세 
			</Grid>
			<Button className="right" >
			  <a href={memberLink} className={classes.member}>멤버 소개</a>
			</Button>
		  </Container>
		</Grid>
	)
}

export default Header;

