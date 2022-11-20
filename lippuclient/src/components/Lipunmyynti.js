import { useEffect, useState } from 'react';
import Select from 'react-select'
import axios from "axios";
import Button from '@mui/material/Button';
import { Paper } from '@mui/material';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';


function Lipunmyynti () {

  const [tapahtuma, setTapahtuma] = useState('')
  const [tapahtumaoptions, setTapahtumaoptions] = useState([""]);
  const [lippuoptions, setLippuoptions] = useState([""]);
  //const [maara, setMaara] = useState(0)
  const [lipputyyppi, setLipputyyppi] = useState('')
  const [myyntitapahtuma, setMyyntitapahtuma] = useState('')
  const [status, setStatus] = useState('')
  const [hinta, setHinta] = useState('')
 
  const [taulukko, setTaulukko] = useState([]);
  const [lippulinkki,setLippulinkki] = useState('');
  
  const [lippuTapahtuma,setLippuTapahtuma] = useState('');//LippuTapahtuma
  const [lippuAika,setLippuAika] = useState('');//
  const [lippuOsoite,setLippuOsoite] = useState('');//
 
  
  useEffect(() => {
    const getData = async () => {
      const arr = [];
      await axios.get("https://etappi-ticketguru.herokuapp.com/api/tapahtumat/").then((res) => {
        let result = res.data._embedded.tapahtumas;
        result.map((tapahtuma) => {
          return arr.push({value: tapahtuma._links.self.href, label: tapahtuma.nimi});
        });
        console.log(arr);
        setTapahtumaoptions(arr)
       
      });
    };
    getData();
  }, []);

  useEffect(() => {
    console.log(tapahtuma);
    const url = `${tapahtuma.value}/tapahtumalipputyypit`
    console.log(url);
    const getLippu = async () => {
      const arr = [];
      await axios.get(url).then((res) => {
        console.log(res);
        let result = res.data._embedded.tapahtumalipputyyppis;
        result.map((lippu) => {
          return arr.push({value: lippu._links.self.href, label: lippu.nimi});
        });
        setLippuoptions(arr)
      });
    };
    getLippu();
  }, [tapahtuma]);

  /*
  const maaraoptions = [
    { label: 1, value: 1 },
    { label: 2, value: 2 },
    { label: 3, value: 3 },
    { label: 4, value: 4 }
  ]

  const handleChangeMaara = (e) => {
    console.log(e);
    setMaara(e.value);
  }
  */

  const handleChangeLipputyyppi = (e) => {
    console.log(e);
    setLipputyyppi(e.value);
  }

  useEffect(() => {
  const haeHinta = async () => {
    console.log(lipputyyppi)
    await axios.get(lipputyyppi)
    .then(function (response) {
      console.log(response);
      setHinta(response.data.hinta)
      console.log(hinta);
    })
    .catch(function (error) {
      console.log(error);
    });
  };
    haeHinta();
  }, [lipputyyppi]);

  /*
  useEffect(() => {
    luoMyyntitapahtuma()
  }, []);
  */

  const luoMyyntitapahtuma = async () => {
    await axios.post("https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/", {
      "kayttaja":"https://etappi-ticketguru.herokuapp.com/api/kayttajat/1"
    })
    .then(function (response) {
      console.log(response);
      let res = response.data._links.self.href
      let reslink= response.data._links.liput.href
      setLippulinkki(reslink)
      setMyyntitapahtuma(res)
      console.log(res);
      setStatus('Uusi myyntitapahtuma luotu, lisää liput')
      setTaulukko([]);//tyhjennä lippunäkymä
    })
    .catch(function (error) {
      console.log(error);
    });
  };

  const lisaaLippu = async () => {
    console.log(lipputyyppi);
    console.log(myyntitapahtuma);
    console.log(hinta)
    await axios.post("https://etappi-ticketguru.herokuapp.com/api/liput/", {
      "tapahtumalipputyyppi": `${lipputyyppi}`,
      "myyntitapahtuma": `${myyntitapahtuma}`,
      "hinta": `${hinta}`
    })
    .then(function (response) {
      console.log(response);
      setStatus('Lippu lisätty')
    })
    .catch(function (error) {
      console.log(error);
    });
   
  };

  const ValitseTapahtuma = () => (
    <Select 
      options={tapahtumaoptions}
      placeholder="Valitse tapahtuma"
      onChange={setTapahtuma}
      />
  )

  const ValitseLippu = () => (
    <Select 
      options={lippuoptions}
      placeholder="Valitse lipputyyppi"
      onChange={handleChangeLipputyyppi}
      />
  )

  /*
  const ValitseMaara = () => (
    <Select 
      options={maaraoptions}
      placeholder="Valitse määrä"
      onChange={handleChangeMaara}
      />
  )
  const fetchUrl = async () => {
    try {
    //  const response = await fetch('https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/86/liput');
      const response = await fetch(`${lippulinkki}`);
      const json = await response.json();
      //setLippukoodi(response.data._embedded.lippus[0].lippukoodi);
      setTaulukko(json._embedded.lippus);
      setVirhe('');
    } catch (error) {
      setVirhe('Tietojen haku ei onnistunut');
    }
  }

 // useEffect(() => {
//    fetchUrl();
//  }, []);

  <ValitseMaara /> otettu pois return-kohdasta toistaiseksi
  */

  const fetchUrl = async () => {
    try {
      const response = await fetch(`${lippulinkki}`);
      const json = await response.json();
      setTaulukko(json._embedded.lippus);
      setStatus('');
      fetchLippuTapahtuma();
      
    } catch (error) {
      setStatus('Tietojen haku ei onnistunut');
    }
  }
 
  const fetchLippuTapahtuma = async () => {
    try {
      const response = await fetch(`${lipputyyppi}/tapahtuma`);
      const json = await response.json();
      setLippuTapahtuma(json.nimi);
      setLippuAika(json.aika);
      setLippuOsoite(json.kaupunki);
      setStatus('');
    } catch (error) {
      setStatus('Tietojen haku ei onnistunut');
    }
  } 

  return (
  <Paper>
    <div>
    <Button variant="outlined" onClick={luoMyyntitapahtuma}>Luo myyntitapahtuma</Button>
      <ValitseTapahtuma />
      <ValitseLippu />
      <Button variant="outlined" onClick={lisaaLippu}>Lisää liput</Button>   
      <Button variant="outlined" onClick={fetchUrl}>Näytä liput</Button>
      <div style={ { color:'red'}}>{status} </div>  
    </div>
   
    <div>
    {
      taulukko.map(ticket=> {
        return (
    <Card sx={ {width: 500, margin: 2, color:'blue'}}>
             <CardHeader 
               title={lippuTapahtuma}   /><br></br> 
      <CardContent>
        <div key={ticket.lippukoodi } >
             <Typography sx={{ fontSize: 15 }} color="text.secondary" gutterBottom>
               { lippuAika }
             </Typography>
             <Typography sx={{ fontSize: 15 }} color="text.secondary" gutterBottom>
               { lippuOsoite }
            </Typography>
            <Typography  sx={{ fontSize: 20 }}color="text.secondary">
                Lippukoodi: <br></br>
            </Typography>
             <Typography variant="h5" component="div" color="blue">
               { ticket.lippukoodi }<br></br> <br></br>
            </Typography>
            <Typography  sx={{ fontSize: 20 }}color="text.secondary">
               Hinta:
           </Typography>
            <Typography variant="body2" sx={{ fontSize: 20 }} color="blue">
               { ticket.hinta } eur <br></br> <br></br>
           </Typography>
            <Typography  sx={{ fontSize: 10 }}color="text.secondary">
               {'Lippu näytettävä ovella'} <br></br>
              {'Liput toimittaa, TicketGuru'}
          </Typography>
        </div>
      </CardContent>  
    </Card>  
        )
      })
    }
    </div> 
   
  
  </Paper>
   
    
  );

}

export default Lipunmyynti;