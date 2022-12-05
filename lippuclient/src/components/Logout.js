import React from 'react';
import { useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom";
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';

function Logout () {

    const navigate = useNavigate();
    const token = sessionStorage.getItem("jwt");
    const [loggedOut, setLoggedOut] = useState(false)

    useEffect(() => {
        if(!token) {
          navigate('/login');
        }
    }, [loggedOut]);

    const logout = () => {
        sessionStorage.removeItem("jwt");
        setLoggedOut(true)
    }
    
    return (
        <Stack spacing={2} alignItems='center' mt={2}>
            <Button
                variant="outlined"
                color="primary"
                onClick={logout}>
                Logout
            </Button>
        </Stack>
    )
}

export default Logout