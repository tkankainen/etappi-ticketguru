import { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import { Card, CardHeader, CardContent, Typography } from '@mui/material';

function Liput () {

    const [liput, setLiput] = useState([]);
    const location = useLocation();
    const { lippuurl } = location.state
    const token = sessionStorage.getItem("jwt");
    const [lipputiedot, setLipputiedot] = useState([]);
    
    let lippukoodit = [];

    useEffect(() => {
        const fetchData = () => {
            fetch(`${lippuurl}/liput`, {
                headers: { 'Authorization' : token }
            })
            .then(response => response.json())
            .then(data => setLiput(data._embedded.lippus))
            .catch(error => console.error(error))
        }
        fetchData();
    }, []);

    useEffect(() => {
        async function fetchURLs() {
            console.log(liput)
            let osoitteet = [];
            for (let i = 0; i < liput.length; i++) {
                osoitteet.push(`${liput[i]._links.self.href}/tapahtumalipputyyppi?projection=lipputyyppi`)
                lippukoodit.push(liput[i].lippukoodi)
            }
            try {
                var data = await Promise.all(osoitteet.map((osoite) => fetch(osoite, {
                headers: { 'Authorization' : token }
            })
                .then((response) => response.json()),
            ));
            setLipputiedot(data)
            console.log('Lipputiedot 1:', lipputiedot)
            } catch (error) {
              console.log(error);
            }
        }
        fetchURLs();
        koodit();
    }, [liput]);

    const koodit = () => {
        for (let i = 0; i < lipputiedot.length; i++) {
            lipputiedot[i].koodi = lippukoodit[i];
        }
        console.log(lippukoodit)
        console.log('Lipputiedot 2:', lipputiedot)
    }

    /*
    for (let i=0; i<lipputiedot.length; i++) {
                    Object.defineProperty(lipputiedot[i], 'koodi', {
                        writable: true,
                        enumerable: true,
                        value: lippukoodit[i]
                    })
                }

    */

    return (
        <div>
        
        <div>
            {lipputiedot.map((lippu, i)=> {
            return (
                <Card sx={ {width: 500, margin: 2, color:'blue'}}>
                    <CardHeader 
                        title={lippu.tapahtuma[0].nimi}
                    />
                    <CardContent>
                        <div key={i}>
                        <Typography sx={{ fontSize: 15 }} color="text.secondary" gutterBottom>
                            Lippukoodi: { lippu.koodi }
                        </Typography>
                        <Typography sx={{ fontSize: 15 }} color="text.secondary" gutterBottom>
                            { lippu.tapahtuma[0].aika }
                        </Typography>
                        <Typography sx={{ fontSize: 15 }} color="text.secondary" gutterBottom>
                            { lippu.tapahtuma[0].osoite }
                        </Typography>
                        <Typography sx={{ fontSize: 15 }} color="text.secondary" gutterBottom>
                            { lippu.tapahtuma[0].kaupunki }
                        </Typography>
                        <Typography sx={{ fontSize: 15 }} color="text.secondary" gutterBottom>
                            Lipputyyppi: { lippu.nimi }
                        </Typography>
                        <Typography  sx={{ fontSize: 15 }}color="text.secondary">
                            Hinta: { lippu.hinta } eur
                        </Typography>
                        </div>
                    </CardContent>  
                </Card>  
            )})}
        </div> 
        </div>
    )
}

export default Liput;

