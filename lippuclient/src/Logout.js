import React from 'react';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';

function Logout () {

    const logout = () => {
        sessionStorage.removeItem("jwt");
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