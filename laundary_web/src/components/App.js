import React, { useState, useEffect } from 'react';
import { Grid, Container , MuiThemeProvider , createMuiTheme , makeStyles , Typography} from "@material-ui/core"
import Header from "./Header";
import Footer from "./footer";
import Main from "./main";
import "./style/App.css";

const useStyles = makeStyles((theme) => ({
	root:{
		fontFamily: "Noto Sans KR",
  },
  main:{
    fontFamily: "Noto Sans KR",
  },

}))

const theme = createMuiTheme({
  typography:{
		fontFamily: "Noto Sans KR",
  },

  // 반응형 브레이크 포인트 
	breakpoints: {
	  // Define custom breakpoint values.
	  // These will apply to Material-UI components that use responsive
	  // breakpoints, such as `Grid` and `Hidden`. You can also use the
	  // theme breakpoint functions `up`, `down`, and `between` to create
	  // media queries for these breakpoints
	  values: {
		xs: 360,
		// sm: 450,
		md: 768,
		lg: 1200,
		// xl: 1200
	  },
	},
  });
  


const App = () => {
  const classes = useStyles();

  return (
    <MuiThemeProvider theme={theme} >
      <Grid className={classes.root}>
          <Header/>
        <Grid className={classes.main} xs={12} >
          <Main/>
          <Footer/>
        </Grid>
      </Grid>
    </MuiThemeProvider>
  );
}

export default App;