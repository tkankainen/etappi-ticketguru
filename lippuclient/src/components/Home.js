import React from 'react';
import { useEffect } from 'react';
import { useNavigate, Link } from "react-router-dom";
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';

function Home () {

    const navigate = useNavigate();
    const token = sessionStorage.getItem("jwt");

    useEffect(() => {
        if(!token) {
          navigate('/login');
        }
    });
    
    return (
        <Stack spacing={2} alignItems='center' mt={2}>
            <Button variant="outlined"><Link to="/tapahtumat">Tapahtumat</Link></Button>
            <Button variant="outlined"><Link to="/lipunmyynti">Lipunmyynti</Link></Button>
            <Button variant="outlined"><Link to="/lipuntarkistus">Lipuntarkistus</Link></Button>
            <Button variant="outlined"><Link to="/myyntitapahtumat">Myyntiapahtumat</Link></Button>
            <Button variant="outlined"><Link to="/logout">Logout</Link></Button>
        </Stack>
    )
}

export default Home