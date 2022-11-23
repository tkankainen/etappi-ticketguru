import React, { useState } from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import Snackbar from '@mui/material/Snackbar';
import Tapahtumat from './Tapahtumat';

function Login() {

    const [kayttaja, setKayttaja] = useState({
        tunnus: '', salasana: ''});
    const [isAuthenticated, setAuth] = useState(false);
    const [open, setOpen] = useState(false);

    const login = () => {
        fetch('https://etappi-ticketguru.herokuapp.com/login', {
          method: 'POST',
          headers: { 'Content-Type':'application/json' },
          body: JSON.stringify(kayttaja)
        })
        .then(res => {
          const jwtToken = res.headers.get
            ('Authorization');
          if (jwtToken !== null) {
            sessionStorage.setItem("jwt", jwtToken);
            setAuth(true);
          } else {
            setOpen(true);
          }
        })
        .catch(err => console.error(err))
    }

    const handleChange = (event) => {
        setKayttaja({...kayttaja,
            [event.target.name] : event.target.value});
    }

    if (isAuthenticated) {
        return <Tapahtumat />;
    } else {
        return (
            <Stack spacing={2} alignItems='center' mt={2}>
                <TextField
                    name="tunnus"
                    label="Tunnus"
                    onChange={handleChange} />
                <TextField
                    type="password"
                    name="salasana"
                    label="Salasana"
                    onChange={handleChange}/>
                <Button
                    variant="outlined"
                    color="primary"
                    onClick={login}>
                    Login
                </Button>
                <Snackbar
                    open={open}
                    autoHideDuration={3000}
                    onClose={() => setOpen(false)}
                    message="Kirjautuminen epäonnistui: tarkista käyttäjätunnus ja salasana"
                />
            </Stack>
        )
    }
                  
}

export default Login;