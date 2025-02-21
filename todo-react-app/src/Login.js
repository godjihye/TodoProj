import React from "react";
import { Container, Grid, Typography, TextField, Button } from "@mui/material";
import { signin } from "./service/ApiService";
const Login = () => {
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.target);
    const username = data.get("username");
    const password = data.get("password");
    signin({ username: username, password: password });
  };
  return (
    <Container conponent="main" maxWidth="xs" style={{ marginTop: "8%" }}>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <Typography component="h1" variant="h5">
            로그인
          </Typography>
        </Grid>
      </Grid>
      <form noValidate onSubmit={handleSubmit}>
        {" "}
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              varient="outlined"
              required
              fullWidth
              id="username"
              name="username"
              label="아이디"
              autoComplete="username"
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              varient="outlined"
              required
              fullWidth
              id="password"
              name="password"
              label="비밀번호"
              type="password"
              autoComplete="current-password"
            />
          </Grid>
          <Grid item xs={12}>
            <Button type="submit" fullWidth variant="contained" color="primary">
              로그인
            </Button>
          </Grid>
        </Grid>
      </form>
    </Container>
  );
};
export default Login;
