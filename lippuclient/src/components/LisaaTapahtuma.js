import React, {useState} from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';

function LisaaTapahtuma(props) {

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
        props.tallennaTapahtuma(tapahtuma);
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
                    onChange={e => handleInputChange(e)}
                    label="Aika"
                    type="text"
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