import React from "react";
import ReactDOM from "react-dom/client";
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Lipputarkistus from "./components/Lipputarkistus";
import Home from "./components/Home";
import Lipunmyynti from "./components/Lipunmyynti"

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
                <Link color="white" to="/">Home</Link>{' '} 
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
          <Route exact path="/" element={<Home />} />
          <Route path="/lipuntarkistus" element={<Lipputarkistus />} />
          <Route path="/lipunmyynti" element={<Lipunmyynti />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
