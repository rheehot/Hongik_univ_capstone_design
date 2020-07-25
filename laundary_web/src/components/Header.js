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
	fontFamily: "Noto Sans KR",
	fontSize: "16px"
  },


}))

const Header = () => {

	const classes  = useStyles();

	const showMember = (e) => {
		e.preventDefault();
		console.log("hi")
	} 

	const memberLink = "https://www.notion.so/e42040d1792b431fafca2e5324b6e50a?v=5daa629243fd475b8ae40ddd344ad098";
	
	return(
		<Grid container className = "header">
			<Grid className="left">
				세탁 만세 
			</Grid>
			<Grid className="right" >
			  <a href={memberLink}className={classes.member}>멤버 소개</a>
			</Grid>
		</Grid>
	)
}

export default Header;

