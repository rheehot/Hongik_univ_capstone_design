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
import name__main from "./img/name__main.png";

const useStyles = makeStyles((theme) => ({
  root:{
	fontFamily: "Noto Sans KR",
  },
  left:{
	fontFamily: "Noto Sans KR, sans-serif",
	color:"#FFFFFF",
	fontSize:"36px",
	fontWeight:"700",
	textDecoration:"none",
  }
}))

const Header = () => {

	const classes  = useStyles();

	const memberLink = "https://www.notion.so/Framework-a0b51c5f08694cde8de57660e53be9f7";
	
	return(
		<Grid container className = "header">
			<Grid className="header__content">
				<a href="#">
					<img src={name__main} style={{width:"25%" , height:""}}/>
				</a>
				<Button className="right" >
					<a href={memberLink} className={classes.member}>멤버 소개</a>
				</Button>
			</Grid>
		</Grid>
	)
}

export default Header;

