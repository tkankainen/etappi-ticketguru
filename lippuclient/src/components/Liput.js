import { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import { Card, CardHeader, CardContent, Typography } from '@mui/material';

function Liput () {

    const [liput, setLiput] = useState([]);
    const location = useLocation();
    const { lippuurl } = location.state
    const token = sessionStorage.getItem("jwt");
    const [lipputiedot, setLipputiedot] = useState([]);
    const [naytettavat, setNaytettavat] = useState([]);

    useEffect(() => {
        const fetchData = () => {
            fetch(`${lippuurl}/liput`, {
                headers: { 'Authorization' : token }
            })
            .then(response => response.json())
            .then(data => setLiput(data._embedded.lippus))
            .catch(error => console.error(error))
        }
        fetchData()
    }, []);

    useEffect(() => {
        async function fetchURLs() {
            let osoitteet = [];
            for (let i = 0; i < liput.length; i++) {
                osoitteet.push(`${liput[i]._links.self.href}/tapahtumalipputyyppi?projection=lipputyyppi`)
            }
            try {
                var data = await Promise.all(osoitteet.map((osoite) => fetch(osoite, {
                headers: { 'Authorization' : token }
            })
                .then((response) => response.json()),
            ));
            setLipputiedot(data)
            } catch (error) {
                console.log(error);
            }
        }
        fetchURLs()
    }, [liput]);

    useEffect(() => {
        const luoLipputiedot = () => {
            let tiedot = {}
            let keys = [...new Set([...Object.keys(liput),...Object.keys(lipputiedot)])]
            let merged = keys.forEach(key=>{
                tiedot[key] = {
                    ...liput[key],
                    ...lipputiedot[key]
                }
            })
            console.log('Päivitetty:', tiedot)
            setNaytettavat(tiedot)
        }
    luoLipputiedot()
    }, [lipputiedot]);


    return (
        <div>
            {Object.values(naytettavat).map((lippu)=> {
            return (
                <Card sx={ {width: 500, margin: 2, color:'blue'}}>
                    <CardHeader 
                        title={lippu.tapahtuma[0].nimi}
                    />
                    <CardContent>
                        <div key={lippu.lippukoodi}>
                        <Typography sx={{ fontSize: 15 }} color="text.secondary" gutterBottom>
                            Lippukoodi: { lippu.lippukoodi }
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
    )
}

export default Liput;

