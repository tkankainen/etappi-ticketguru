import React, {useState} from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';

function LisaaLipputyyppi({ tallennaLipputyyppi, tapahtumaurl }) {

    const [open, setOpen] = useState(false);
    const [lipputyyppi, setLipputyyppi] = useState({
        nimi: '', hinta: '', tapahtuma: tapahtumaurl
    })

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleInputChange = (event) => {
        setLipputyyppi({...lipputyyppi, [event.target.name]: event.target.value })
    }

    const lisaaLipputyyppi = () => {
        console.log(lipputyyppi)
        tallennaLipputyyppi(lipputyyppi);
        handleClose();
    }

    return(
        <div>
        <Button style={{margin: 10}} variant="outlined" onClick={handleClickOpen}>
            Lisää lipputyyppi
        </Button>
        <Dialog open={open} onClose={handleClose}>
            <DialogTitle>Uusi lipputyyppi</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    name="nimi"
                    value={lipputyyppi.nimi}
                    onChange={e => handleInputChange(e)}
                    label="Nimi"
                    type="text"
                    fullWidth
                />
                <TextField
                    margin="dense"
                    name="hinta"
                    value={lipputyyppi.hinta}
                    onChange={e => handleInputChange(e)}
                    label="Hinta"
                    type="text"
                    fullWidth
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={handleClose}>
                    Peruuta
                </Button>
                <Button onClick={lisaaLipputyyppi}>
                    Tallenna
                </Button>
            </DialogActions>
        </Dialog>
        </div>
    );
}

export default LisaaLipputyyppi;