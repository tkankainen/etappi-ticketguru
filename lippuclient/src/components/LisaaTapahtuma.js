import React, {useState, useEffect} from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';

function LisaaTapahtuma( {tallennaTapahtuma} ) {

    const [open, setOpen] = useState(false);
    const [tapahtuma, setTapahtuma] = useState({
        aika: '', nimi: '', osoite: '', kaupunki: '', kpl: '', loppupvm: ''
    })

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleInputChange = (event) => {
        setTapahtuma({...tapahtuma, [event.target.name]: event.target.value })
    }

    const lisaaTapahtuma = () => {
        console.log(tapahtuma)
        tallennaTapahtuma(tapahtuma);
        handleClose();
    }

    return(
        <div>
        <Button style={{margin: 10}} variant="outlined" onClick={handleClickOpen}>
            Lisää tapahtuma
        </Button>
        <Dialog open={open} onClose={handleClose}>
            <DialogTitle>Uusi tapahtuma</DialogTitle>
            <DialogContent>
                <TextField
                    autoFocus
                    margin="dense"
                    name="aika"
                    value={tapahtuma.aika}
                    type="datetime-local"
                    onChange={e => handleInputChange(e)}
                    variant="standard"
                    fullWidth
                />
                <TextField
                    margin="dense"
                    name="nimi"
                    value={tapahtuma.nimi}
                    onChange={e => handleInputChange(e)}
                    label="Nimi"
                    type="text"
                    fullWidth
                />
                <TextField
                    margin="dense"
                    name="osoite"
                    value={tapahtuma.osoite}
                    onChange={e => handleInputChange(e)}
                    label="Osoite"
                    type="text"
                    fullWidth
                />
                <TextField
                    margin="dense"
                    name="kaupunki"
                    value={tapahtuma.kaupunki}
                    onChange={e => handleInputChange(e)}
                    label="Kaupunki"
                    type="text"
                    fullWidth
                />
                <TextField
                    margin="dense"
                    name="kpl"
                    value={tapahtuma.kpl}
                    onChange={e => handleInputChange(e)}
                    label="Lippumäärä"
                    type="text"
                    fullWidth
                />
                <TextField
                    margin="dense"
                    name="loppupvm"
                    value={tapahtuma.loppupvm}
                    onChange={e => handleInputChange(e)}
                    label="Loppupvm"
                    type="text"
                    fullWidth
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={handleClose}>
                    Peruuta
                </Button>
                <Button onClick={lisaaTapahtuma}>
                    Tallenna
                </Button>
            </DialogActions>
        </Dialog>
        </div>
    );
}

export default LisaaTapahtuma;
