import { useEffect, useState } from 'react';
import Select from 'react-select'
import axios from "axios";
import Button from '@mui/material/Button';
import { useNavigate, Link } from "react-router-dom";

function Lipunmyynti () {

  const [tapahtuma, setTapahtuma] = useState('')
  const [tapahtumaoptions, setTapahtumaoptions] = useState([""]);
  const [lippuoptions, setLippuoptions] = useState([""]);
  const [maara, setMaara] = useState(0)
  const [lipputyyppi, setLipputyyppi] = useState('')
  const [myyntitapahtuma, setMyyntitapahtuma] = useState('')
  const [status, setStatus] = useState('')
  const [hinta, setHinta] = useState('')

  const token = sessionStorage.getItem("jwt");
  const navigate = useNavigate();

  useEffect(() => {
    if(!token) {
      navigate('/login');
    }
  });
  
  useEffect(() => {
    const getData = async () => {
      const arr = [];
      await axios.get("https://etappi-ticketguru.herokuapp.com/api/tapahtumat/",{
        headers: { 'Authorization' : token }
      }
      ).then((res) => {
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
      await axios.get(url, {
        headers: { 'Authorization' : token }
      }).then((res) => {
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

  const maaraoptions = [
    { label: 1, value: 1 },
    { label: 2, value: 2 },
    { label: 3, value: 3 },
    { label: 4, value: 4 },
    { label: 5, value: 5 },
    { label: 6, value: 6 }
  ]

  const handleChangeMaara = (e) => {
    console.log(e);
    setMaara(e.value);
  }

  const handleChangeLipputyyppi = (e) => {
    console.log(e);
    setLipputyyppi(e.value);
  }

  useEffect(() => {
  const haeHinta = async () => {
    console.log(lipputyyppi)
    await axios.get(lipputyyppi, {
      headers: { 'Authorization' : token }
    })
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
      "kayttaja":"https://etappi-ticketguru.herokuapp.com/api/kayttajat/1",
    },{
      headers: { 'Authorization' : token }
    })
    .then(function (response) {
      console.log(response);
      let res = response.data._links.self.href
      setMyyntitapahtuma(res)
      setStatus('Uusi myyntitapahtuma luotu, lisää liput')
    })
    .catch(function (error) {
      console.log(error);
    });
  };
  
  const lisaaLippu = async () => {
    console.log(lipputyyppi);
    console.log(myyntitapahtuma);
    console.log(hinta)

    for (let i=0; i<maara; i++) {
      await axios.post("https://etappi-ticketguru.herokuapp.com/api/liput/", {
        "tapahtumalipputyyppi": `${lipputyyppi}`,
        "myyntitapahtuma": `${myyntitapahtuma}`,
        "hinta": `${hinta}`
      },{
        headers: { 'Authorization' : token }
      })
      .then(function (response) {
        console.log(response);
        setStatus('Lippu lisätty')
      })
      .catch(function (error) {
        console.log(error);
      });
      }
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

  const ValitseMaara = () => (
    <Select 
      options={maaraoptions}
      placeholder="Valitse määrä"
      onChange={handleChangeMaara}
      />
  )
 
  return (

    <div>
      <Button variant="outlined" onClick={luoMyyntitapahtuma}>Luo myyntitapahtuma</Button>
      <ValitseTapahtuma />
      <ValitseLippu />
      <ValitseMaara />
      <Button variant="outlined" onClick={lisaaLippu}>Lisää liput</Button> 
      <Button variant="outlined"><Link to="/showliput" state={{ lippuurl: myyntitapahtuma} }> Näytä liput</Link></Button>
      <div style={ { color:'red'}}>{status} </div>  
    </div>
  );

}

export default Lipunmyynti;