import React from "react";
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Lipputarkistus from "./components/Lipputarkistus";
import Lipunmyynti from "./components/Lipunmyynti"
import Tapahtumat from "./components/Tapahtumat";
import NaytaLiput from "./components/NaytaLiput";
import Lipputyypit from "./components/Lipputyypit";
import Login from "./components/Login";
import Logout from "./components/Logout";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <AppBar position="static">
            <Toolbar>
              <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                Ticket Guru
              </Typography>
              <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                <Link to="/tapahtumat">Tapahtumat</Link>{' '} 
              </Typography>
              <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                <Link to="/lipunmyynti">Lipunmyynti</Link>{' '} 
              </Typography>
              <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                <Link to="/lipuntarkistus">Lipuntarkistus</Link>{' '} 
              </Typography>
            </Toolbar>
        </AppBar>
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route path="/login" element={<Login />} />
          <Route path="/logout" element={<Logout />} />
          <Route path="/tapahtumat" element={<Tapahtumat />} />
          <Route path="/lipuntarkistus" element={<Lipputarkistus />} />
          <Route path="/lipunmyynti" element={<Lipunmyynti />} />
          <Route path="/liput" element={<NaytaLiput />} />
          <Route path="/lipputyypit" element={<Lipputyypit />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
